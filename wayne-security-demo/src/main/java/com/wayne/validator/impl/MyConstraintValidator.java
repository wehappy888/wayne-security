package com.wayne.validator.impl;

import com.wayne.service.HelloService;
import com.wayne.validator.MyConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author wayne
 * @date 2019/4/4
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my constraint validator init...");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        helloService.hello("wayne");

        System.out.println(o);

        return true;
    }
}
