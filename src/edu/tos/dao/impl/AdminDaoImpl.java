package edu.tos.dao.impl;

import java.util.*;

import java.sql.*;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.DbUtil;


public class AdminDaoImpl implements AdminDao {

	public Long insert(Admin bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append("insert into Admin(`AdminName`,`AdminPass`,`AdminSex`,`Phone` ) ");
		sb.append(" values( ? , ? , ? , ? )");
		paramsList.add(bean.getAdminName());
		paramsList.add(bean.getAdminPass());
		paramsList.add(bean.getAdminSex());
		paramsList.add(bean.getPhone());

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();

			Long num = DbFun.update(conn, sql, params);

			if (num > 0) {
				sql = "Select @@Identity";
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
		sb.append("delete from Admin Where AdminId= ? ;");

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
	public Long update(Admin bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append("update Admin set AdminName = ?, AdminPass= ? , AdminSex = ?, Phone = ? ");

		sb.append(" where AdminId= ? ;");
		paramsList.add(bean.getAdminName());
		paramsList.add(bean.getAdminPass());
		paramsList.add(bean.getAdminSex());
		paramsList.add(bean.getPhone());

		paramsList.add(bean.getAdminId());

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
	public List<Admin> list() {
		// TODO Auto-generated method stub
		List<Admin> list = new ArrayList<Admin>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From Admin ");
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
	public Admin load(Long id) {
		// TODO Auto-generated method stub
		Admin bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From Admin ");
		sb.append(" Where AdminId = ? ");
		paramsList.add(id);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();

			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
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
		sb.append(" Select Count(1) From Admin");

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
	public Admin loadByName(String name) {
		Admin bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From Admin ");
		sb.append(" Where AdminName Like ? ");
		sb.append(" Order By AdminId Asc");

		name = "%" + name + "%";

		paramsList.add(name);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
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
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select Count(1) From Admin");
		sb.append(" where adminName Like ?");
		name = "%" + name + "%";
		paramsList.add(name);

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
	public List<Admin> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Admin> list = new ArrayList<Admin>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From Admin ");
		sb.append(" Order By adminId Asc");
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
	public List<Admin> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Admin> list = new ArrayList<Admin>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From Admin ");
		sb.append(" where AdminName Like ?");
		sb.append(" Order By AdminId Asc");
		name = "%" + name + "%";
		paramsList.add(name);

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
	
	private Admin toBean(ResultSet rs) {
		Admin bean = new Admin();
		try {

			bean.setAdminId(rs.getLong("AdminId"));
			bean.setAdminName(rs.getString("AdminName"));
			bean.setAdminPass(rs.getString("AdminPass"));
			bean.setAdminSex(rs.getString("AdminSex"));

			bean.setPhone(rs.getLong("Phone"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

}
