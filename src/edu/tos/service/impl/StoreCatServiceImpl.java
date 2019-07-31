package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.StoreCat;
import edu.tos.dao.StoreCatDao;
import edu.tos.dao.impl.StoreCatDaoImpl;
import edu.tos.service.StoreCatService;

public class StoreCatServiceImpl implements StoreCatService {
	StoreCatDao storeCatDao = new StoreCatDaoImpl();
	
	@Override
	public Long insert(StoreCat bean) {
		// TODO Auto-generated method stub
		return storeCatDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return storeCatDao.delete(id);
	}

	@Override
	public Long update(StoreCat bean) {
		// TODO Auto-generated method stub
		return storeCatDao.update(bean);
	}

	@Override
	public List<StoreCat> list() {
		// TODO Auto-generated method stub
		return storeCatDao.list();
	}

	@Override
	public StoreCat load(Long id) {
		// TODO Auto-generated method stub
		return storeCatDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return storeCatDao.count();
	}

	@Override
	public StoreCat loadByName(String storeCatName) {
		// TODO Auto-generated method stub
		return storeCatDao.loadByName(storeCatName);
	}

	@Override
	public Long countByName(String storeCatName) {
		// TODO Auto-generated method stub
		return storeCatDao.countByName(storeCatName);
	}

	@Override
	public List<StoreCat> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return storeCatDao.pager(pageNum, pageSize);
	}

	@Override
	public List<StoreCat> pagerByName(String storeCatName, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return storeCatDao.pagerByName(storeCatName, pageNum, pageSize);
	}

}
