package edu.tos.dao.impl;

import java.util.*;

import java.sql.*;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.dao.*;
import edu.tos.util.DbUtil;

public class StoreDaoImpl implements StoreDao {

	public Long insert(Store bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" insert into Store(StoreName,Address,Phone,storePic,status ");
		sb.append(" ,announce,createOn,storeBoss,storeLogName,storePass,storeCatId )");
		sb.append(" values( ?,?,?,?,?,?,?,?,?,?,? )");

		paramsList.add(bean.getStoreName());
		paramsList.add(bean.getAddress());
		paramsList.add(bean.getPhone());
		paramsList.add(bean.getStorePic());
		paramsList.add(bean.getStatus());
		paramsList.add(bean.getAnnounce());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getStoreBoss());
		paramsList.add(bean.getStoreLogName());
		paramsList.add(bean.getStorePass());
		paramsList.add(bean.getStoreCatId());

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
		sb.append(" delete from Store Where StoreId= ? ;");

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
	public Long update(Store bean) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append("update Store set StoreName=?,Address=?,Phone=?, ");
		sb.append(" storePic=?,status=?,announce = ?,createOn=? ");
		sb.append(" ,storeBoss=?,storeLogName=?,storePass=?,storeCatId=? ");
		sb.append(" where StoreId= ? ");

		paramsList.add(bean.getStoreName());
		paramsList.add(bean.getAddress());
		paramsList.add(bean.getPhone());
		paramsList.add(bean.getStorePic());
		paramsList.add(bean.getStatus());
		paramsList.add(bean.getAnnounce());
		paramsList.add(bean.getCreateOn());
		paramsList.add(bean.getStoreBoss());
		paramsList.add(bean.getStoreLogName());
		paramsList.add(bean.getStorePass());
		paramsList.add(bean.getStoreCatId());
		paramsList.add(bean.getStoreId());

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
	public List<Store> list() {
		// TODO Auto-generated method stub
		List<Store> list = new ArrayList<Store>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select C.storeCatName,S.* ");
		sb.append(" from store S LEFT JOIN storecat C ");
		sb.append(" on C.storeCatId = S.storeCatId ");

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
	public Store load(Long id) {
		// TODO Auto-generated method stub
		Store bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select S.*,C.storeCatName from Store S ");
		sb.append(" left join storecat C on C.storeCatId = S.storeCatId ");
		sb.append(" Where S.StoreId = ? ");

		paramsList.add(id);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();

			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
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
		sb.append(" Select Count(1) From Store");

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
	public Store loadByName(String name) {
		Store bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select S.*,C.storeCatName from Store S ");
		sb.append(" left join storecat C on C.storeCatId = S.storeCatId ");
		sb.append(" Where S.StoreLogName = ? ");

		paramsList.add(name);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();

			rs = DbFun.query(conn, sql, params);
			while (rs.next()) {
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
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select Count(1) From Store");
		sb.append(" where StoreName Like ?");
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

	public List<Store> pager(Long status, Long pageNum, Long pageSize) {

		// TODO Auto-generated method stub
		List<Store> list = new ArrayList<Store>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select S.*,C.storeCatName ");
		sb.append(" From Store S LEFT JOIN storecat C on S.StorecatId = C.storeCatId ");
		sb.append(" where S.status = ? ");
		paramsList.add(status);

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

	@Override
	public List<Store> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Store> list = new ArrayList<Store>();
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();

		sb.append(" Select S.*,C.storeCatName ");
		sb.append(" From Store S LEFT JOIN storecat C on S.StorecatId = C.storeCatId ");
		sb.append(" where S.StoreName Like ? and ststus=1");
		sb.append(" Order By S.StoreId Asc");
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
	public List<Store> listBySearch(String name, String address, Long storeCatId, Long storeId) {
		// TODO Auto-generated method stub
		List<Store> list = new ArrayList<Store>();

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select S.*,C.storeCatName from Store S ");
		sbSQL.append(" left join storecat C on C.storeCatId = S.storeCatId ");
		sbSQL.append(" where 1=1 ");

		if (name != null) {
			sbSQL.append(" and S.storeName like ? ");
			name = "%" + name + "%";
			paramsList.add(name);
		}
		if (address != null) {
			sbSQL.append(" and S.address like ? ");
			address = "%" + address + "%";
			paramsList.add(address);
		}
		if (storeCatId != null) {
			sbSQL.append(" and C.storeCatId = ? ");
			paramsList.add(storeCatId);
		}
		if (storeId != null) {
			sbSQL.append(" and S.storeId = ? ");
			paramsList.add(storeCatId);
		}
		sbSQL.append(" order by S.StoreId asc ");

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
	public Store loadBySearch(String name, String address, Long storeCatId) {
		// TODO Auto-generated method stub
		Store bean = null;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select S.*,C.storeCatName from Store S ");
		sbSQL.append(" left join storecat C on C.storeCatId = S.storeCatId ");

		sbSQL.append(" where 1=1 ");

		if (name != null) {
			sbSQL.append(" and S.storeName like ? ");
			name = "%" + name + "%";

			paramsList.add(name);
		}
		if (address != null) {

			sbSQL.append(" and S.address like ? ");
			address = "%" + address + "%";

			paramsList.add(address);
		}
		if (storeCatId != null) {
			sbSQL.append(" and S.storeCatId =? ");
			paramsList.add(storeCatId);
		}
		sbSQL.append(" order by S.StoreId asc ");

		String sql = sbSQL.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConn();
			rs = DbFun.query(conn, sql, params);
			if (rs.next()) {
				bean = toBeanEx(rs);
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
	public Long countBySearch(String name, String address, Long storeCatId, Long status) {
		// TODO Auto-generated method stub
		Long result = 0L;

		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();

		sbSQL.append(" Select Count(1) From store ");
		sbSQL.append(" where 1=1 ");

		if (name != null) {
			sbSQL.append(" and storeName like ? ");
			name = "%" + name + "%";
			paramsList.add(name);
		}
		if (address != null) {
			sbSQL.append(" and address like ? ");
			address = "%" + address + "%";
			paramsList.add(address);
		}
		if (storeCatId != null) {
			sbSQL.append(" and storeCatId = ? ");
			paramsList.add(storeCatId);
		}
		if (status != null) {
			
			sbSQL.append(" and status = ? ");
			String str = "" + status + "";
			paramsList.add(str);
		}

		String sql = sbSQL.toString();
		System.out.println(" 合成的语句为: " + sql);
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
	public List<Store> pagerBySearch(String name, Long status, String address, Long storeCatId, Long pageNum,
			Long pageSize) {
		// TODO Auto-generated method stub
		List<Store> list = new ArrayList<Store>();
		StringBuffer sbSQL = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sbSQL.append(" Select S.*,C.storeCatName from Store S ");
		sbSQL.append(" left join storecat C on C.storeCatId = S.storeCatId ");
		sbSQL.append(" where 1 = 1 ");

		if (name != null) {
			sbSQL.append(" and S.storeName like ? ");
			name = "%" + name + "%";
			paramsList.add(name);
		}
		if (status != null) {
			sbSQL.append(" and status = ? ");
			String str = "" + status + "";
			paramsList.add(str);
		}
		if (address != null) {
			sbSQL.append(" and S.address like ? ");
			address = "%" + address + "%";
			paramsList.add(address);
		}
		if (storeCatId != null) {

			sbSQL.append(" and S.storeCatId = ? ");

			paramsList.add(storeCatId);
		}

		sbSQL.append(" order by S.StoreId asc ");
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
	public Long searchByLogName(String logName) {
		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select Count(1) From Store");
		sb.append(" where storeLogName=?");
		paramsList.add(logName);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();

			result = DbFun.queryScalarLong(conn, sql, params);
			System.out.println(result);

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
	public Long searchByName(String name) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Long result = 0L;
		StringBuffer sb = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select Count(1) From Store");
		sb.append(" where storeName=?");
		paramsList.add(name);
		String sql = sb.toString();
		Object[] params = paramsList.toArray();

		Connection conn = null;
		try {
			conn = DbUtil.getConn();

			result = DbFun.queryScalarLong(conn, sql, params);
			System.out.println(result);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtil.close(conn);
		}
		return result;

	}

	private Store toBean(ResultSet rs) {
		Store bean = new Store();
		try {
			bean.setStoreId(rs.getLong("StoreId"));
			bean.setStoreName(rs.getString("StoreName"));
			bean.setAddress(rs.getString("Address"));
			bean.setPhone(rs.getLong("Phone"));
			bean.setCreateOn(rs.getDate("CreateOn"));
			bean.setStorePic(rs.getString("StorePic"));
			bean.setStatus(rs.getLong("Status"));
			bean.setStoreBoss(rs.getString("StoreBoss"));
			bean.setStoreCatId(rs.getLong("storeCatId"));
			bean.setStoreLogName(rs.getString("StoreLogName"));
			bean.setStorePass(rs.getString("StorePass"));
			bean.setAnnounce(rs.getString("Announce"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

	private Store toBeanEx(ResultSet rs) {
		Store bean = new Store();
		try {
			bean.setStoreId(rs.getLong("StoreId"));
			bean.setStoreName(rs.getString("StoreName"));
			bean.setAddress(rs.getString("Address"));
			bean.setPhone(rs.getLong("Phone"));
			bean.setCreateOn(rs.getDate("CreateOn"));
			bean.setStorePic(rs.getString("StorePic"));
			bean.setStatus(rs.getLong("Status"));
			bean.setStoreBoss(rs.getString("StoreBoss"));
			bean.setStoreCatId(rs.getLong("StoreCatId"));
			bean.setStoreLogName(rs.getString("StoreLogName"));
			bean.setStorePass(rs.getString("StorePass"));
			bean.setAnnounce(rs.getString("Announce"));
			bean.setStoreCatName(rs.getString("StoreCatName"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}




	public Store loadById(Long id) {
		// TODO Auto-generated method stub
		Store bean = null;
		StringBuilder sb = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		sb.append(" Select * from Store ");
		sb.append(" Where StoreId = ? ");

		paramsList.add(id);
		String sql = sb.toString();

		Object[] params = paramsList.toArray();

		Connection conn = null;
		ResultSet rs = null;


		conn = DbUtil.getConn();
		rs = DbFun.query(conn, sql, params);

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

}
