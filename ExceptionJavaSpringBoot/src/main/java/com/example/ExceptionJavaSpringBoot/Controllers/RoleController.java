package com.example.ExceptionJavaSpringBoot.Controllers;

import com.example.ExceptionJavaSpringBoot.Exception.RoleException;
import com.example.ExceptionJavaSpringBoot.Models.Role;
import com.example.ExceptionJavaSpringBoot.Services.BusinessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Role")
public class RoleController {
    @Autowired
    BusinessServices businessServices;

    @GetMapping("/getRole")
    public List<Role> getAllRole() {
        return businessServices.getAllRole();
    }

    @PostMapping("/addRole")
    public Role addNewRole(@RequestBody Role role) throws RoleException {
        Role roleAdded = businessServices.addRole(role);
        if (roleAdded != null) {
            return roleAdded;
        }
        throw new RoleException("406", "ID is exist. Try another ID or edit information!");
    }

    @PutMapping("/editRole/{id}")
    public Role editRole(@PathVariable String id, @RequestBody Role newRole) throws RoleException {
        Role roleEdited = businessServices.editRole(newRole, id);
        if(roleEdited != null)
            return roleEdited;
        throw new RoleException("404", "ID is NOT FOUND !!! Try to edit another ID");
    }

    @DeleteMapping("/deleteRole/{id}")
    public Role deleteRole(@PathVariable String id) throws RoleException {
        Role roleDeleted = businessServices.deleteRoleByID(id);
        if (roleDeleted != null)
            return roleDeleted;
        throw new RoleException("404", "ID is NOT FOUND !!! Try to edit exist ID");
    }
}
