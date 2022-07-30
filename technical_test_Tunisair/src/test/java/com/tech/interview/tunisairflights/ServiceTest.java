package com.tech.interview.tunisairflights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.tech.interview.tunisairflights.domain.TunisAirRequest;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import com.tech.interview.tunisairflights.persistence.TunisairRepository;
import com.tech.interview.tunisairflights.service.TunisairService;
import com.tech.interview.tunisairflights.util.mapper.EntityResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @InjectMocks
    TunisairService service;

    @Mock
    TunisairRepository repository;

    @Test
    public void testFindAll() {
        List<TunisairFlight> list = new ArrayList<>();
        TunisairFlight flight_1 = new TunisairFlight("Tunisair", 10.2, "E", "TUN", "FRA", new Date(), new Date(), 5);
        TunisairFlight flight_2 = new TunisairFlight("Tunisair", 11.2, "B", "TUN", "FRA", new Date(), new Date(), 10);
        TunisairFlight flight_3 = new TunisairFlight("Tunisair", 12.2, "E", "TUN", "FRA", new Date(), new Date(), 23);

        list.add(flight_1);
        list.add(flight_2);
        list.add(flight_3);

        when(repository.findAll()).thenReturn(list);

        //test
        List<TunisairFlight> flightList = service.findAll();

        assertEquals(3, flightList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveTunisairFlight() {

        TunisairFlight flight = new TunisairFlight("Tunisair", 12.2, "E", "TUN", "FRA", new Date(), new Date(), 23);

        service.save(flight);

        verify(repository, times(1)).save(flight);
    }
}
