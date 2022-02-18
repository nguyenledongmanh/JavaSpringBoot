package com.example.ExceptionJavaSpringBoot.Services;

import com.example.ExceptionJavaSpringBoot.Models.Role;
import com.example.ExceptionJavaSpringBoot.Models.User;
import com.example.ExceptionJavaSpringBoot.Repositories.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class BusinessServices {

    @Autowired
    MainRepository mainRepository;

    //PUBLIC ROLE METHODS
    public List<Role> getAllRole() {
        Map<String, Role> roleMap = new HashMap<>();
        List<Role> roleList = mainRepository.getAllRole();
        for (Role role:roleList) {
            roleMap.put(role.getId(),role);
        }
        return new ArrayList<>(roleMap.values());
    }

    public Role addRole(Role role) {
        if (!checkExist(role)) {
            mainRepository.addRoleToRepo(role);
            return role;
        }
        return null;
    }

    public Role editRole(Role role, String id) {
        int index = checkExist(id);
        if (index != -1) {
            mainRepository.editRoleFromSource(role, index);
            return role;
        }
        return null;
    }

    public Role deleteRoleByID(String id) {
        int index = checkExist(id);
        if (index != -1) {
            Role roleDeleted = mainRepository.getAllRole().get(index);
            mainRepository.deleteRoleFromSource(index);
            return roleDeleted;
        }
        return null;
    }

    // PRIVATE ROLE METHODS
    private boolean checkExist(Role role) {
        List<Role> roleList = mainRepository.getAllRole();
        for (Role roleCMP : roleList) {
            if (Objects.equals(role.getId(), roleCMP.getId()))
                return true;
        }
        return false;
    }

    private int checkExist(String id) {
        List<Role> roleList = mainRepository.getAllRole();
        for (int i = 0; i < roleList.size(); i++) {
            if(id.equals(roleList.get(i).getId()))
                return i;
        }
        return -1;
    }
    //END ROLE METHODS

    //PUBLIC USER METHODS
    public List<User> getAllUser() {
        Map<String, User> userMap = new HashMap<>();
        List<User> userList = mainRepository.getAllUser();
        for (User user : userList) {
            userMap.put(user.getId(), user);
        }
        return new ArrayList<>(userMap.values());
    }

    public User addUser(User user) {
        if (!checkExist(user) && checkAvailableRoleIDs(user.getRoleList())) {
            mainRepository.addUserToRepo(user);
            return user;
        }
        return null;
    }

    public User editUser(User user, String id) {
        int index = checkUserExist(id);
        if (index != -1 && checkAvailableRoleIDs(user.getRoleList())) {
            mainRepository.editUserFromSource(index, user);
            return user;
        }
        return null;
    }

    public User deleteUserByID(String id) {
        int index = checkUserExist(id);
        if (index != -1) {
            User userDeleted = mainRepository.getAllUser().get(index);
            mainRepository.deleteUserFromSource(index);
            return userDeleted;
        }
        return null;
    }

    // PRIVATE USER METHODS
    private boolean checkExist(User user) {
        List<User> userList = mainRepository.getAllUser();
        for (User userCMP : userList) {
            if (Objects.equals(userCMP.getId(), user.getId()))
                return true;
        }
        return false;
    }

    private int checkUserExist(String userID) {
        List<User> userList = mainRepository.getAllUser();
        for (int i = 0; i < userList.size(); i++) {
            if(userID.equals(userList.get(i).getId()))
                return i;
        }
        return -1;
    }

    private boolean checkAvailableRoleIDs(List<String> userRoleIDs) {
        int flag = 0, numOfIDs = userRoleIDs.size();
        boolean checkExist = true;
        List<String> RoleIDs = mainRepository.getRoleIDs();
        for (String id : userRoleIDs) {
            int run = 0;
            for (String roleID : RoleIDs) { // maybe Using another Search algorithm
                if (id.equals(roleID)) {
                    flag += 1;
                    break;
                }
                run += 1;
            }
            if (run == RoleIDs.size()) {
                checkExist = false;
                break;
            }
        }
        return checkExist && flag <= numOfIDs;
    }
    //END USER METHODS
}
