package com.cg.servises;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Barber;
import com.cg.model.MyCart;
import com.cg.repository.MycartRepo;

@Service
public class MycartService {

	
	@Autowired
	MycartRepo repo;
	
	
	public MyCart addCart(MyCart cart) {
		
		MyCart ca=repo.save(cart);
		return ca;
		
	}
	
	public List<MyCart> getByEmail(String email) {
	List<MyCart> c=repo.findAll();
	      List<MyCart> li=new ArrayList<MyCart>();
	      
	      
	      for(MyCart b:c) {
	    	  if(b.getcEmail().equals(email)){
	    		  li.add(b);
	    	  }
	      }
	      
	      return li;
	}
	
	public void  changestatus( MyCart barber,int id) {
		MyCart b=repo.findById(id).get();
		b.setCartStatus(barber.getCartStatus());
		repo.save(b);
	}
	
	
}
