package com.tech.interview.tunisairflights;

import com.tech.interview.tunisairflights.controller.TunisairFlightController;
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
    TunisairFlightController controller;

    @Test
    public void contextLoads() {
        Assertions.assertTrue(controller != null);
    }
}
