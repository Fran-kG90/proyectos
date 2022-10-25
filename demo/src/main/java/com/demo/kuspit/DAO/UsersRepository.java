package com.demo.kuspit.DAO;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.kuspit.modelo.User;

public interface UsersRepository  extends CrudRepository<User, Long> {
	
	  User findByEmail(String email);
	  @Transactional
	    @Modifying
	    @Query("UPDATE User SET money = ?1 where id = ?2")
	    void updateMoney(Float money, long id);

}
