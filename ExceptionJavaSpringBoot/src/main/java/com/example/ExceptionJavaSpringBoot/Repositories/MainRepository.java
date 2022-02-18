package com.example.ExceptionJavaSpringBoot.Repositories;

import com.example.ExceptionJavaSpringBoot.Models.Role;
import com.example.ExceptionJavaSpringBoot.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainRepository {

    // START ROLE_METHODS
    @Autowired
    RoleRepo roleRepo;
    public List<Role> getAllRole() {
        return roleRepo.getRoleList();
    }

    public void addRoleToRepo(Role role) {
        roleRepo.addNewRole(role);
    }

    public void editRoleFromSource(Role role, int index) {roleRepo.editRole(role, index);}

    public void deleteRoleFromSource(int index) {roleRepo.deleteRole(index);}

    public List<String> getRoleIDs() {return roleRepo.getRoleIDs();}
    //END ROLE_METHODS

    //START USER_METHODS
    @Autowired
    UserRepo userRepo;
    public List<User> getAllUser() { return userRepo.getUserList(); }

    public void addUserToRepo(User user) {
        userRepo.addUser(user);
    }

    public void editUserFromSource(int index, User user) {
        userRepo.editUser(user, index);
    }

    public void deleteUserFromSource(int index) {
        userRepo.deleteUser(index);
    }
    //END USER_METHODS
}
