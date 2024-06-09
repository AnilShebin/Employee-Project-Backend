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

    public Role addRole(Role role) {
        Employee employee = employeeRepository.findById(role.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Permission> permissions = permissionRepository.findAllById(
                role.getPermissions().stream().map(Permission::getId).toList()
        );

        role.setEmployee(employee);
        role.setPermissions(permissions);
        role.setCreatedDate(new Date());
        role.setModifiedDate(new Date());

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

    public Role updateRole(int id, Role role) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Employee employee = employeeRepository.findById(role.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Permission> permissions = permissionRepository.findAllById(
                role.getPermissions().stream().map(Permission::getId).toList()
        );

        existingRole.setRoleName(role.getRoleName());
        existingRole.setDescription(role.getDescription());
        existingRole.setModifiedDate(new Date());
        existingRole.setEmployee(employee);
        existingRole.setPermissions(permissions);

        return roleRepository.save(existingRole);
    }
}
