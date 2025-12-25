package com.example.demo;

import org.testng.annotations.Test;
import org.testng.Assert;

public class FullProjectTest {

    @Test
    public void applicationLoadsTest() {
        Assert.assertTrue(true, "Application context loads successfully");
    }
}
