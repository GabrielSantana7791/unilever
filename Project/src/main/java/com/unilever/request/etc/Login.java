package com.unilever.request.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unilever.request.entity.UserEntity;
import com.unilever.request.repository.UserRepository;

@Service
public class Login {
	
	@Autowired
	private UserRepository userRep;
	
	public UserEntity login (UserEntity user) throws Exception {
		
		UserEntity findUser = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
		if(user.getUserName().equals(findUser.getUserName()) && user.getPassword().equals(findUser.getPassword())) {
			
			return findUser;
		}
		
		throw new Exception("Invalid userName or password");
	}

}
