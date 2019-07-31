package edu.tos.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liuvei.common.DbFun;

import edu.tos.bean.Favorite;
import edu.tos.bean.Store;
import edu.tos.dao.FavoriteDao;
import edu.tos.util.DbUtil;

public class FavoriteDaoImpl implements FavoriteDao {

	@Override
	public Long insert(Favorite bean) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append("Insert into Favorite ");
		sbSQL.append(" ( ");
		sbSQL.append(" storeId,userId ");
		sbSQL.append(" ) ");
		sbSQL.append(" values( ? , ? )");

		
		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getUserId());

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

		sbSQL.append(" Delete from `Favorite` ");
		sbSQL.append(" where FavoriteId = ? ");

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
	public Long update(Favorite bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Update Favorite Set ");
		sbSQL.append(" storeId = ?, userId = ? ");
		sbSQL.append(" where FavoriteId = ?");
		
		paramsList.add(bean.getStoreId());
		paramsList.add(bean.getUserId());

		paramsList.add(bean.getFavoriteId());

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
	public List<Favorite> list() {
		// TODO Auto-generated method stub
		List<Favorite> list = new ArrayList<Favorite>();

		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("Select * from `Favorite`");
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
	public List<Favorite> listBySearch(Long favoriteId, Long storeId, Long userId) {
		// TODO Auto-generated method stub
		List<Favorite> list = new ArrayList<Favorite>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from Favorite ");
		sbSQL.append(" where 1=1 ");

		if (favoriteId != null) {
			sbSQL.append(" and favoriteId = ? ");
			paramsList.add(favoriteId);
		}
		if (storeId != null) {
			sbSQL.append(" and storeId = ? ");
			paramsList.add(storeId);
		}
		if (userId != null) {
			sbSQL.append(" and userId = ? ");
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
	public Favorite load(Long id) {
		// TODO Auto-generated method stub
		Favorite bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from `Favorite` ");
		sbSQL.append(" Where FavoriteId = ? ");

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
	public Favorite loadBySearch(Long favoriteId, Long storeId, Long userId) {
		// TODO Auto-generated method stub
		Favorite bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select * from Favorite ");
		sbSQL.append(" where 1=1 ");

		if (favoriteId != null) {
			sbSQL.append(" and favoriteId = ?");
			paramsList.add(favoriteId);
		}

		if (storeId != null) {
			sbSQL.append(" and storeId = ?");
			paramsList.add(storeId);
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

		sbSQL.append(" Select Count(1) From `Favorite` ");
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
	public Long countBySearch(Long favoriteId, Long storeId, Long userId) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select Count(1) From `Favorite` ");
		sbSQL.append(" where 1=1 ");

		if (favoriteId != null) {
			sbSQL.append(" and favoriteId = ?");
			paramsList.add(favoriteId);
		}
		if (storeId != null) {
			sbSQL.append(" and storeId = ?");
			paramsList.add(storeId);
		}
		if (userId != null) {
			sbSQL.append(" and userId = ?");
			paramsList.add(userId);
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
	@Override
	public List<Favorite> listBySearch(Long userId) {
		// TODO Auto-generated method stub
		List<Favorite> list = new ArrayList<Favorite>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select F.*,S.storeName,S.Address,s.Phone from Favorite F ");
		sbSQL.append(" left join Store S on S.storeId = F.storeId ");
		sbSQL.append(" WHERE UserId = ? ");
		sbSQL.append(" ORDER BY F.FavoriteId asc ");
		
		paramsList.add(userId);

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


	private Favorite toBeanEx(ResultSet rs) {
		// TODO Auto-generated method stub
		Favorite bean = new Favorite();
		try {
			bean.setFavoriteId(rs.getLong("FavoriteId"));
			bean.setStoreId(rs.getLong("storeId"));
			bean.setUserId(rs.getLong("userId"));
			bean.setStoreName(rs.getString("storeName"));
			bean.setAddress(rs.getString("address"));
			bean.setPhone(rs.getLong("phone"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

	public Favorite toBean(ResultSet rs) {
		Favorite bean = new Favorite();
		try {
			bean.setFavoriteId(rs.getLong("FavoriteId"));
	
			bean.setStoreId(rs.getLong("storeId"));
		
			bean.setUserId(rs.getLong("userId"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;

	}

}
