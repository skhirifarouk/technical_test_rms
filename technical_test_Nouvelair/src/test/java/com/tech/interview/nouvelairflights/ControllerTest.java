package com.tech.interview.nouvelairflights;

import com.tech.interview.nouvelairflights.controller.NouvelairFlightController;
import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(NouvelairFlightController.class)
public class ControllerTest {

    @MockBean
    NouvelairFlightController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {

        // Create object
        NouvelairResponse flight = new NouvelairResponse(
                "Nouvelair",
                80.3,
                30.8,
                50.6,
                "TUN",
                "FRA",
                String.valueOf(new Date()),
                String.valueOf(new Date()));

        List<NouvelairResponse> flightList = Arrays.asList(flight);

        Mockito.when(controller.getAll()).thenReturn(ResponseEntity.ok(flightList));

        mockMvc.perform(get("/flight/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].carrier", Matchers.is("Nouvelair")));
    }
}
