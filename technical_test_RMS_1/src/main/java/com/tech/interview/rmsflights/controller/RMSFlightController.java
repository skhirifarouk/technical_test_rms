package com.tech.interview.rmsflights.controller;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsRequest;
import com.tech.interview.rmsflights.domain.rms.RmsFlightsResponse;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import com.tech.interview.rmsflights.exception.ResourceNotFoundException;
import com.tech.interview.rmsflights.proxy.NouvelairServiceProxy;
import com.tech.interview.rmsflights.proxy.TunisairServiceProxy;
import com.tech.interview.rmsflights.service.RMSFlightService;
import com.tech.interview.rmsflights.util.mapper.request.RMSToNouvelairRequestMapperHelper.RMSToNouvelairRequestMapperHelperHolder;
import com.tech.interview.rmsflights.util.mapper.request.RMSToTunisairRequestMapperHelper.RMSToTunisairRequestMapperHelperHolder;
import com.tech.interview.rmsflights.util.mapper.response.NouvelairToRMSResponseMapperHelper.NouvelairToRMSResponseMapperHelperHolder;
import com.tech.interview.rmsflights.util.mapper.response.TunisairToRMSResponseMapperHelper.TunisairToRMSResponseMapperHelperHolder;
import feign.FeignException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

/**
 * Controller
 */
@Api(value = "/flights", description = "RMS Flight API")
@RestController
@RequestMapping("/flight")
public class RMSFlightController {

    @Autowired
    RMSFlightService flightService;

    /**
     * Get data by request
     *
     * @return
     */
    @GetMapping("/by_request")
    @ApiOperation(value = "Finds flights by request",
            response = RmsFlightsResponse.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departureDate", value = "Departure date : ISO_LOCAL_DATE format (yyyy-mm_dd)", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "returnDate", value = "Arrival date : ISO_LOCAL_DATE format (yyyy-mm_dd)", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "origin", value = "Origin country : ISO country code", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "destination", value = "Destination country : ISO country code", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "numberOfPassengers", value = "number of passengers", required = false, dataType = "long", paramType = "query")

    })
    public ResponseEntity<List<RmsFlightsResponse>> getByRequest(@Valid RmsFlightsRequest rmsFlightsRequest) throws Throwable, FeignException {
        List<RmsFlightsResponse> rmsFlightsResponses = new ArrayList<>();

        try {

            CompletableFuture.allOf(
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            return flightService.getResponseFromTunisair(rmsFlightsRequest);
                        } catch (ResourceNotFoundException e) {
                            throw new CompletionException(e);
                        }
                    }).thenAccept(rmsFlightsResponses::addAll),
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            return flightService.getResponseFromNouvelair(rmsFlightsRequest);
                        } catch (ResourceNotFoundException e) {
                            throw new CompletionException(e);
                        }
                    }).thenAccept(rmsFlightsResponses::addAll)
            ).join();
        } catch (CompletionException exception) {
            throw exception.getCause();
        }
        List<RmsFlightsResponse> sortedRmsFlightsResponses = rmsFlightsResponses.stream().sorted(Comparator.comparing(RmsFlightsResponse::getFare)).collect(Collectors.toList());
        return ResponseEntity.ok(sortedRmsFlightsResponses);
    }
}
