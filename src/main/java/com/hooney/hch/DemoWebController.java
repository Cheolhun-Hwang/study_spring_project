package com.hooney.hch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hooney.hch.DAO.Product;

@Controller
@RequestMapping("/web")
public class DemoWebController {
	@Autowired
	ProductManager pm;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		//msg 데이터에 "hello world"를 넣는다. view에서 data-th-text"${msg}"에 호출
		model.addAttribute("msg", "Hello World");
		//MVC 패턴은 뷰의 이름을 들어가야한다.
		//resources/templates에 view가 들어가야 한다.
		return "hello";
	}
	
	@GetMapping("/productlist")
	public String getProducts(Model model) {
		model.addAttribute("products", pm.getDatas());
		return "productlist";
	}
	
	@PostMapping("/productadd")
	public String addProduct(Product p) {
		pm.addProduct(p);
		return "redirect:/web/productlist";
	}
}
