package edu.tos.service;

import java.util.List;

import edu.tos.bean.Order;

public interface OrderService {
	Long insert(Order bean);

	Long delete(Long id);

	Long update(Order bean);

	List<Order> list();
	
	List<Order> listByUserId(Long userId);

	List<Order> listBySearch(Long storeId, Long userId, Long status);

	Order load(Long id);

	Order loadBySearch(Long storeId,Long userId, Long status);

	Long count();

	Long countBySearch(Long storeId, Long userId, Long status);

	List<Order> pager(Long pageNum, Long pageSize);

	List<Order> pagerBySearch(Long orderId, Long userId, Long status, Long pageNum, Long pageSize);

	List<Order> pagerBySearchEx(Long userId, Long status, Long pageNum, Long pageSize);
	
	Long updateStatus(Long payId, Long status);
	
	//Long ToPaied(Long payId);
	
	Long searchOrderId(Long id);
}
