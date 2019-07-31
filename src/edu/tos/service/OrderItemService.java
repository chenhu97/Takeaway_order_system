package edu.tos.service;

import java.util.List;

import edu.tos.bean.OrderItem;

public interface OrderItemService {

	Long insert(OrderItem bean);

	Long delete(Long id);

	Long update(OrderItem bean);

	List<OrderItem> list();

	List<OrderItem> listBySearch(Long orderId, Long storeId, Long foodId);

	OrderItem load(Long id);

	OrderItem loadBySearch(Long orderId, Long storeId, Long foodId);

	Long count();

	Long countBySearch(Long orderId, Long storeId, Long foodId);

}
