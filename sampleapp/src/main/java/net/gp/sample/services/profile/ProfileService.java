package net.gp.sample.services.profile;

import net.gp.sample.user.dto.User;

public interface ProfileService {
	
	public User loginUser(String userName, String password);
	public void register(User user);

}
