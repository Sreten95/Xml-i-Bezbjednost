package xml.projekat.services;

import xml.projekat.model.User;

public interface UserServices {
	
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
