package edu.tos.service;

import java.util.List;

import edu.tos.bean.Favorite;

public interface FavoriteService {

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
