package com.example.ExceptionJavaSpringBoot.Repositories;

import com.example.ExceptionJavaSpringBoot.Models.Role;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class RoleRepo {
    private final List<Role> roleList = new ArrayList<>();
    private final List<String> roleIDs = new ArrayList<>();

    protected void addNewRole(Role role) {
        roleList.add(role);
        roleIDs.add(role.getId());
    }

    protected void editRole(Role role, int index) {
        roleList.get(index).setName(role.getName());
    }

    protected void deleteRole(int index) {
        roleList.remove(index);
        roleIDs.remove(index);
    }
}
