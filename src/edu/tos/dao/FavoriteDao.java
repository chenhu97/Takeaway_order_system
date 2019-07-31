package edu.tos.dao;

import java.util.List;

import edu.tos.bean.Favorite;

public interface FavoriteDao {

	Long insert(Favorite bean);

	Long delete(Long id);

	Long update(Favorite bean);

	List<Favorite> list();

	List<Favorite> listBySearch(Long favoriteId, Long storeId, Long userId);

	Favorite load(Long id);

	Favorite loadBySearch(Long favoriteId, Long storeId, Long userId);

	Long count();

	Long countBySearch(Long favoriteId, Long storeId, Long userId);
	
	List<Favorite> listBySearch(Long userId);

}
