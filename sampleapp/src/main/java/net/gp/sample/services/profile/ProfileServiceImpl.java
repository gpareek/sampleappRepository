package net.gp.sample.services.profile;

import net.gp.sample.controller.RegistrationController;
import net.gp.sample.user.dao.UserDAO;
import net.gp.sample.user.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProfileServiceImpl implements ProfileService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User loginUser(String userName, String password) {
		// TODO Auto-generated method stub
		logger.debug("Inside loginUser");
		User user = new User();
		user.setFirstName("Gaurav");
		user.setLastName("Pareek");
		user.setEmail("gpareek@gmail.com");
		return user;
	}

	@Override
	@Transactional
	public void register(User user) {
		logger.debug("Inside register");
		
		userDAO.createUser(user);
		return;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
