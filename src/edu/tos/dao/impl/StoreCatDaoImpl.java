package edu.tos.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liuvei.common.DbFun;


import edu.tos.bean.StoreCat;
import edu.tos.dao.StoreCatDao;
import edu.tos.util.DbUtil;

public class StoreCatDaoImpl implements StoreCatDao {

	@Override
	public Long insert(StoreCat bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append("insert into storecat values(?)");
		paramsList.add(bean.getStoreCatName());

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
		sb.append("delete from storecat Where storeCatId = ? ;");
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
	public Long update(StoreCat bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" update storecat set storeCatName = ? ");
		sb.append(" where storeCatId = ?");
		paramsList.add(bean.getStoreCatName());
		paramsList.add(bean.getStoreCatId());

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
	public List<StoreCat> list() {
		// TODO Auto-generated method stub
		List<StoreCat> list = new ArrayList<StoreCat>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From StoreCat ");
		sb.append(" order by storeCatId asc ");
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
	public StoreCat load(Long id) {
		// TODO Auto-generated method stub
		StoreCat bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From storecat ");
		sb.append(" Where storeCatId = ? ");
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
		return null;
	}

	@Override
	public StoreCat loadByName(String storeCatName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByName(String storeCatName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreCat> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreCat> pagerByName(String storeCatName, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private StoreCat toBean(ResultSet rs) {
		// TODO Auto-generated method stub
		StoreCat bean = new StoreCat();
		try {
			bean.setStoreCatId(rs.getLong("storeCatId"));
			bean.setStoreCatName(rs.getString("storeCatName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

		return bean;
	}
}
