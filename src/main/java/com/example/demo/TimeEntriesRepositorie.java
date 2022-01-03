package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
@Component
public interface TimeEntriesRepositorie extends MongoRepository<TimeEntry, String> {
	

}
