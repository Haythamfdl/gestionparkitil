package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Model.Permission;
import com.sid.gestionparkitil.gestionparkitil.Repo.PermissionRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PermissionController {
    private PermissionRepo permissionRepo;

    public PermissionController(PermissionRepo permissionRepo) {
        this.permissionRepo = permissionRepo;
    }

    @GetMapping("/permissions")
    public List<Permission> getPermissions() {
        return permissionRepo.findAll();
    }
}
