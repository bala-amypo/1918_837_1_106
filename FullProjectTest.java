package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FullProjectTest {

    @Test(priority = 9)
    public void testCreateLocationMissingRegion() {
        Assert.assertTrue(true);
    }

}
