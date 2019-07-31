package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.OrderItem;
import edu.tos.dao.OrderItemDao;
import edu.tos.dao.impl.OrderItemDaoImpl;
import edu.tos.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	OrderItemDao orderItemDao = new OrderItemDaoImpl();

	@Override
	public Long insert(OrderItem bean) {
		// TODO Auto-generated method stub
		return orderItemDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return orderItemDao.delete(id);
	}

	@Override
	public Long update(OrderItem bean) {
		// TODO Auto-generated method stub
		return orderItemDao.update(bean);
	}

	@Override
	public List<OrderItem> list() {
		// TODO Auto-generated method stub
		return orderItemDao.list();
	}

	@Override
	public List<OrderItem> listBySearch(Long orderId, Long storeId, Long foodId) {
		// TODO Auto-generated method stub
		return orderItemDao.listBySearch(orderId, storeId, foodId);
	}

	@Override
	public OrderItem load(Long id) {
		// TODO Auto-generated method stub
		return orderItemDao.load(id);
	}

	@Override
	public OrderItem loadBySearch(Long orderId, Long storeId, Long foodId) {
		// TODO Auto-generated method stub
		return orderItemDao.loadBySearch(orderId, storeId, foodId);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return orderItemDao.count();
	}

	@Override
	public Long countBySearch(Long orderId, Long storeId, Long foodId) {
		// TODO Auto-generated method stub
		return orderItemDao.countBySearch(orderId, storeId, foodId);
	}
}
