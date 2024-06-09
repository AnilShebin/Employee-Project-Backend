package com.groot.anil.service;

import com.groot.anil.entity.Permission;
import com.groot.anil.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission addPermission(String permissionName) {
        Permission permission = new Permission();
        permission.setPermissionName(permissionName);
        return permissionRepository.save(permission);
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(int id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    public Permission updatePermission(int id, String permissionName) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        permission.setPermissionName(permissionName);
        return permissionRepository.save(permission);
    }

    public void deletePermission(int id) {
        permissionRepository.deleteById(id);
    }
}