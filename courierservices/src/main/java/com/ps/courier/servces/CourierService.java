package com.ps.courier.servces;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ps.courier.dto.CourierDto;
import com.ps.courier.model.Courier;
import com.ps.courier.repository.ICourierRepository;

@Service
@EnableTransactionManagement
public class CourierService {
	 private static final Logger logger = LoggerFactory.getLogger(CourierService.class);
	@Autowired
  public ICourierRepository courierRepo;
	@Autowired
	 private ModelMapper modelMapper;
	public Courier bookCourier(CourierDto courierDto) {
		Courier cmap = modelMapper.map(courierDto, Courier.class);	
		Courier courier = courierRepo.insert(cmap);
		logger.info("couier saved");
		
		return courier;
	}
	
	
	 public Courier findById(int courierId) { 
		  Optional<Courier> findCourier = courierRepo.findById(courierId);
	  
		  if(findCourier.isPresent()) {
			  Courier courier = findCourier.get();
			  return courier;
		  }
		  else {
			  return null;
		  }
	 }
	public List<Courier> getCouriers(){
		List<Courier> couriers= courierRepo.findAll();
		return couriers;
	}
	
	/*
	 * @Transactional public int updateCourier(CourierDto courierDto ) throws
	 * InterruptedException { Optional<Courier> optionalCourier =
	 * Optional.of(courierRepo.)); if(optionalCourier.isPresent()) { Courier
	 * courierFromDb = optionalCourier.get(); String customer_name =
	 * courierDto.getCustomer_name(); String customer_address =
	 * courierDto.getCustomer_address(); String booking_date =
	 * courierDto.getBooking_date(); String delivery_from =
	 * courierDto.getDelivery_from(); String delivery_to =
	 * courierDto.getDelivery_to(); BigDecimal item_weight =
	 * courierDto.getItem_weight(); if(customer_name!=null) {
	 * 
	 * courierFromDb.setCustomer_name(customer_name); } if(customer_address!=null) {
	 * courierFromDb.setCustomer_address(customer_address); }
	 * courierRepo.save(courierFromDb); Thread.sleep(30000,1);
	 * System.out.println("Courier record Commeted"); return 1; } else { return 0; }
	 * 
	 * }
	 */
	/*
	 * public int delete(int _id) { Courier id = courierRepo.findById(_id);
	 * if(id.equals(id)) { BigInteger _id2 = id.get_id(); courierRepo.; return 1; }
	 * else { return 0; } }
	 */


}
