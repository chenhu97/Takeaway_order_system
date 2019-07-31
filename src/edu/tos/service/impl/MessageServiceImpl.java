package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.dao.impl.*;
import edu.tos.service.*;

public class MessageServiceImpl implements MessageService {
	MessageDao messageDao = new MessageDaoImpl();

	@Override
	public Long insert(Message bean) {
		// TODO Auto-generated method stub
		return messageDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return messageDao.delete(id);
	}

	@Override
	public Long update(Message bean) {
		// TODO Auto-generated method stub
		return messageDao.update(bean);
	}

	@Override
	public List<Message> list() {
		// TODO Auto-generated method stub
		return messageDao.list();
	}

	@Override
	public List<Message> listBySearch(Long storeId, Long orderId, Long userId) {
		// TODO Auto-generated method stub
		return messageDao.listBySearch(storeId, orderId, userId);
	}

	@Override
	public Message load(Long id) {
		// TODO Auto-generated method stub
		return messageDao.load(id);
	}

	@Override
	public Message loadBySearch(Long storeId, Long orderId, Long userId) {
		// TODO Auto-generated method stub
		return messageDao.loadBySearch(storeId, orderId, userId);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return messageDao.count();
	}

	@Override
	public Long countBySearch(Long storeId, Long orderId, Long userId) {
		// TODO Auto-generated method stub
		return messageDao.countBySearch(storeId, orderId, userId);
	}

	@Override
	public List<Message> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return messageDao.pager(pageNum, pageSize);
	}

	@Override
	public List<Message> pagerBySearch(Long storeId, Long orderId, Long userId, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return messageDao.pagerBySearch(storeId, orderId, userId, pageNum, pageSize);
	}

}
