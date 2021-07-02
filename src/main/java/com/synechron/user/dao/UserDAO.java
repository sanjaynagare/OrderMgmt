package com.synechron.user.dao;

import com.synechron.user.model.User;

public interface UserDAO {
	public User getUserByUsername(String username);
}
