package edu.tos.dao;

import java.util.*;
import edu.tos.bean.*;


public interface FoodCatDao {
	
	Long insert(FoodCat bean);

	Long delete(Long id);

	Long update(FoodCat bean);

	List<FoodCat> list();

	FoodCat load(Long id);

	Long count();

	FoodCat loadByName(String name);

	Long countByName(String name);
	

	List<FoodCat> pager(Long pageNum, Long pageSize);

	List<FoodCat> pagerByName(String name, Long pageNum, Long pageSize);
	

	Long countByStoreIdAndName(Long storeId,String name);
	
	List<FoodCat> pagerByStoreIdAndName(Long storeId,String name,Long pageNum, Long pageSize);
	
	List<FoodCat> listByStoreId(Long id);
	
	Long countByCatName(String name,Long storeId);


}
