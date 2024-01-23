package com.medicare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.bean.Addtocart;
import com.medicare.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartrepository;
	
	public String addCart(Addtocart addcart) {
		cartrepository.save(addcart);
		return "Added to Cart";
	}
	
	public String deleteItem(int medid,String email) {
		Optional<Addtocart> result  = cartrepository.deleteItem(medid,email);
		if(result.isPresent()) {
			Addtocart a = result.get();
			cartrepository.delete(a);
			return "Item deleted successfully";
		}else {
			return "Item not present";
		}
	}
	
	public String deleteCartAfterPayment(String email) {
		List<Addtocart> result  = cartrepository.deleteCartAfterPayment(email);
		cartrepository.deleteAll(result);
		return "Cart Deleted";
	}
	
	public List<Addtocart> orderSummaryByEmail(String email){
		return cartrepository.orderSummary(email);
	}
	public String totalBill(String email) {
		return cartrepository.billAmount(email);
	}
}
