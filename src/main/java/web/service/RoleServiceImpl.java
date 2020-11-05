package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao dao;

    @Autowired
    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Role> allRoles() {
        return dao.allRoles();
    }

    @Override
    public void add(Role role) {
        dao.add(role);
    }

    @Override
    public void edit(Role role) {
        dao.edit(role);
    }

    @Override
    public void delete(Role role) {
        dao.delete(role);
    }

    @Override
    public Role getById(int id) {
        return dao.getById(id);
    }

    @Override
    public Role getByName(String name) {
        return dao.getByName(name);
    }
}
