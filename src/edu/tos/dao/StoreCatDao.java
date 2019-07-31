package edu.tos.dao;

import java.util.List;

import edu.tos.bean.*;

public interface StoreCatDao {

	Long insert(StoreCat bean);

	Long delete(Long id);

	Long update(StoreCat bean);

	List<StoreCat> list();

	StoreCat load(Long id);

	Long count();

	StoreCat loadByName(String storeCatName);

	Long countByName(String storeCatName);

	List<StoreCat> pager(Long pageNum, Long pageSize);

	List<StoreCat> pagerByName(String storeCatName, Long pageNum, Long pageSize);

}
