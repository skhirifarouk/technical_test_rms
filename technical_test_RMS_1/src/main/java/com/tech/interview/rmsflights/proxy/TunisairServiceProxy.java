package com.tech.interview.rmsflights.proxy;

import com.tech.interview.rmsflights.domain.tunisair.TunisAirRequest;
import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import com.tech.interview.rmsflights.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Tunisair feign client
 */
@FeignClient(name = "tunisair", url = "${feign.client.config.apis.tunisair}")
public interface TunisairServiceProxy {

    /**
     * Get data by request
     * @return
     */
    @GetMapping("/by_request")
    ResponseEntity<List<TunisairResponse>> getByRequest(@RequestParam("request") TunisAirRequest request) throws ResourceNotFoundException;

}
