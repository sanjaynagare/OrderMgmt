package com.synechron.user.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.synechron.user.model.User;

public interface UserDAOImpl extends CrudRepository<User,Integer> ,UserDAO {
	 @Query("SELECT u FROM User u WHERE u.username = :username")
	 public User getUserByUsername(@Param("username") String username);
}
