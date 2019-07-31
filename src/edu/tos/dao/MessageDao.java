package edu.tos.dao;

import java.util.List;

import edu.tos.bean.Message;

public interface MessageDao {

	Long insert(Message bean);

	Long delete(Long id);

	Long update(Message bean);

	List<Message> list();

	List<Message> listBySearch(Long storeId, Long orderId, Long userId);

	Message load(Long id);

	Message loadBySearch(Long storeId, Long orderId, Long userId);

	Long count();

	Long countBySearch(Long storeId, Long orderId, Long userId);

	List<Message> pager(Long pageNum, Long pageSize);

	List<Message> pagerBySearch(Long storeId, Long orderId, Long userId, Long pageNum, Long pageSize);

}
