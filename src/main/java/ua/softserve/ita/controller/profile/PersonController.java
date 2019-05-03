package ua.softserve.ita.controller.profile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.softserve.ita.model.profile.Person;
import ua.softserve.ita.service.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/people")
@Api(value = "PersonControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @Resource(name = "personService")
    private Service<Person> personService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(value = "Get the person with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Person.class)})
    public Person findById(@PathVariable("id") long id) {
        return personService.findById(id);
    }

    @GetMapping()
    @ApiOperation(value = "Get all people")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = List.class)})
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new person")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Person.class)})
    public Person create(@Valid @RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping()
    @ApiOperation(value = "Update person")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Person.class)})
    public Person update(@Valid @RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete the person with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public void deleteById(@PathVariable("id") long id) {
        personService.deleteById(id);
    }

}
