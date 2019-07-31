package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.dao.impl.*;
import edu.tos.service.*;

public class FoodCatServiceImpl implements FoodCatService {

	private FoodCatDao foodCatDao = new FoodCatDaoImpl();

	@Override
	public Long insert(FoodCat bean) {
		// TODO Auto-generated method stub
		return foodCatDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return foodCatDao.delete(id);
	}

	@Override
	public Long update(FoodCat bean) {
		// TODO Auto-generated method stub
		return foodCatDao.update(bean);
	}

	@Override
	public List<FoodCat> list() {
		// TODO Auto-generated method stub
		return foodCatDao.list();
	}

	@Override
	public FoodCat load(Long id) {
		// TODO Auto-generated method stub
		return foodCatDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return foodCatDao.count();
	}

	@Override
	public FoodCat loadByName(String name) {
		// TODO Auto-generated method stub
		return foodCatDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return foodCatDao.countByName(name);
	}

	@Override
	public List<FoodCat> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return foodCatDao.pager(pageNum, pageSize);
	}

	@Override
	public List<FoodCat> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return foodCatDao.pagerByName(name, pageNum, pageSize);
	}

	@Override
	public Long countByStoreIdAndName(Long storeId, String name) {
		// TODO Auto-generated method stub
		return foodCatDao.countByStoreIdAndName(storeId, name);
	}

	@Override
	public List<FoodCat> pagerByStoreIdAndName(Long storeId, String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return foodCatDao.pagerByStoreIdAndName(storeId, name, pageNum, pageSize);
	}

	@Override
	public List<FoodCat> listByStoreId(Long id) {
		// TODO Auto-generated method stub
		return foodCatDao.listByStoreId(id);
	}

	@Override
	public Long countByCatName(String name, Long storeId) {
		// TODO Auto-generated method stub
		return foodCatDao.countByCatName(name, storeId);
	}



}
