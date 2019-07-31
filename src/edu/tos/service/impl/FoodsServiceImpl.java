package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.dao.impl.*;
import edu.tos.service.*;

public class FoodsServiceImpl implements FoodsService {
	FoodsDao foodsDao = new FoodsDaoImpl();
	@Override
	public Long insert(Foods bean) {
		// TODO Auto-generated method stub
		return foodsDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return foodsDao.delete(id);
	}

	@Override
	public Long update(Foods bean) {
		// TODO Auto-generated method stub
		return foodsDao.update(bean);
	}

	@Override
	public List<Foods> list() {
		// TODO Auto-generated method stub
		return foodsDao.list();
	}

	@Override
	public List<Foods> listById(Long id) {
		// TODO Auto-generated method stub
		return foodsDao.listById(id);
	}

	@Override
	public Foods load(Long id) {
		// TODO Auto-generated method stub
		return foodsDao.load(id);
	}

	@Override
	public Foods loadBySearch(Long storeId ,String name) {
		// TODO Auto-generated method stub
		return foodsDao.loadBySearch(storeId, name);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return foodsDao.count();
	}

	@Override
	public Long countBySearch(Long storeId, String name) {
		// TODO Auto-generated method stub
		return foodsDao.countBySearch(storeId, name);
	}

	@Override
	public List<Foods> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return foodsDao.pager(pageNum, pageSize);
	}

	@Override
	public List<Foods> pagerBySearch(Long storeId, String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return foodsDao.pagerBySearch(storeId, name, pageNum, pageSize);
	}

	@Override
	public List<Foods> listByStoreIdaAndcatId(Long storeId, Long catId) {
		// TODO Auto-generated method stub
		return foodsDao.listByStoreIdaAndcatId(storeId, catId);
	}
	
	
	
}
