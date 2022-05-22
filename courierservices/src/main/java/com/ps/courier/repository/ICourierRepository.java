package com.ps.courier.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ps.courier.dto.CourierDto;
import com.ps.courier.model.Courier;
@Repository
public interface ICourierRepository extends MongoRepository<Courier, Integer>
 {
 
public Optional<Courier> findById(int courierId);



	
 }
 