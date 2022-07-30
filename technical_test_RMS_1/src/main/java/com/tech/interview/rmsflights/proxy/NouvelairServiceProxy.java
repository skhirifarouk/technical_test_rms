package com.tech.interview.rmsflights.proxy;

import com.tech.interview.rmsflights.domain.nouvelair.NouvelairRequest;
import com.tech.interview.rmsflights.domain.nouvelair.NouvelairResponse;
import com.tech.interview.rmsflights.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "nouvelair", url = "localhost:8082/nouvelair/flight")
public interface NouvelairServiceProxy {

    /**
     * Get data by request
     * @return
     */
    @GetMapping("/by_request")
    ResponseEntity<List<NouvelairResponse>> getByRequest(@RequestParam("request") NouvelairRequest request) throws ResourceNotFoundException;
}
