package web.service;

import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    void add (Role role);

    void edit (Role role);

    void delete (Role role);

    Role getById (int id);
}
