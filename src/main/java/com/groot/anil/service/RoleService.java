package com.groot.anil.service;

import com.groot.anil.entity.Employee;
import com.groot.anil.entity.Permission;
import com.groot.anil.entity.Role;
import com.groot.anil.repository.EmployeeRepository;
import com.groot.anil.repository.PermissionRepository;
import com.groot.anil.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public Role addRole(int employeeId, String roleName, String description, List<Integer> permissionIds) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Permission> permissions = permissionRepository.findAllById(permissionIds);

        Role role = new Role();
        role.setEmployee(employee);
        role.setRoleName(roleName);
        role.setDescription(description);
        role.setCreatedDate(new Date());
        role.setModifiedDate(new Date());
        role.setPermissions(permissions);

        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(int id, String roleName, String description, List<Integer> permissionIds) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setRoleName(roleName);
        role.setDescription(description);
        role.setModifiedDate(new Date());

        List<Permission> permissions = permissionRepository.findAllById(permissionIds);
        role.setPermissions(permissions);

        return roleRepository.save(role);
    }
}
