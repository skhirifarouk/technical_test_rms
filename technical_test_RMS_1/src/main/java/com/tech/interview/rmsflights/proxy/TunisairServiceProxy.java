package com.tech.interview.rmsflights.proxy;

import com.tech.interview.rmsflights.domain.tunisair.TunisairResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "tunisair", url = "localhost:8081")
public interface TunisairServiceProxy {

    /**
     * Get all data
     * @return
     */
    @GetMapping("/tunisair/flight/all")
    public ResponseEntity<List<TunisairResponse>> getAll();

}
