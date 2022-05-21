package com.unilever.request.etc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unilever.request.entity.UserEntity;
import com.unilever.request.exceptions.EmptUserException;
import com.unilever.request.exceptions.InvalidUserException;
import com.unilever.request.repository.UserRepository;

@Service
public class Login {

	@Autowired
	private UserRepository userRep;

	public void check (HttpSession httpSession) throws InvalidUserException, EmptUserException  {
		try {
			UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
			UserEntity findUser = userRep.findByUserNameAndPassword(userEntity.getUserName(), userEntity.getPassword());

			if((!userEntity.getUserName().equals(findUser.getUserName()) || !userEntity.getPassword().equals(findUser.getPassword()))) {
				throw new InvalidUserException("Invalid userName or password");

			}

		} catch (NullPointerException e) {
			//userSession == null; so the algorithm can decide what to do
			throw new EmptUserException(null);
		}

	}

	public UserEntity login (HttpSession httpSession, UserEntity userEntity) throws InvalidUserException {
		try {
			check(httpSession);
			//Empt session so the login request can continue

		}catch (EmptUserException e) {
			UserEntity findUser = userRep.findByUserNameAndPassword(userEntity.getUserName(), userEntity.getPassword());

			if(userEntity.getUserName().equals(findUser.getUserName()) && userEntity.getPassword().equals(findUser.getPassword())) {

				httpSession.setAttribute("user", findUser);
				return findUser;
			}
			
			throw new InvalidUserException("Invalid userName or password");
		}
		return userEntity;



	}

}
