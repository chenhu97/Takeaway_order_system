package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.Store;
import edu.tos.dao.StoreDao;
import edu.tos.dao.impl.StoreDaoImpl;
import edu.tos.service.StoreService;

public class StoreServiceImpl implements StoreService {
	StoreDao storeDao = new StoreDaoImpl();

	@Override
	public Long insert(Store bean) {
		// TODO Auto-generated method stub
		return storeDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return storeDao.delete(id);
	}

	@Override
	public Long update(Store bean) {
		// TODO Auto-generated method stub
		return storeDao.update(bean);
	}

	@Override
	public List<Store> list() {
		// TODO Auto-generated method stub
		return storeDao.list();
	}

	@Override
	public List<Store> listBySearch(String name, String address, Long storeCatId,Long storeId) {
		// TODO Auto-generated method stub
		return storeDao.listBySearch(name, address, storeCatId,storeId);
	}

	@Override
	public Store load(Long id) {
		// TODO Auto-generated method stub
		return storeDao.load(id);
	}

	@Override
	public Store loadBySearch(String name, String address, Long storeCatId) {
		// TODO Auto-generated method stub
		return storeDao.loadBySearch(name, address, storeCatId);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return storeDao.count();
	}

	@Override
	public Long countBySearch(String name, String address, Long storeCatId,Long status) {
		// TODO Auto-generated method stub
		return storeDao.countBySearch(name, address, storeCatId, status);
	}

	@Override
	public List<Store> pager(Long status,Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return storeDao.pager(status,pageNum, pageSize);
	}

	@Override
	public List<Store> pagerBySearch(String name,Long status, String address, Long storeCatId, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return storeDao.pagerBySearch(name, status, address, storeCatId, pageNum, pageSize);
	}

	@Override
	public Store loadByName(String name) {
		// TODO Auto-generated method stub
		return storeDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return storeDao.countByName(name);
	}

	@Override
	public List<Store> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return storeDao.pagerByName(name, pageNum, pageSize);
	}

	@Override
	public Long searchByLogName(String logName) {
		// TODO Auto-generated method stub
		return storeDao.searchByLogName(logName);
	}

	@Override
	public Long searchByName(String name) {
		// TODO Auto-generated method stub
		return storeDao.searchByName(name);
	}

	@Override
	public Store loadById(Long id) {
		// TODO Auto-generated method stub
		return storeDao.loadById(id);
	}

}
