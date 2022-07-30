package com.tech.interview.nouvelairflights;

import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import com.tech.interview.nouvelairflights.persistence.NouvelairRepository;
import com.tech.interview.nouvelairflights.service.NouvelairService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @InjectMocks
    NouvelairService service;

    @Mock
    NouvelairRepository repository;

    @Test
    public void testFindAll() {
        List<NouvelairFlight> list = new ArrayList<>();
        NouvelairFlight flight_1 = new NouvelairFlight("Nouvelair", 10.2, 10.2, 10.2, "TUN", "FRA", new Date(), new Date(), 5);
        NouvelairFlight flight_2 = new NouvelairFlight("Nouvelair", 11.2, 11.2, 11.2, "TUN", "FRA", new Date(), new Date(), 10);
        NouvelairFlight flight_3 = new NouvelairFlight("Nouvelair", 12.2, 12.2, 12.2, "TUN", "FRA", new Date(), new Date(), 23);

        list.add(flight_1);
        list.add(flight_2);
        list.add(flight_3);

        when(repository.findAll()).thenReturn(list);

        //test
        List<NouvelairFlight> flightList = service.findAll();

        assertEquals(3, flightList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveNouvelairFlight() {

        NouvelairFlight flight = new NouvelairFlight("Nouvelair", 12.2, 12.2, 12.2, "TUN", "FRA", new Date(), new Date(), 23);

        service.save(flight);

        verify(repository, times(1)).save(flight);
    }
}
