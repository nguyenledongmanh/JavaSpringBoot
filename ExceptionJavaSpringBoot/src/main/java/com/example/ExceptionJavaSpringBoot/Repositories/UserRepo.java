package com.example.ExceptionJavaSpringBoot.Repositories;

import com.example.ExceptionJavaSpringBoot.Models.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class UserRepo {
    private final List<User> userList = new ArrayList<>();

    protected void addUser(User user) { userList.add(user);}

    protected void editUser(User user, int index) {
        userList.get(index).setName(user.getName());
        userList.get(index).setRoleList(user.getRoleList());
    }

    protected void deleteUser(int index) {
        userList.remove(index);
    }
}
