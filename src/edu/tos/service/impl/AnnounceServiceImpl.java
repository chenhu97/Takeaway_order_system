package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.dao.impl.*;
import edu.tos.service.*;

public class AnnounceServiceImpl implements AnnounceService {
	AnnounceDao announceDao = new AnnounceDaoImpl();

	@Override
	public Long insert(Announce bean) {
		// TODO Auto-generated method stub
		return announceDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return announceDao.delete(id);
	}

	@Override
	public Long update(Announce bean) {
		// TODO Auto-generated method stub
		return announceDao.update(bean);
	}

	@Override
	public Announce load(Long id) {
		// TODO Auto-generated method stub
		return announceDao.load(id);
	}

	@Override
	public Announce loadBySearch(Long adminId, String title) {
		// TODO Auto-generated method stub
		return announceDao.loadBySearch(adminId, title);
	}

	@Override
	public List<Announce> list() {
		// TODO Auto-generated method stub
		return announceDao.list();
	}

	@Override
	public List<Announce> listBySearch(Long adminId, String title) {
		// TODO Auto-generated method stub
		return announceDao.listBySearch(adminId, title);
	}

	@Override
	public List<Announce> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return announceDao.pager(pageNum, pageSize);
	}

	@Override
	public List<Announce> pagerBySearch(Long adminId, String title, String content, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return announceDao.pagerBySearch(adminId, title, content, pageNum, pageSize);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return announceDao.count();
	}

	@Override
	public Long countBySearch(Long adminId, String content, String title) {
		// TODO Auto-generated method stub
		return announceDao.countBySearch(adminId, content, title);
	}
}
