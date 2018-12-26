package com.hooney.hch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hooney.hch.DAO.Product;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	@Autowired
	ProductManager pm;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value="msg", required=false) String msg,
			@RequestParam(value="msg2", required=false) String msg2) {
		return msg + " / " + msg2;
	}
	
	@GetMapping("/product")
	public List<Product> getAll() {		
		//자동으로 Json으로 형변환을 통해 return 됨.
		return pm.getDatas();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		return pm.getDatas().get(id-1);
	}
	
}
