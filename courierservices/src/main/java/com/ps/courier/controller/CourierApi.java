package com.ps.courier.controller;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.courier.dto.CourierDto;
import com.ps.courier.model.Courier;
import com.ps.courier.servces.CourierService;
import com.ps.courier.servces.SequenceGeneratorService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/courierApi")
public class CourierApi {
	Logger logger= Logger.getLogger(CourierApi.class.getName());
	 
	@Autowired
    public	CourierService courierService;
	@Autowired
    private	SequenceGeneratorService sg;

	@ApiOperation(value = "Creates courier",notes = "Takes Json as input validates it and saves it to database")
	@PostMapping("/courier")
	public ResponseEntity<Courier> bookCourier(@Validated @RequestBody final CourierDto courierDto) {
		logger.info("inserting courier data started");
		courierDto.setCourierId(sg.getSequenceNumber(Courier.SEQUENCE_NAME));
		
		Courier savedCourier = courierService.bookCourier(courierDto);
		logger.info("courier saved");
		if(savedCourier!=null) {
			return new ResponseEntity<>(savedCourier, HttpStatus.CREATED);
		}
		else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	  @ApiOperation("Return courier matching the passed id")
	  @GetMapping("/getCourier/{courierId}") 
	  public ResponseEntity<Courier> getCourierInfo(@PathVariable int courierId) 
	  { 
		  Courier courier = courierService.findById(courierId); 
		  if(courier!=null) {
			  logger.info("courier get");
			  return  new ResponseEntity<>(courier,HttpStatus.OK);
			  
		  }
			  else {
				  logger.info("user not found");
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		            
		  }
	  }
	 
	@GetMapping("/getCouriers")
	public ResponseEntity<List<Courier>> getAllCourierInfo() {
				List<Courier> courier = courierService.getCouriers();
				return new ResponseEntity<>(courier, HttpStatus.OK);
	}
}
