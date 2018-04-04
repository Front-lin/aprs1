package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.ProductDao;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Product;
import com.aprs.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;
	
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return productDao.getNum();
	}

	@Override
	public List<Product> getAllProduct(int start, int end) {
		// TODO Auto-generated method stub
		return productDao.getAllProduct(start, end);
	}

	@Override
	public void add(Product product){
		// TODO Auto-generated method stub
		productDao.add(product);
	}

	@Override
	public void updateSale(Product product) {
		// TODO Auto-generated method stub
		productDao.updateSale(product);
	}

	@Override
	public void updateQuantity(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int product_id) {
		// TODO Auto-generated method stub
		productDao.delete(product_id);
	}

	@Override
	public DatatablesViewPage<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatatablesViewPage<Product> getViewSP(int start, int end) {
		// TODO Auto-generated method stub
		List<Product> list = productDao.getAllProduct(start, end);
		int num = productDao.getNum();
		DatatablesViewPage<Product> view = new DatatablesViewPage<Product>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		return view;
	}

	@Override
	public List<Product> getByNum(int product_id) {
		// TODO Auto-generated method stub
		return productDao.getByNum(product_id);
	}

	@Override
	public List<Product> getByArg(int start, int end, String name) {
		// TODO Auto-generated method stub
		return productDao.getByName(start, end, name);
	}

	@Override
	public int getByArgNum(String name) {
		// TODO Auto-generated method stub
		return productDao.getByNameNum(name);
	}

}
