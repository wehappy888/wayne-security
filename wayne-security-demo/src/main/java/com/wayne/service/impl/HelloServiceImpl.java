package com.wayne.service.impl;

import com.wayne.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author wayne
 * @date 2019/4/4
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        System.out.println("hello "+name);
        return "hello "+name;
    }
}
