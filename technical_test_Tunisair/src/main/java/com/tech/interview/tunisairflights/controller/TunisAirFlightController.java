package com.tech.interview.tunisairflights.controller;

import com.tech.interview.tunisairflights.domain.tunisair.TunisAirRequest;
import com.tech.interview.tunisairflights.domain.tunisair.TunisairResponse;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import com.tech.interview.tunisairflights.service.TunisairService;
import com.tech.interview.tunisairflights.util.mapper.service.mapper.EntityResponseMapperHelper.TunisAirModelResponseMapperHelperHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller
 */
@Api(value = "/flight", description = "Nouvelair Flight API")
@RestController
@RequestMapping("/flight")
public class TunisAirFlightController {

    /**
     * Service bean
     */
    @Autowired
    TunisairService tunisairService;

    /**
     * Get all data
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Finds all flights",
            response = TunisairResponse.class,
            responseContainer = "List")
    public ResponseEntity<List<TunisairResponse>> getAll() {
        return ResponseEntity.ok(TunisAirModelResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(tunisairService.findAll()));
    }


    /**
     * Get data by request
     * @param request
     * @return
     */
    @GetMapping("/by_request")
    public ResponseEntity<List<TunisairResponse>> getByParams(@Valid TunisAirRequest request) {
        return ResponseEntity.ok(TunisAirModelResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(tunisairService.findByRequest(request)));
    }


    /**
     * Save new entry
     * @param tunisAirFlight
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<TunisairFlight> save(@Valid @RequestBody final TunisairFlight tunisAirFlight) {
        return ResponseEntity.ok(tunisairService.save(tunisAirFlight));
    }
}
