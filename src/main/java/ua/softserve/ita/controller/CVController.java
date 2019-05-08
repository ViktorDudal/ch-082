package ua.softserve.ita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.ita.model.CV;
import ua.softserve.ita.model.Job;
import ua.softserve.ita.model.Skill;
import ua.softserve.ita.model.profile.Person;
import ua.softserve.ita.service.CVService;
import ua.softserve.ita.service.JobService;
import ua.softserve.ita.service.SkillService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
public class CVController {
    private final CVService cvService;
    private final JobService jobService;
    private final SkillService skillService;

    @Autowired
    public CVController(CVService cvService, JobService jobService, SkillService skillService) {
        this.cvService = cvService;
        this.jobService = jobService;
        this.skillService = skillService;
    }

    @GetMapping(path = {"/cv/{id}"})
    public Optional<CV> findById(@PathVariable("id") long id) {
        return cvService.findById(id);
    }

    @GetMapping(path = {"/cvs"})
    public List<CV> findAll() {
        return cvService.findAll();
    }

    @PostMapping(path = "/createCV")
    public CV insert(@RequestBody CV cv) {
        Person person = new Person();
        person.setUserId(1L);
        cv.setPerson(person);

        Set<Skill> skills = cv.getSkills();
        Set<Job> jobs = cv.getJobs();
        skills.forEach(x -> x.setCv(cv));
        jobs.forEach(x -> x.setCv(cv));

        cvService.save(cv);
        return cv;
    }

    @PutMapping(path = "/updateCV")
    public CV update(@RequestBody CV cv) {
        return cvService.update(cv);
    }

    @DeleteMapping(path = "/deleteCV/{id}")
    public void deleteById(@PathVariable("id") long id) {
        cvService.deleteById(id);
    }

}
