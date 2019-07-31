package edu.tos.dao.impl;

import java.util.*;



import java.sql.*;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.DbUtil;





public class OrderRecordDaoImpl implements OrderRecordDao{



	public Long insert(OrderRecord bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append("insert into OrderRecord(`FoodId`,`Status`,`Price`,`CreateOn` ) ");
		sb.append(" values( ? , ? , ? , ? )");
		paramsList.add(bean.getFoodId());
		paramsList.add(bean.getStatus());
		paramsList.add(bean.getPrice());
		paramsList.add(bean.getCreateOn());

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
		sb.append("delete from OrderRecord Where OrderId= ? ;");

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
	public Long update(OrderRecord bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append("update OrderRecord set FoodId = ?, Status= ? , Price = ?, CreateOn = ? ");

		sb.append(" where OrderId= ? ;");
		paramsList.add(bean.getFoodId());
		paramsList.add(bean.getStatus());
		paramsList.add(bean.getPrice());
		paramsList.add(bean.getCreateOn());

		paramsList.add(bean.getOrderId());

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
	public List<OrderRecord> list() {
		// TODO Auto-generated method stub
		List<OrderRecord> list = new ArrayList<OrderRecord>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From OrderRecord ");
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
	public OrderRecord load(Long id) {
		// TODO Auto-generated method stub
		OrderRecord bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From OrderRecord ");
		sb.append(" Where OrderId = ? ");
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
		sb.append(" Select Count(1) From OrderRecord");

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
	public OrderRecord loadByName(String name) {
		OrderRecord bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From OrderRecord ");
		sb.append(" Where FoodId Like ? ");
		sb.append(" Order By OrderId Asc");
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
		sb.append(" Select Count(1) From OrderRecord");
		sb.append(" where FoodId Like ?");
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
	public List<OrderRecord> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<OrderRecord> list = new ArrayList<OrderRecord>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From OrderRecord ");
		sb.append(" Order By OrderId Asc");
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
	public List<OrderRecord> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<OrderRecord> list = new ArrayList<OrderRecord>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * From OrderRecord ");
		sb.append(" where FoodId Like ?");
		sb.append(" Order By OrderId Asc");
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

	private OrderRecord toBean(ResultSet rs) {
		OrderRecord bean = new OrderRecord();
		try {
			bean.setOrderId(rs.getLong("OrderId"));
			bean.setFoodId(rs.getLong("FoodId"));
			bean.setStatus(rs.getString("Status"));
			bean.setPrice(rs.getLong("Price"));
			bean.setCreateOn(rs.getDate("CreateOn"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

}
