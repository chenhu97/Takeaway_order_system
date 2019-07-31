package edu.tos.dao;

import java.util.*;

import edu.tos.bean.*;

public interface OrderRecordDao {
	Long insert(OrderRecord bean);

	Long delete(Long id);

	Long update(OrderRecord bean);

	List<OrderRecord> list();

	OrderRecord load(Long id);// 加载主键为指定值得行，不存在则返回null

	Long count(); // 返回所有行的数量

	OrderRecord loadByName(String userName); // 加载名称为指定值得行，不存在则返回null

	Long countByName(String userName); // 返回名称为指定值的所有行的数量
	
	List<OrderRecord> pager(Long pageNum,Long pageSize);
	
	List<OrderRecord> pagerByName(String name,Long pageNum,Long pageSize);
	
	
}

