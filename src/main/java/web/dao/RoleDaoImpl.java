package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RoleDaoImpl() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> allRoles() {
        return (List<Role>) entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(Role role) {
        int id = role.getId();
        Role delRole = entityManager.find(Role.class, id);
        entityManager.remove(delRole);
    }

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }
}
