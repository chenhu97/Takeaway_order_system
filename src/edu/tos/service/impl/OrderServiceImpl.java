package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.service.*;
import edu.tos.dao.impl.*;

public class OrderServiceImpl implements OrderService {
	OrderDao oderDao = new OrderDaoImpl();

	@Override
	public Long insert(Order bean) {
		// TODO Auto-generated method stub
		return oderDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return oderDao.delete(id);
	}

	@Override
	public Long update(Order bean) {
		// TODO Auto-generated method stub
		return oderDao.update(bean);
	}

	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		return oderDao.list();
	}

	@Override
	public List<Order> listBySearch(Long storeId, Long userId, Long status) {
		// TODO Auto-generated method stub
		return oderDao.listBySearch(storeId, userId, status);
	}

	@Override
	public Order load(Long id) {
		// TODO Auto-generated method stub
		return oderDao.load(id);
	}

	@Override
	public Order loadBySearch(Long storeId,Long userId, Long status) {
		// TODO Auto-generated method stub
		return oderDao.loadBySearch(storeId,userId, status);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return oderDao.count();
	}

	@Override
	public Long countBySearch(Long storeId, Long userId, Long status) {
		// TODO Auto-generated method stub
		return oderDao.countBySearch(storeId, userId, status);
	}

	@Override
	public List<Order> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return oderDao.pager(pageNum, pageSize);
	}

	@Override
	public List<Order> pagerBySearch(Long orderId, Long userId, Long status, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return oderDao.pagerBySearch(orderId, userId, status, pageNum, pageSize);
	}

	@Override
	public Long updateStatus(Long payId, Long status) {
		// TODO Auto-generated method stub
		return oderDao.updateStatus(payId, status);
	}

	@Override
	public Long searchOrderId(Long id) {
		// TODO Auto-generated method stub
		return oderDao.searchOrderId(id);
	}

	@Override
	public List<Order> listByUserId(Long userId) {
		// TODO Auto-generated method stub
		return oderDao.listByUserId(userId);
	}

	@Override
	public List<Order> pagerBySearchEx(Long userId, Long status, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return oderDao.pagerBySearchEx(userId, status, pageNum, pageSize);
	}


//	public Long ToPaied(Long payId) {
//		// TODO Auto-generated method stub
//		return oderDao.ToPaied(payId);
//	}
}
