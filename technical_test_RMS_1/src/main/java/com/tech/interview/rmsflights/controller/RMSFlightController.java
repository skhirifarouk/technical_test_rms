package com.tech.interview.rmsflights.controller;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.service.RMSService;
import io.swagger.annotations.*;
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
public class RMSFlightController {

    /**
     * Service bean
     */
    @Autowired
    RMSService NouvelairService;

    /**
     * Get all data
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Finds all flights",
            response = NouvelairResponse.class,
            responseContainer = "List")
    public ResponseEntity<List<NouvelairResponse>> getAll() {
        return null;
    }


    /**
     * Get data by request
     * @param request
     * @return
     */
    @GetMapping("/by_request")
    @ApiOperation(value = "Finds flights by request",
            response = NouvelairResponse.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departureDate", value = "Departure date : ISO_LOCAL_DATE format (yyyy-mm_dd)", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "returnDate", value = "Arrival date : ISO_LOCAL_DATE format (yyyy-mm_dd)", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "origin", value = "Origin country : ISO country code", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "destination", value = "Destination country : ISO country code", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "passengerCount", value = "Passenger count", required = false, dataType = "long", paramType = "query")

    })
    public ResponseEntity<List<NouvelairResponse>> getByParams(@Valid NouvelairRequest request) {
        return null;
    }


    /**
     * Save new entry
     * @param nouvelairFlight
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "Save flight entity",
            response = NouvelairRequest.class)
    public ResponseEntity<NouvelairRequest> save(@ApiParam(value = "Flight entity to save") @Valid @RequestBody final NouvelairRequest nouvelairFlight) {
        return null;
    }
}
