package com.wayne.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.wayne.dto.User;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author waynewang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> userList(@RequestParam(value = "userName", required = false, defaultValue = "wayne") String userName,
                               @PageableDefault(size = 15, page = 1) Pageable page) {

        logger.info(ReflectionToStringBuilder.toString(page, ToStringStyle.MULTI_LINE_STYLE));

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

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {

            List<ObjectError> allErrors = errors.getAllErrors();
            allErrors.forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getBirthday().getTime());
        logger.info("user :{}", new Gson().toJson(user));

        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

}
