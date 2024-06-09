package com.groot.anil.controller;

import com.groot.anil.entity.Role;
import com.groot.anil.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestParam int employeeId,
                                        @RequestParam String roleName,
                                        @RequestParam String description,
                                        @RequestParam List<Integer> permissionIds) {
        Role role = roleService.addRole(employeeId, roleName, description, permissionIds);
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        Role role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id,
                                           @RequestParam String roleName,
                                           @RequestParam String description,
                                           @RequestParam List<Integer> permissionIds) {
        Role updatedRole = roleService.updateRole(id, roleName, description, permissionIds);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}