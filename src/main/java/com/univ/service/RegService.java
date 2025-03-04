package com.univ.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.dao.RegDAO;
import com.univ.model.RegModel;
@Service
public class RegService {
    @Autowired
	RegDAO regdao;
   public int createUser(RegModel user) {
		return this.regdao.saveUser(user); //calling DAO Method
	}
   public List loginCheck(RegModel user) {
		return this.regdao.checkUser(user); //Calling DAO Method
	}
}
