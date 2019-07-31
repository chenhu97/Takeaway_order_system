package edu.tos.dao.impl;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.*;

public class FoodsDaoImpl implements FoodsDao {

	@Override
	public Long insert(Foods bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Insert Into Foods (");
		sb.append(" StoreId,CatId,FoodName,Remark,PicPath");
		sb.append(" ,Price,CreateOn )");
		sb.append(" values( ?,?,?,?,?,?,? ) ");

		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getCatId());
		paramsList.add(bean.getFoodName());
		paramsList.add(bean.getRemark());
		paramsList.add(bean.getPicPath());
		paramsList.add(bean.getPrice());
		paramsList.add(new Date());

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

		sb.append(" Delete From Foods ");
		sb.append(" where FoodId = ?");
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
	public Long update(Foods bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Update Foods Set ");
		sb.append(" StoreId=?,CatId=?,FoodName=?,Remark=?,PicPath=? ");
		sb.append(" ,Price=?,CreateOn=? ");
		sb.append(" Where FoodId=? ");

		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getCatId());
		paramsList.add(bean.getFoodName());
		paramsList.add(bean.getRemark());
		paramsList.add(bean.getPicPath());
		paramsList.add(bean.getPrice());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getFoodId());

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
	public List<Foods> list() {
		// TODO Auto-generated method stub
		List<Foods> list = new ArrayList<Foods>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append("SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			while (rs.next()) {
				list.add(toBeanEx(rs));
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
	public List<Foods> listById(Long storeId) {
		// TODO Auto-generated method stub
		List<Foods> list = new ArrayList<Foods>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append("SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");
		sb.append(" where F.StoreId = ? ");

		paramsList.add(storeId);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			while (rs.next()) {
				list.add(toBeanEx(rs));
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
	public Foods load(Long id) {
		// TODO Auto-generated method stub
		Foods bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append("SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");
		sb.append(" Where F.FoodId = ? ");

		paramsList.add(id);

		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			if (rs.next()) {
				bean = toBeanEx(rs);
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

		sb.append(" Select Count(1) From Foods ");

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
	public Foods loadBySearch(Long storeId, String name) {
		// TODO Auto-generated method stub
		Foods bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");
		sb.append(" Where F.storeId = ? and F.FoodName like ? ");
		sb.append(" Order By F.FoodId Asc");
		
		paramsList.add(storeId);
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
				bean = toBeanEx(rs);
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
	public Long countBySearch(Long storeId, String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From Foods ");
		sb.append(" where 1=1 ");

		if (storeId != null) {
			sb.append(" and StoreId = ? ");
			paramsList.add(storeId);
		}
		if (name != null) {
			sb.append(" and FoodName like ? ");
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
	public List<Foods> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Foods> list = new ArrayList<Foods>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append("SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");
		sb.append(" Order By F.FoodId Asc ");
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
	public List<Foods> pagerBySearch(Long storeId, String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Foods> list = new ArrayList<Foods>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append("SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");
		sb.append(" where 1=1 ");
		if (storeId != null) {
			sb.append(" and F.storeId = ? ");
			paramsList.add(storeId);
		}
		if (name != null) {
			sb.append(" and F.FoodName Like ? ");
			name = "%" + name + "%";
			paramsList.add(name);
		}

		sb.append(" Order By F.FoodId Asc ");

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
				list.add(toBeanEx(rs));
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

	private Foods toBean(ResultSet rs) {
		// TODO Auto-generated method stub
		Foods bean = new Foods();

		try {
			bean.setFoodId(rs.getLong("FoodId"));
			bean.setStoreId(rs.getLong("StoreId"));
			bean.setCatId(rs.getLong("CatId"));
			bean.setFoodName(rs.getString("FoodName"));
			bean.setRemark(rs.getString("Remark"));
			bean.setPicPath(rs.getString("PicPath"));
			bean.setPrice(rs.getLong("Price"));
			bean.setCreateOn(rs.getDate("CreateOn"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bean;
	}

	private Foods toBeanEx(ResultSet rs) {
		// TODO Auto-generated method stub
		Foods bean = new Foods();

		try {
			bean.setFoodId(rs.getLong("FoodId"));
			bean.setStoreId(rs.getLong("StoreId"));
			bean.setCatId(rs.getLong("CatId"));
			bean.setFoodName(rs.getString("FoodName"));
			bean.setRemark(rs.getString("Remark"));
			bean.setPicPath(rs.getString("PicPath"));
			bean.setPrice(rs.getLong("Price"));
			bean.setCreateOn(rs.getDate("CreateOn"));
			bean.setCatName(rs.getString("catName"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bean;
	}

	@Override
	public List<Foods> listByStoreIdaAndcatId(Long storeId, Long catId) {
		// TODO Auto-generated method stub
		List<Foods> list = new ArrayList<Foods>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append("SELECT F.*,C.catName FROM foods F LEFT JOIN foodcat C ON F.CatId = C.catId");
		sb.append(" where F.StoreId = ? and  F.CatId= ? ");

		paramsList.add(storeId);
		paramsList.add(catId);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);

			while (rs.next()) {
				list.add(toBeanEx(rs));
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

}
