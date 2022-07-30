package com.tech.interview.rmsflights;

import com.tech.interview.rmsflights.controller.RMSFlightController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    RMSFlightController controller;

    @Test
    public void contextLoads() {
        Assertions.assertTrue(controller != null);
    }
}
