package ua.softserve.ita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.ita.dao.UserDao;
import ua.softserve.ita.dao.UserDetailsDao;
import ua.softserve.ita.model.User;

import java.util.logging.Logger;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    private static final Logger lOGGER = Logger.getLogger(UserDetailsServiceImp.class.getName());

    @Autowired
    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImp(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findUserByUsername(username);
        if (user != null) {
            lOGGER.severe("Our user " + user);
            return user;
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
