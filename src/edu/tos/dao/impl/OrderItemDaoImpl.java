package edu.tos.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liuvei.common.DbFun;

import edu.tos.bean.OrderItem;
import edu.tos.dao.OrderItemDao;
import edu.tos.util.DbUtil;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public Long insert(OrderItem bean) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append("Insert into orderItem ");
		sbSQL.append(" ( ");
		sbSQL.append(" orderId,storeId,foodName,quantity ");
		sbSQL.append(" ) ");
		sbSQL.append(" values(?,?,?,?)");

		paramsList.add(bean.getOrderId());
		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getFoodName());
		paramsList.add(bean.getQuantity());

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			Long num = DbFun.update(conn, sql, params);
			if (num > 0) {
				sql = " Select @@identity";
				result = DbFun.queryScalarLong(conn, sql);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Delete from `OrderItem` ");
		sbSQL.append(" where orderItemId = ? ");

		paramsList.add(id);

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			result = DbFun.update(conn, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}

		return result;
	}

	@Override
	public Long update(OrderItem bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Update orderItem Set ");
		sbSQL.append(" orderId = ?, storeId = ?, foodName = ?, quantity = ? ");
		sbSQL.append(" where orderItemId = ?");
		
		paramsList.add(bean.getOrderId());
		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getFoodName());
		paramsList.add(bean.getQuantity());

		paramsList.add(bean.getOrderItemId());

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			result = DbFun.update(conn, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;
	}

	@Override
	public List<OrderItem> list() {
		// TODO Auto-generated method stub
		List<OrderItem> list = new ArrayList<OrderItem>();

		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("Select * from `orderItem`");
		String sql = sbSQL.toString();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql);
			while (rs.next()) {
				list.add(toBean(rs));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}

		return list;
	}

	@Override
	public List<OrderItem> listBySearch(Long orderId, Long storeId, Long foodId) {
		// TODO Auto-generated method stub
		List<OrderItem> list = new ArrayList<OrderItem>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from orderItem ");
		sbSQL.append(" where 1=1 ");

		if (orderId != null) {
			sbSQL.append(" and orderId = ? ");
			paramsList.add(orderId);
		}
		if (storeId != null) {
			sbSQL.append(" and storeId = ? ");
			paramsList.add(storeId);
		}
		if (foodId != null) {
			sbSQL.append(" and foodId = ? ");
			paramsList.add(foodId);
		}

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
				list.add(toBean(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}

		return list;
	}

	@Override
	public OrderItem load(Long id) {
		// TODO Auto-generated method stub
		OrderItem bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from `OrderItem` ");
		sbSQL.append(" Where orderItemId = ? ");

		paramsList.add(id);

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			if (rs.next()) {
				bean = toBean(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}

		return bean;
	}

	@Override
	public OrderItem loadBySearch(Long orderId, Long storeId, Long foodId) {
		// TODO Auto-generated method stub
		OrderItem bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from orderItem ");
		sbSQL.append(" where 1=1 ");

		if (orderId != null) {
			sbSQL.append(" and orderId = ?");
			paramsList.add(orderId);
		}

		if (storeId != null) {
			sbSQL.append(" and storeId = ?");
			paramsList.add(storeId);
		}
		if (foodId != null) {
			sbSQL.append(" and foodId = ?");
			paramsList.add(foodId);
		}
		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			if (rs.next()) {
				bean = toBean(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		StringBuffer sbSQL = new StringBuffer();

		sbSQL.append(" Select Count(1) From `OrderItem` ");
		String sql = sbSQL.toString();

		Connection conn = null;

		try {
			conn = DbUtil.getConn();
			result = DbFun.queryScalarLong(conn, sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}

		return result;
	}

	@Override
	public Long countBySearch(Long orderId, Long storeId, Long foodId) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select Count(1) From `OrderItem` ");
		sbSQL.append(" where 1=1 ");

		if (orderId != null) {
			sbSQL.append(" and orderId = ?");
			paramsList.add(orderId);
		}
		if (storeId != null) {
			sbSQL.append(" and storeId = ?");
			paramsList.add(storeId);
		}
		if (foodId != null) {
			sbSQL.append(" and foodId = ?");
			paramsList.add(foodId);
		}
		String sql = sbSQL.toString();

		Connection conn = null;

		try {
			conn = DbUtil.getConn();
			result = DbFun.queryScalarLong(conn, sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}

		return result;
	}

	public OrderItem toBean(ResultSet rs) {
		OrderItem bean = new OrderItem();
		try {
			bean.setOrderItemId(rs.getLong("orderItemId"));
			bean.setOrderId(rs.getLong("orderId"));
			bean.setStoreId(rs.getLong("storeId"));
			bean.setFoodName(rs.getString("foodName"));
			bean.setQuantity(rs.getLong("quantity"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;

	}

}
