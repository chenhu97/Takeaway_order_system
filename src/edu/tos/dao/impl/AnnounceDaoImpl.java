package edu.tos.dao.impl;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.*;

public class AnnounceDaoImpl implements AnnounceDao {

	@Override
	public Long insert(Announce bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Insert Into Announce ( ");
		sb.append(" adminId,content,createOn,updateOn,picPath,title ) ");
		sb.append(" values( ?,?,?,?,?,? )");

		paramsList.add(bean.getAdminId());
		paramsList.add(bean.getContent());
		paramsList.add(new Date());
		paramsList.add(bean.getUpdateOn());
		paramsList.add(bean.getPicPath());
		paramsList.add(bean.getTitle());

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			Long num = DbFun.update(conn, sql, params);
			if (num > 0) {
				sql = " Select @@identity ";
				result = DbFun.queryScalarLong(conn, sql);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Delete From Announce ");
		sb.append(" where AnnounceId = ?");
		paramsList.add(id);

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			result = DbFun.update(conn, sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;
	}

	@Override
	public Long update(Announce bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Update Announce ");
		sb.append(" Set adminId=?, title = ?,content=?,createOn=?,updateOn=?,picPath=? ");
		sb.append(" Where AnnounceId=?");

		paramsList.add(bean.getAdminId());
		paramsList.add(bean.getTitle());
		paramsList.add(bean.getContent());
		paramsList.add(bean.getCreateOn());
		paramsList.add(new Date());
		paramsList.add(bean.getPicPath());
		paramsList.add(bean.getAnnounceId());

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			result = DbFun.update(conn, sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;
	}

	@Override
	public Announce load(Long id) {
		// TODO Auto-generated method stub
		Announce bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Announce ");
		sb.append(" Where AnnounceId = ? ");

		paramsList.add(id);

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			if (rs.next()) {
				bean = toBean(rs);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return bean;
	}

	@Override
	public List<Announce> list() {
		// TODO Auto-generated method stub
		List<Announce> list = new ArrayList<Announce>();
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * from Announce");
		sb.append(" Group by AnnounceId ");
		String sql = sb.toString();
		Object[] params = paramsList.toArray();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
				list.add(toBean(rs));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<Announce> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Announce> list = new ArrayList<Announce>();
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * from Announce");
		sb.append(" Order by AnnounceId Asc");
		if (pageNum < 1) {
			pageNum = 1L;

		}
		if (pageSize < 1) {
			pageSize = 10L;
		}
		Long startIndex = (pageNum - 1) * pageSize;

		sb.append(" limit " + startIndex + "," + pageSize);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			while (rs.next()) {

				list.add(toBean(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return list;
	}

	@Override
	public Announce loadBySearch(Long adminId,String title) {
		// TODO Auto-generated method stub
		Announce bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Announce ");
		sb.append(" where 1=1 ");
		if(adminId != null) {
			sb.append(" adminId = ?  ");
			paramsList.add(adminId);
		}
		if(title != null) {
			sb.append(" and title like ? ");
			title = "%" + title + "%";
			paramsList.add(title);
		}
		sb.append(" Order By AnnounceId Asc");

		paramsList.add(adminId);

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			if (rs.next()) {
				bean = toBean(rs);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return bean;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From Announce ");

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			result = DbFun.queryScalarLong(conn, sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;
	}

	@Override
	public List<Announce> pagerBySearch(Long adminId, String title, String content, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Announce> list = new ArrayList<Announce>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Announce ");
		sb.append(" Where 1=1 ");
		if (adminId != null) {
			sb.append(" and adminId = ? ");
			paramsList.add(adminId);
		}
		if(title != null) {
			sb.append(" and title like ? ");
			title = "%" + title + "%";
			paramsList.add(title);
		}
		if (content != null) {
			sb.append(" and Content like ? ");
			content = "%" + content + "%";
			paramsList.add(content);
		}
		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 10L;
		}
		Long startIndex = (pageNum - 1) * pageSize;
		sb.append(" limit " + startIndex + "," + pageSize);

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			while (rs.next()) {
				list.add(toBean(rs));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return list;
	}

	@Override
	public Long countBySearch(Long adminId, String content, String title) {
		// TODO Auto-generated method stub
		Long result = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From Announce ");
		sb.append(" Where 1=1 ");

		if (adminId != null) {
			sb.append(" and adminId = ? ");
			paramsList.add(adminId);
		}
		if (content != null) {
			sb.append(" and Content like ? ");
			content = "%" + content + "%";
			paramsList.add(content);
		}
		if (title != null) {
			sb.append(" and title like ? ");
			title = "%" + title + "%";
			paramsList.add(title);
		}

		sb.append(" Order By AnnounceId Asc");

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			result = DbFun.queryScalarLong(conn, sql, params);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;
	}

	@Override
	public List<Announce> listBySearch(Long adminId, String title) {
		// TODO Auto-generated method stub
		List<Announce> list = new ArrayList<Announce>();
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * from Announce");
		sb.append(" where 1=1 ");
		if (adminId != null) {
			sb.append(" and adminId = ? ");
			paramsList.add(adminId);
		}
		if (title != null) {
			sb.append(" and title like ? ");
			title = "%" + title + "%";
			paramsList.add(title);
		}
		String sql = sb.toString();
		Object[] params = paramsList.toArray();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
				list.add(toBean(rs));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return list;
	}

	private Announce toBean(ResultSet rs) {
		Announce bean = new Announce();
		try {
			bean.setAnnounceId(rs.getLong("AnnounceId"));
			bean.setAdminId(rs.getLong("AdminId"));
			bean.setTitle(rs.getString("Title"));
			bean.setContent(rs.getString("Content"));
			bean.setPicPath(rs.getString("PicPath"));
			bean.setUpdateOn(rs.getDate("UpdateOn"));
			bean.setCreateOn(rs.getDate("CreateOn"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}
}
