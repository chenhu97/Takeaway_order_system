package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.service.*;
import edu.tos.dao.impl.*;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Long insert(Admin bean) {
		// TODO Auto-generated method stub
		return adminDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return adminDao.delete(id);
	}

	@Override
	public Long update(Admin bean) {
		// TODO Auto-generated method stub
		return adminDao.update(bean);
	}

	@Override
	public List<Admin> list() {
		// TODO Auto-generated method stub
		return adminDao.list();
	}

	@Override
	public Admin load(Long id) {
		// TODO Auto-generated method stub
		return adminDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return adminDao.count();
	}

	@Override
	public Admin loadByName(String userName) {
		// TODO Auto-generated method stub
		return adminDao.loadByName(userName);
	}

	@Override
	public Long countByName(String userName) {
		// TODO Auto-generated method stub
		return adminDao.countByName(userName);
	}

	@Override
	public List<Admin> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return adminDao.pager(pageNum, pageSize);
	}

	@Override
	public List<Admin> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return adminDao.pagerByName(name, pageNum, pageSize);
	}

}
