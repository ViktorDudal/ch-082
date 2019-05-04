package ua.softserve.ita.dao.impl;

import org.springframework.stereotype.Repository;
import ua.softserve.ita.dao.ContactDao;
import ua.softserve.ita.dao.impl.AbstractDao;
import ua.softserve.ita.model.profile.Contact;

@Repository
public class ContactDaoImpl extends AbstractDao<Contact,Long> implements ContactDao {

}
