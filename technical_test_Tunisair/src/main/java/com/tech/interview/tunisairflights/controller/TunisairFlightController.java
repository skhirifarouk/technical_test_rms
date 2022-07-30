package com.tech.interview.tunisairflights.controller;

import com.tech.interview.tunisairflights.domain.TunisAirRequest;
import com.tech.interview.tunisairflights.domain.TunisairResponse;
import com.tech.interview.tunisairflights.model.TunisairFlight;
import com.tech.interview.tunisairflights.service.TunisairService;
import com.tech.interview.tunisairflights.util.mapper.EntityResponseMapperHelper.TunisAirModelResponseMapperHelperHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller : Tunisair flight endpoints
 */
@Api(value = "/flight", description = "Tunisair flight API")
@RestController
@RequestMapping("/flight")
public class TunisairFlightController {

    /**
     * Service bean
     */
    @Autowired
    TunisairService tunisairService;

    /**
     * Get all data
     *
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
     * Get Tunisair response data by request
     * Empty parameters will not be taken into account
     *
     * @param request
     * @return
     */
    @GetMapping("/by_request")
    @ApiOperation(value = "Finds flights by request",
            response = TunisairResponse.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departureDate", value = "Departure date : ISO_LOCAL_DATE format (yyyy-mm_dd)", example = "2022-01-01", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "returnDate", value = "Arrival date : ISO_LOCAL_DATE format (yyyy-mm_dd)", example = "2022-01-01", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "origin", value = "Origin country : ISO country code", example = "Tunisair", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "destination", value = "Destination country : ISO country code", example = "TUN", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "passengerCount", value = "Passenger count", example = "FRA", required = false, dataType = "long", paramType = "query")

    })
    public ResponseEntity<List<TunisairResponse>> getByParams(@Valid TunisAirRequest request) {
        return ResponseEntity.ok(TunisAirModelResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(tunisairService.findByRequest(request)));
    }

    /**
     * Save new entry
     *
     * @param tunisAirFlight
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<TunisairFlight> save(@Valid @RequestBody final TunisairFlight tunisAirFlight) {
        return ResponseEntity.ok(tunisairService.save(tunisAirFlight));
    }
}
