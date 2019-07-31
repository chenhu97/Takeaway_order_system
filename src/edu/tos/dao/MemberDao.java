package edu.tos.dao;

import java.util.List;

import edu.tos.bean.*;

public interface MemberDao {

	Long insert(Member bean);

	Long delete(Long id);

	Long update(Member bean);

	List<Member> list();

	Member load(Long id);

	Long count();

	Member loadByName(String name);

	Long countByName(String name);

	List<Member> pager(Long pageNum, Long pageSize);

	List<Member> pagerByName(String name, Long pageNum, Long pageSize);

	Long countBySearch(String name, String nickName, String address);

	List<Member> pagerBySearch(String name, String nickName, String address, Long pageNum, Long pageSize);

}
