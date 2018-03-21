package com.circumfusion.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circumfusion.dto.UserDTO;
import com.circumfusion.entity.User;
import com.circumfusion.exception.UserAlreadyExistsException;
import com.circumfusion.repo.UserRepo;

@Service
@Transactional
public class UserService {
	
	@Autowired
	DozerBeanMapper beanMapper;
	
	@Autowired
	UserRepo userRepo;

	public UserDTO createUser(UserDTO user) {
		User existingUser = userRepo.findByUsername(user.getUsername());
		if (existingUser != null)
			throw new UserAlreadyExistsException();
		
		existingUser = userRepo.save(beanMapper.map(user, User.class));
		return beanMapper.map(existingUser, UserDTO.class);
	}
	
}
