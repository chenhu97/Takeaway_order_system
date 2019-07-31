package edu.tos.service;

import java.util.List;

import edu.tos.bean.*;

public interface AdminService {

	Long insert(Admin bean);

	Long delete(Long id);

	Long update(Admin bean);

	List<Admin> list();

	Admin load(Long id);// 加载主键为指定值得行，不存在则返回null

	Long count(); // 返回所有行的数量

	Admin loadByName(String userName); // 加载名称为指定值得行，不存在则返回null

	Long countByName(String userName); // 返回名称为指定值的所有行的数量

	List<Admin> pager(Long pageNum, Long pageSize);

	List<Admin> pagerByName(String name, Long pageNum, Long pageSize);
}
