package edu.tos.service;

import java.util.List;

import edu.tos.bean.Announce;

public interface AnnounceService {

	Long insert(Announce bean);

	Long delete(Long id);

	Long update(Announce bean);

	Announce load(Long id);

	Announce loadBySearch(Long adminId,String title);
	
	List<Announce> list();

	List<Announce> listBySearch(Long adminId,String title);
	
	List<Announce> pager(Long pageNum, Long pageSize);

	List<Announce> pagerBySearch(Long adminId,String title, String content, Long pageNum, Long pageSize);
	
	Long count();
	
	Long countBySearch(Long adminId, String content,String title);

}
