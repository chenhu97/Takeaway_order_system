package edu.tos.dao.impl;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.*;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Long insert(Order bean) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Insert into `order` ");
		sbSQL.append(" ( ");
		sbSQL.append(" payId,userId,money, ");
		sbSQL.append(" status,remark,createOn,updateOn ");
		sbSQL.append(" ) ");
		sbSQL.append("values(?,?,?, ?,?,?,?)");

		paramsList.add(bean.getPayId());
		paramsList.add(bean.getUserId());
		paramsList.add(bean.getMoney());

		paramsList.add(bean.getStatus());
		paramsList.add(bean.getRemark());
		paramsList.add(new Date());
		paramsList.add(bean.getUpdateOn());

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

		sbSQL.append(" Delete from `order` ");
		sbSQL.append(" where orderId = ? ");

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
	public Long update(Order bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Update `order` Set ");
		sbSQL.append(" payId = ? , userId = ?,money = ?, ");
		sbSQL.append(" status = ?, remark = ?,createOn = ?,updateOn = ? ");
		sbSQL.append(" where orderId = ?");

		paramsList.add(bean.getPayId());
		paramsList.add(bean.getUserId());
		paramsList.add(bean.getMoney());

		paramsList.add(bean.getStatus());
		paramsList.add(bean.getRemark());
		paramsList.add(bean.getCreateOn());
		paramsList.add(new Date());

		paramsList.add(bean.getOrderId());

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
	public List<Order> list() {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();

		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("Select * from `order`");
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
	public List<Order> listBySearch(Long storeId, Long userId, Long status) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" select O.*,M.Address,M.Phone,M.NickName ");
		sbSQL.append(" from `order` O left join orderItem I on O.orderId = I.orderId ");
		sbSQL.append(" left join member M on M.userId = O.userId ");
		sbSQL.append(" where 1=1 ");
		
		if (storeId != null) {
			sbSQL.append(" and I.storeId = ?");
			paramsList.add(storeId);
		}
		if (userId != null) {
			sbSQL.append(" And O.userId = ? ");
			paramsList.add(userId);
		}
		if (status != null) {
			sbSQL.append(" And O.status = ? ");
			String strStatus = null;
			strStatus = "" + status + "";
			paramsList.add(strStatus);
		}

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
				list.add(toBeanEx(rs));
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
	public Order load(Long id) {
		// TODO Auto-generated method stub
		Order bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		// 先不联表
		sbSQL.append(" Select * from `order` ");
		sbSQL.append(" Where orderId = ? ");

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
	public Order loadBySearch(Long storeId, Long userId, Long status) {
		// TODO Auto-generated method stub
		Order bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" select O.*,M.Address,M.Phone,M.NickName ");
		sbSQL.append(" from `order` O left join orderItem I on O.orderId = I.orderId ");
		sbSQL.append(" left join member M on M.userId = O.userId ");
		sbSQL.append(" where 1=1 ");

		if (storeId != null) {
			sbSQL.append(" And I.storeId = ? ");
			paramsList.add(storeId);
		}

		if (userId != null) {
			sbSQL.append(" And I.userId = ? ");
			paramsList.add(userId);
		}

		if (status != null) {
			sbSQL.append(" And O.status = ? ");
			String strStatus = "" + status + "";
			paramsList.add(strStatus);
		}

		sbSQL.append(" order by orderId desc ");

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

		sbSQL.append(" Select Count(1) From `order` ");
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
	public Long countBySearch(Long storeId, Long userId, Long status) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select Count(1)  ");
		sbSQL.append(" From `order` O left join orderItem I ");
		sbSQL.append(" on O.orderId = I.orderId ");
		sbSQL.append(" where 1=1 ");
		if (storeId != null) {
			sbSQL.append(" And I.storeId = ? ");
			paramsList.add(storeId);
		}
		if (userId != null) {
			sbSQL.append(" And O.userId = ? ");
			paramsList.add(userId);
		}

		if (status != null) {
			sbSQL.append(" And O.`status` = ? ");
			String strStatus = "" + status + "";
			paramsList.add(strStatus);
		}
		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;

		try {
			conn = DbUtil.getConn();
			result = DbFun.queryScalarLong(conn, sql, params);
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
	public List<Order> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from `order` ");
		sbSQL.append(" order by orderId asc ");
		// 分页
		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 10L;
		}
		Long startIndex = (pageNum - 1) * pageSize;
		sbSQL.append(" limit " + startIndex + "," + pageSize);

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		conn = DbUtil.getConn();
		rs = DbFun.query(conn, sql, params);
		try {
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
	public List<Order> pagerBySearch(Long storeId, Long userId, Long status, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" select O.*,M.Address,M.Phone,M.NickName ");
		sbSQL.append(" from `order` O inner join orderItem I on O.orderId = I.orderId ");//
		sbSQL.append(" inner join member M on M.userId = O.userId ");

		sbSQL.append(" where 1=1 ");
		if (storeId != null) {
			sbSQL.append(" and I.storeId = ?");
			paramsList.add(storeId);
		}
		if (userId != null) {
			sbSQL.append(" And O.userId = ? ");
			paramsList.add(userId);
		}
		if (status != null) {
			sbSQL.append(" And O.`status` = ? ");
			String strStatus = null;
			strStatus = "" + status + "";
			paramsList.add(strStatus);
		}
		sbSQL.append(" order by orderId asc ");
		// 分页
		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 10L;
		}
		Long startIndex = (pageNum - 1) * pageSize;
		sbSQL.append(" limit " + startIndex + "," + pageSize);
		
		
		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		conn = DbUtil.getConn();
		rs = DbFun.query(conn, sql, params);
		try {
			while (rs.next()) {
				list.add(toBeanEx(rs));
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
	public Long updateStatus(Long payId, Long status) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Update `order` Set Status=?");
		sbSQL.append(" where payId = ?");

		paramsList.add(status);
		paramsList.add(payId);

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

	public Order toBean(ResultSet rs) {
		Order bean = new Order();
		try {
			bean.setOrderId(rs.getLong("orderId"));
			bean.setPayId(rs.getLong("payId"));
			bean.setUserId(rs.getLong("userId"));
			bean.setMoney(rs.getDouble("money"));
			bean.setStatus(rs.getLong("status"));
			bean.setRemark(rs.getString("remark"));
			bean.setCreateOn(rs.getDate("createOn"));
			bean.setUpdateOn(rs.getDate("updateOn"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

	public Order toBeanEx(ResultSet rs) {
		Order bean = new Order();
		try {
			bean.setOrderId(rs.getLong("orderId"));
			bean.setPayId(rs.getLong("payId"));
			bean.setUserId(rs.getLong("userId"));
			bean.setMoney(rs.getDouble("money"));
			bean.setStatus(rs.getLong("status"));
			bean.setRemark(rs.getString("remark"));
			bean.setCreateOn(rs.getDate("createOn"));
			bean.setUpdateOn(rs.getDate("updateOn"));
			bean.setAddress(rs.getString("address"));
			bean.setPhone(rs.getLong("phone"));
			bean.setNickName(rs.getString("nickName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

	@Override
	public Long searchOrderId(Long id) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sbSQL.append(" SELECT  orderId from `order`");
		sbSQL.append(" WHERE userId=?");
		sbSQL.append(" ORDER BY `order`.createOn desc ");
		 sbSQL.append(" LIMIT 1 ");
		 paramsList.add(id);

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;

		try {
			conn = DbUtil.getConn();
			result = DbFun.queryScalarLong(conn, sql, params);
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
	public List<Order> listByUserId(Long userId) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" select * from `order` ");
		sbSQL.append(" where userId = ? ");
		
		paramsList.add(userId);
		
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
	public List<Order> pagerBySearchEx(Long userId, Long status, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" select O.*,M.Address,M.Phone,M.NickName ");
		sbSQL.append(" from `order` O ");
		sbSQL.append(" inner join member M on M.userId = O.userId ");

		sbSQL.append(" where 1=1 ");
		if (userId != null) {
			sbSQL.append(" And O.userId = ? ");
			paramsList.add(userId);
		}
		if (status != null) {
			sbSQL.append(" And O.`status` = ? ");
			String strStatus = null;
			strStatus = "" + status + "";
			paramsList.add(strStatus);
		}
		sbSQL.append(" order by orderId asc ");
		// 分页
		if (pageNum < 1) {
			pageNum = 1L;
		}
		if (pageSize < 1) {
			pageSize = 10L;
		}
		Long startIndex = (pageNum - 1) * pageSize;
		sbSQL.append(" limit " + startIndex + "," + pageSize);

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		conn = DbUtil.getConn();
		rs = DbFun.query(conn, sql, params);
		try {
			while (rs.next()) {
				list.add(toBeanEx(rs));
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

	// public Long ToPaied(Long payId) {
	// // TODO Auto-generated method stub
	// Long result = 0L;
	// StringBuffer sbSQL = new StringBuffer();
	// List<Object> paramsList = new ArrayList<Object>();
	//
	// sbSQL.append(" Update `order` Set Status=-1");
	// sbSQL.append(" where payId = ?");
	//
	// paramsList.add(payId);
	//
	// String sql = sbSQL.toString();
	// Object[] params = paramsList.toArray();
	//
	// Connection conn = null;
	// try {
	// conn = DbUtil.getConn();
	// result = DbFun.update(conn, sql, params);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// throw new RuntimeException(e);
	// } finally {
	// DbUtil.close(conn);
	// }
	// return result;
	//
	// }

}
