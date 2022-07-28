package com.tech.interview.rmsflights.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tunisair", url = "localhost:8081")
public interface TunisairServiceProxy {

}
