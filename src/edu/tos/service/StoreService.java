package edu.tos.service;

import java.util.List;

import edu.tos.bean.Store;

public interface StoreService {

	Long insert(Store bean);

	Long delete(Long id);

	Long update(Store bean);

	List<Store> list();

	List<Store> listBySearch(String name, String address, Long storeCatId,Long storeId);
	
	Store load(Long id);
	
	Store loadById(Long id);

	Store loadByName(String name);
	
	Store loadBySearch(String name, String address, Long storeCatId);

	Long count();

	Long countBySearch(String name, String address, Long storeCatId,Long status);

	List<Store> pager(Long status,Long pageNum, Long pageSize);
	
	List<Store> pagerByName(String name, Long pageNum, Long pageSize);

	List<Store> pagerBySearch(String name,Long status, String address, Long storeCatId, Long pageNum, Long pageSize);

	Long countByName(String name);

	Long searchByLogName(String logName);

	Long searchByName(String name);
	
}