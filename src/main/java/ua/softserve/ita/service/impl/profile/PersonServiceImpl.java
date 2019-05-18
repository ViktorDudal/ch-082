package ua.softserve.ita.service.impl.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.ita.dao.PersonDao;
import ua.softserve.ita.dao.UserDao;
import ua.softserve.ita.exception.ResourceNotFoundException;
import ua.softserve.ita.model.User;
import ua.softserve.ita.model.profile.Person;
import ua.softserve.ita.service.PersonService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static ua.softserve.ita.utility.LoggedUserUtil.getLoggedUser;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final UserDao userDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, UserDao userDao) {
        this.personDao = personDao;
        this.userDao = userDao;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personDao.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    public Person update(Person person) {

        if (getLoggedUser().isPresent()) {
            User user = userDao.findById(getLoggedUser().get().getUserID()).orElseThrow(() -> new ResourceNotFoundException("Person with id: %d was not found"));
            person.setUser(user);
        }
        return personDao.update(person);
    }

    @Override
    public void deleteById(Long id) {
        personDao.deleteById(id);
    }

}
