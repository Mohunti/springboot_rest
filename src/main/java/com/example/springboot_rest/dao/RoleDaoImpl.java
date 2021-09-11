package com.example.springboot_rest.dao;

import com.example.springboot_rest.models.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select role from Role role").getResultList();
    }

    @Override
    public Role findRoles(String role) {
        Role role1 = entityManager.createQuery("select role from Role role where role.role = :name",Role.class).setParameter("name",role).getSingleResult();
        return role1;
    }

    @Override
    public void save(Role role) {
        entityManager.merge(role);
    }
}
