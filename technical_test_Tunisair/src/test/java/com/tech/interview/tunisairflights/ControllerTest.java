package com.tech.interview.tunisairflights;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.tech.interview.tunisairflights.controller.TunisairFlightController;
import com.tech.interview.tunisairflights.domain.TunisairResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TunisairFlightController.class)
public class ControllerTest {

    @MockBean
    TunisairFlightController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {

        // Create object
        TunisairResponse flight = new TunisairResponse(
                "Tunisair",
                80.3,
                "E",
                "TUN",
                "FRA",
                String.valueOf(new Date()),
                String.valueOf(new Date()));

        List<TunisairResponse> flightList = Arrays.asList(flight);

        Mockito.when(controller.getAll()).thenReturn(ResponseEntity.ok(flightList));

        mockMvc.perform(get("/flight/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].airline", Matchers.is("Tunisair")));
    }
}
