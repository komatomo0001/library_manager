package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Log;
import com.example.repository.LogRepository;

@Service
public class LogService{
	private final LogRepository logRepository;
	
	@Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
	
	public Log save(Integer id, LoginUser loginUser, String returnDueDate) {
		
		Log log = new Log();
		
		log.setLibraryId(id);
		log.setUserId(loginUser.getUser().getId());
		log.setRentDate(LocalDateTime.now());
		log.setReturnDueDate(LocalDateTime.parse(returnDueDate + "T00:00:00"));
		log.setReturnDate(null);
		
		return this.logRepository.save(log);
	}
	
	public Log update(Integer id, LoginUser loginUser) {
		Optional<Log> optionalLog = this.logRepository.findFirstByLibraryIdAndUserIdOrderByRentDateDesc(id, loginUser.getUser().getId());
		Log log = optionalLog.get();
		log.setReturnDate(LocalDateTime.now());
		return this.logRepository.save(log);
	}
	
	public List<Log> findByUserId(LoginUser loginUser){
		return this.logRepository.findByUserId(loginUser.getUser().getId());
	}
	
}
