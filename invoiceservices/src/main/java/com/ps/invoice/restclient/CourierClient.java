package com.ps.invoice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ps.invoice.model.Courier;



@FeignClient(name="COURIER-SERVICE")
public interface CourierClient {
	@GetMapping("courierApi/getCourier/{courier_id}")
	 Courier getCourierInfo(@PathVariable int courier_id);
}
