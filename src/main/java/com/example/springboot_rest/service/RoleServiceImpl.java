package com.example.springboot_rest.service;

import com.example.springboot_rest.dao.RoleDao;
import com.example.springboot_rest.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao dao;

    @Override
    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }

    @Override
    public Role findRoles(String role) {
        return dao.findRoles(role);
    }

    @Override
    public void save(Role role) {
        dao.save(role);

    }
}
