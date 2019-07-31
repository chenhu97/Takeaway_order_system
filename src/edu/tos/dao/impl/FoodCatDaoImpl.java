package edu.tos.dao.impl;

import java.sql.*;
import java.util.*;
import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.*;

public class FoodCatDaoImpl implements FoodCatDao {

	@Override
	public Long insert(FoodCat bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Insert Into FoodCat (");
		sb.append(" CatName,Remark,CreateOn,storeId ) ");
		sb.append(" values( ?,?,?,? ) ");

		paramsList.add(bean.getCatName());
		paramsList.add(bean.getRemark());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getStoreId());
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

		sb.append(" Delete From FoodCat ");
		sb.append(" where CatId = ?");
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
	public Long update(FoodCat bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Update FoodCat ");
		sb.append(" set CatName=?,Remark=?,CreateOn=?,storeId=? ");
		sb.append(" Where CatId=? ");

		paramsList.add(bean.getCatName());
		paramsList.add(bean.getRemark());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getCatId());

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
	public List<FoodCat> list() {
		// TODO Auto-generated method stub
		List<FoodCat> list = new ArrayList<FoodCat>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From FoodCat ");

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
	public FoodCat load(Long id) {
		// TODO Auto-generated method stub
		FoodCat bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From FoodCat ");
		sb.append(" Where CatId = ? ");

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
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From FoodCat ");

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
	public FoodCat loadByName(String name) {
		// TODO Auto-generated method stub
		FoodCat bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From FoodCat ");
		sb.append(" Where CatName like ? ");
		sb.append(" Order By CatId Asc");

		name = "%" + name + "%";

		paramsList.add(name);

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
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From FoodCat ");
		sb.append(" Where CatName like ? ");

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
	public List<FoodCat> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<FoodCat> list = new ArrayList<FoodCat>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From FoodCat ");
		sb.append(" Order By CatId Asc ");
		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 1L;
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
	public List<FoodCat> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<FoodCat> list = new ArrayList<FoodCat>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From FoodCat ");
		sb.append(" Where CatName Like ?");
		sb.append(" Order By CatId Asc ");

		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 1L;
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

	private FoodCat toBean(ResultSet rs) {
		// TODO Auto-generated method stub
		FoodCat bean = new FoodCat();

		try {
			bean.setCatId(rs.getLong("CatId"));
			bean.setCatName(rs.getString("CatName"));
			bean.setRemark(rs.getString("Remark"));
			bean.setCreateOn(rs.getDate("CreateOn"));
			bean.setStoreId(rs.getLong("StoreId"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bean;
	}

	@Override
	public Long countByStoreIdAndName(Long storeId, String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" select count(1) from FoodCat");
		sb.append(" where 1=1");
		if (storeId != null) {
			sb.append(" and storeId = ?");
			paramsList.add(storeId);

		}
		if (!SysFun.isNullOrEmpty(name)) {
			sb.append(" and catName like ?");
			name = "%" + name + "%";
			paramsList.add(name);
		}
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
	public List<FoodCat> pagerByStoreIdAndName(Long storeId, String name, Long pageNum, Long pageSize) {
		List<FoodCat> list = new ArrayList<FoodCat>();
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" select * from FoodCat");
		sb.append(" where 1=1");
		if (storeId != null) {
			sb.append(" and storeId=?");
			paramsList.add(storeId);

		}
		if (!SysFun.isNullOrEmpty(name)) {
			sb.append(" and catName like ?");
			name = "%" + name + "%";
			paramsList.add(name);
		}
		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 1L;
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
	public List<FoodCat> listByStoreId(Long id) {
		// TODO Auto-generated method stub
		List<FoodCat> list = new ArrayList<FoodCat>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From FoodCat ");
		sb.append(" where storeId=?");
		paramsList.add(id);
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
	public Long countByCatName(String name, Long storeId) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From FoodCat ");
		sb.append(" Where CatName = ? and storeid=? ");

		paramsList.add(name);
		paramsList.add(storeId);
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

}
