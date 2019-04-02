package com.wayne.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wayne.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author waynewang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> userList(@RequestParam(value = "userName", required = false, defaultValue = "wayne") String userName) {

        System.out.println(userName);

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id) {

        User user = new User();
        user.setUserName("wayne");

        return user;
    }

}
