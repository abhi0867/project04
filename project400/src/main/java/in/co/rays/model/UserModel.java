package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsom", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstNmae());
		ps.setString(3, bean.getLastNamt());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAddress());
		int i = ps.executeUpdate();

		System.out.println("Data inserted =" + i);

	}

	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsom", "root", "root");
		PreparedStatement ps = conn.prepareStatement(
				"update user set firstName=?, lastName=?, loginId=?, password=?,address=? where id=?");

		ps.setString(1, bean.getFirstNmae());
		ps.setString(2, bean.getLastNamt());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAddress());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("Data updated =" + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsom", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from user where id =?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("Data deleted =" + i);
	}

	
	public UserBean authenticate(String loginId, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsom", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select* from user where loginid=? and password=?");
		
		ps.setString(1, loginId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstNmae(rs.getString(2));
			bean.setLastNamt(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}
		return bean;

	}
	
	public List Search(UserBean bean)throws Exception{
		Class .forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsom","root","root");
		
		StringBuffer sql = new StringBuffer("Select* from User where 1=1");
		if(bean!= null) {
			if (bean.getFirstNmae() != null && bean.getFirstNmae().length() > 0) {
				sql.append("and fnamw like '" + bean.getFirstNmae() + "'%");

			}
		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps .executeQuery();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			bean= new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstNmae(rs.getString(2));
			bean.setLastNamt(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			
			list.add(bean);
		
			
		}
		return list;
		
		
		
		
		
		
		
		
		
		}
	
	
	

}