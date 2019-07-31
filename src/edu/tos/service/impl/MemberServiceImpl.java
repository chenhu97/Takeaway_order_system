package edu.tos.service.impl;

import java.util.List;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.dao.impl.*;
import edu.tos.service.*;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDaoImpl();

	@Override
	public Long insert(Member bean) {
		// TODO Auto-generated method stub
		return memberDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return memberDao.delete(id);
	}

	@Override
	public Long update(Member bean) {
		// TODO Auto-generated method stub
		return memberDao.update(bean);
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		return memberDao.list();
	}

	@Override
	public Member load(Long id) {
		// TODO Auto-generated method stub
		return memberDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return memberDao.count();
	}

	@Override
	public Member loadByName(String name) {
		// TODO Auto-generated method stub
		return memberDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return memberDao.countByName(name);
	}

	@Override
	public List<Member> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return memberDao.pager(pageNum, pageSize);
	}

	@Override
	public List<Member> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return memberDao.pagerByName(name, pageNum, pageSize);
	}

	@Override
	public Long countBySearch(String name, String nickName, String address) {
		// TODO Auto-generated method stub
		return memberDao.countBySearch(name, nickName, address);
	}

	@Override
	public List<Member> pagerBySearch(String name, String nickName, String address, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return memberDao.pagerBySearch(name, nickName, address, pageNum, pageSize);
	}

}
