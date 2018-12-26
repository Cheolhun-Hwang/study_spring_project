package com.hooney.hch;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.hooney.hch.DAO.Product;

@Component
public class ProductManager {
	private List<Product> datas = new ArrayList<>();
	
	public ProductManager() {
		datas.add(new Product(1,"Apple Phone Xs",1300000));
		datas.add(new Product(2,"Galaxy Note 9",1200000));
		datas.add(new Product(3,"Google Pixel Phone",1100000));
		datas.add(new Product(4,"LG G30",1230000));
	}
  	public void addProduct(Product p) {
		p.setId(datas.size()+1);
		datas.add(p);
	}
	public List<Product> getDatas() {
		return datas;
	}
	public void setDatas(List<Product> datas) {
		this.datas = datas;
	}
}
