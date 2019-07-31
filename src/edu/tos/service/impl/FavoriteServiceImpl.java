package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.Favorite;
import edu.tos.dao.FavoriteDao;
import edu.tos.dao.impl.FavoriteDaoImpl;
import edu.tos.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
	FavoriteDao favoriteDao = new FavoriteDaoImpl();

	@Override
	public Long insert(Favorite bean) {
		// TODO Auto-generated method stub
		return favoriteDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return favoriteDao.delete(id);
	}

	@Override
	public Long update(Favorite bean) {
		// TODO Auto-generated method stub
		return favoriteDao.update(bean);
	}

	@Override
	public List<Favorite> list() {
		// TODO Auto-generated method stub
		return favoriteDao.list();
	}

	@Override
	public List<Favorite> listBySearch(Long favoriteId, Long storeId, Long userId) {
		// TODO Auto-generated method stub
		return favoriteDao.listBySearch(favoriteId, storeId, userId);
	}

	@Override
	public Favorite load(Long id) {
		// TODO Auto-generated method stub
		return favoriteDao.load(id);
	}

	@Override
	public Favorite loadBySearch(Long favoriteId, Long storeId, Long userId) {
		// TODO Auto-generated method stub
		return favoriteDao.loadBySearch(favoriteId, storeId, userId);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return favoriteDao.count();
	}

	@Override
	public Long countBySearch(Long favoriteId, Long storeId, Long userId) {
		// TODO Auto-generated method stub
		return favoriteDao.countBySearch(favoriteId, storeId, userId);
	}

	@Override
	public List<Favorite> listBySearch(Long userId) {
		// TODO Auto-generated method stub
		return favoriteDao.listBySearch(userId);
	}
	
}
