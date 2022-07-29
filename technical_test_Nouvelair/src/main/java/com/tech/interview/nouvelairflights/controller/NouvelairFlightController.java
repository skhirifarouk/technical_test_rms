package com.tech.interview.nouvelairflights.controller;

import com.tech.interview.nouvelairflights.util.mapper.service.mapper.EntityResponseMapperHelper.NouvelairModelResponseMapperHelperHolder;
import com.tech.interview.nouvelairflights.domain.NouvelairRequest;
import com.tech.interview.nouvelairflights.domain.NouvelairResponse;
import com.tech.interview.nouvelairflights.model.NouvelairFlight;
import com.tech.interview.nouvelairflights.service.NouvelairService;
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
public class NouvelairFlightController {

    /**
     * Service bean
     */
    @Autowired
    NouvelairService NouvelairService;

    /**
     * Get all data
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Finds all flights",
            response = NouvelairResponse.class,
            responseContainer = "List")
    public ResponseEntity<List<NouvelairResponse>> getAll() {
        return ResponseEntity.ok(NouvelairModelResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(NouvelairService.findAll()));
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
            @ApiImplicitParam(name = "outboundDate", value = "Outbound date : ISO_LOCAL_DATE format (yyyy-mm_dd)", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "inboundDate", value = "Inbound date : ISO_LOCAL_DATE format (yyyy-mm_dd)", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "from", value = "Origin country : ISO country code", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "to", value = "Destination country : ISO country code", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "numberOfAdults", value = "Adults count", required = false, dataType = "long", paramType = "query")

    })
    public ResponseEntity<List<NouvelairResponse>> getByParams(@Valid NouvelairRequest request) {
        return ResponseEntity.ok(NouvelairModelResponseMapperHelperHolder.INSTANCE.modelToResponseListMapper(NouvelairService.findByRequest(request)));
    }


    /**
     * Save new entry
     * @param nouvelairFlight
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "Save flight entity",
            response = NouvelairFlight.class)
    public ResponseEntity<NouvelairFlight> save(@ApiParam(value = "Flight entity to save") @Valid @RequestBody final NouvelairFlight nouvelairFlight) {
        return ResponseEntity.ok(NouvelairService.save(nouvelairFlight));
    }
}
