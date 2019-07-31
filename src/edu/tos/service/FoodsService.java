package edu.tos.service;

import java.util.*;

import edu.tos.bean.*;

public interface FoodsService {

	Long insert(Foods bean);

	Long delete(Long id);

	Long update(Foods bean);

	List<Foods> list();

	List<Foods> listById(Long storeId);

	Foods load(Long id);

	Foods loadBySearch(Long storeId, String name);

	Long count();

	Long countBySearch(Long storeId, String name);

	List<Foods> pager(Long pageNum, Long pageSize);

	List<Foods> pagerBySearch(Long storeId, String name, Long pageNum, Long pageSize);
	
	List<Foods> listByStoreIdaAndcatId(Long storeId,Long catId);

}
