package com.tech.interview.nouvelairflights;

import com.tech.interview.nouvelairflights.controller.NouvelairFlightController;
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
    NouvelairFlightController controller;

    @Test
    public void contextLoads() {
        Assertions.assertTrue(controller != null);
    }
}
