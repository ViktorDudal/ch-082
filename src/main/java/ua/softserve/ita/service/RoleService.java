package ua.softserve.ita.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.ita.dao.Dao;
import ua.softserve.ita.model.Role;

import javax.annotation.Resource;
import java.util.List;

@Component("roleService")
@org.springframework.stereotype.Service
@Transactional
public class RoleService implements Service<Role> {

    @Resource(name = "roleDao")
    private Dao<Role> roleDao;

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Long insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public Long update(Role role, Long id) {
        return roleDao.update(role, id);
    }

    @Override
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

}
