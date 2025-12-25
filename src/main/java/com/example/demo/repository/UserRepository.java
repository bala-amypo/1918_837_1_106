package com.example.demo;

import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.repository.UserRepository;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FullProjectTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeMethod
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void sampleTest() {
        Assert.assertTrue(true);
    }
}
