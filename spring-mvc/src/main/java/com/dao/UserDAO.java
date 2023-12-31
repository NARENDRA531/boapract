package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, String> {

}
