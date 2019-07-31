package edu.tos.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liuvei.common.DbFun;


import edu.tos.bean.Message;
import edu.tos.dao.MessageDao;
import edu.tos.util.DbUtil;

public class MessageDaoImpl implements MessageDao {

	@Override
	public Long insert(Message bean) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Insert into message ");
		sbSQL.append(" ( ");
		sbSQL.append(" storeId,orderId,userId,foodName,createOn,content ");
		sbSQL.append(" ) ");
		sbSQL.append("values(?,?,?,?,?,?)");

		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getOrderId());
		paramsList.add(bean.getUserId());
		paramsList.add(bean.getFoodName());
		paramsList.add(new Date());
		paramsList.add(bean.getContent());

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

		sbSQL.append(" Delete from message ");
		sbSQL.append(" where messageId = ? ");
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
	public Long update(Message bean) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sbSQL.append(" Update message ");
		sbSQL.append(" Set storeId = ?, orderId = ?, userId =?,foodName=?, createOn = ?, content = ?");
		sbSQL.append(" where messageId =? ");

		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getOrderId());
		paramsList.add(bean.getUserId());
		paramsList.add(bean.getFoodName());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getContent());

		paramsList.add(bean.getMessageId());

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
	public List<Message> list() {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();

		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("Select * from message ");

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
	public List<Message> listBySearch(Long storeId, Long orderId, Long userId) {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select M.*,N.NickName from message M");
		sbSQL.append(" left join member N ON M.UserId=N.UserId");
		sbSQL.append(" where 1=1 ");

		if (storeId != null) {
			sbSQL.append(" and M.storeId =? ");
			paramsList.add(storeId);
		}
		if (orderId != null) {
			sbSQL.append(" and M.orderId = ?");
			paramsList.add(orderId);
		}
		if (userId != null) {
			sbSQL.append(" and M.userId = ?");
			paramsList.add(userId);
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
	public Message load(Long id) {
		// TODO Auto-generated method stub
		Message bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from message ");
		sbSQL.append(" where messageId = ?");
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
	public Message loadBySearch(Long storeId, Long orderId, Long userId) {
		// TODO Auto-generated method stub
		Message bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from message ");
		sbSQL.append(" where 1=1");

		if (storeId != null) {
			sbSQL.append(" and storeId =? ");
			paramsList.add(storeId);
		}
		if (orderId != null) {
			sbSQL.append(" and orderId = ?");
			paramsList.add(orderId);
		}
		if (userId != null) {
			sbSQL.append(" and userId = ?");
			paramsList.add(userId);
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

		sbSQL.append(" Select Count(1) From 'message' ");
		
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
	public Long countBySearch(Long storeId, Long orderId, Long userId) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select Count(1) From message ");
		sbSQL.append(" where 1=1");

		if (storeId != null) {
			sbSQL.append(" and storeId =? ");
			paramsList.add(storeId);
		}
		if (orderId != null) {
			sbSQL.append(" and orderId = ?");
			paramsList.add(orderId);
		}
		if (userId != null) {
			sbSQL.append(" and userId = ?");
			paramsList.add(userId);
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
	public List<Message> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from 'message' ");
		sbSQL.append(" order by messageId asc ");
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
	public List<Message> pagerBySearch(Long storeId, Long orderId, Long userId, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from 'order' ");
		sbSQL.append(" where 1 = 1 ");

		if (storeId != null) {
			sbSQL.append(" and storeId =? ");
			paramsList.add(storeId);
		}
		if (orderId != null) {
			sbSQL.append(" and footId =? ");
			paramsList.add(orderId);
		}
		if (userId != null) {
			sbSQL.append(" and userId =? ");
			paramsList.add(userId);
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

	public Message toBean(ResultSet rs) {
		Message bean = new Message();
		try {
			bean.setMessageId(rs.getLong("messageId"));
			bean.setStoreId(rs.getLong("storeId"));
			bean.setOrderId(rs.getLong("orderId"));
			bean.setUserId(rs.getLong("userId"));
			bean.setFoodName(rs.getString("foodName"));
			bean.setCreateOn(rs.getString("createOn"));
			bean.setContent(rs.getString("content"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bean;
	}
	public Message toBeanEx(ResultSet rs) {
		Message bean = new Message();
		try {
			bean.setMessageId(rs.getLong("messageId"));
			bean.setStoreId(rs.getLong("storeId"));
			bean.setOrderId(rs.getLong("orderId"));
			bean.setUserId(rs.getLong("userId"));
			bean.setFoodName(rs.getString("foodName"));
			bean.setCreateOn(rs.getString("createOn"));
			bean.setContent(rs.getString("content"));
			bean.setNickName(rs.getString("NickName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bean;
	}
}
