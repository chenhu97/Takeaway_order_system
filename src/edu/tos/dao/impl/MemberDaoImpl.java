package edu.tos.dao.impl;

import java.sql.*;
import java.util.*;
import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.*;

public class MemberDaoImpl implements MemberDao {

	@Override
	public Long insert(Member bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Insert Into Member (");
		sb.append(" UserName,NickName,UserPass,Sex,Address");
		sb.append(" ,Phone,CreateOn )");
		sb.append(" values( ?,?,?,?,?,?,? ) ");

		paramsList.add(bean.getUserName());
		paramsList.add(bean.getNickName());
		paramsList.add(bean.getUserPass());
		paramsList.add(bean.getSex());
		paramsList.add(bean.getAddress());
		paramsList.add(bean.getPhone());
		paramsList.add(bean.getCreateOn());

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

		sb.append(" Delete From Member ");
		sb.append(" where UserId = ?");
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
	public Long update(Member bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Update Member ");
		sb.append(" Set UserName=?,NickName=?,UserPass=?,Sex=?,Address=? ");
		sb.append(" ,Phone=?,CreateOn=? ");
		sb.append(" Where UserId=? ");

		paramsList.add(bean.getUserName());
		paramsList.add(bean.getNickName());
		paramsList.add(bean.getUserPass());
		paramsList.add(bean.getSex());
		paramsList.add(bean.getAddress());
		paramsList.add(bean.getPhone());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getUserId());

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
	public List<Member> list() {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<Member>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Member ");

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
	public Member load(Long id) {
		// TODO Auto-generated method stub
		Member bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Member ");
		sb.append(" Where UserId = ? ");

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

		sb.append(" Select Count(1) From Member ");

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
	public Member loadByName(String name) {
		// TODO Auto-generated method stub
		Member bean = null;

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Member ");
		sb.append(" Where UserName = ? ");

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

		sb.append(" Select Count(1) From Member ");
		sb.append(" Where UserName = ? ");

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
	public List<Member> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<Member>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Member ");
		sb.append(" Order By UserId Asc ");
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
	public List<Member> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<Member>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Member ");
		sb.append(" Where UserName Like ?");
		sb.append(" Order By UserId Asc ");

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

	private Member toBean(ResultSet rs) {
		// TODO Auto-generated method stub
		Member bean = new Member();

		try {
			bean.setUserId(rs.getLong("UserId"));
			bean.setUserName(rs.getString("UserName"));
			bean.setNickName(rs.getString("NickName"));
			bean.setUserPass(rs.getString("UserPass"));
			bean.setSex(rs.getString("Sex"));
			bean.setAddress(rs.getString("Address"));
			bean.setPhone(rs.getLong("Phone"));
			bean.setCreateOn(rs.getDate("CreateOn"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bean;
	}

	@Override

	public Long countBySearch(String userName, String nickName, String address) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select Count(1) From Member ");
		sb.append(" Where 1=1 ");

		if (userName != null) {
			sb.append(" and userName like ? ");
			userName = "%" + userName + "%";
			paramsList.add(userName);
		}
		if (nickName != null) {
			sb.append(" and nickName like ? ");
			nickName = "%" + nickName + "%";
			paramsList.add(nickName);
		}
		if (address != null) {
			sb.append(" and address like ? ");
			address = "%" + address + "%";
			paramsList.add(address);
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
	public List<Member> pagerBySearch(String userName, String nickName, String address, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<Member>();

		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select * From Member ");
		sb.append(" Where 1=1 ");

		if (userName != null) {
			sb.append(" and userName like ? ");
			userName = "%" + userName + "%";
			paramsList.add(userName);
		}
		if (nickName != null) {
			sb.append(" and nickName like ? ");
			nickName = "%" + nickName + "%";
			paramsList.add(nickName);
		}
		if (address != null) {
			sb.append(" and address like ? ");
			address = "%" + address + "%";
			paramsList.add(address);
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
}
