package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.entity.Member;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;


public class MemberDAOImpl implements MemberDAO{

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	@Override
	public Member Login (String email, String password) throws SQLException {

		Member member = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LOGIN);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			results = preparedStatement.executeQuery();
			if (results.next()) {
				member = new Member();
				member.setId(results.getInt("id"));	
				member.setFirstname(results.getString("Firstname"));
				member.setLastname(results.getString("Lastname"));
				member.setUsername(results.getString("Username"));
				member.setPassword(results.getString("Password"));
				member.setPhone(results.getString("Phone"));
				member.setEmail(results.getString("Email"));
				member.setDescription(results.getString("Description"));
				member.setCreatedDate(results.getDate("CreatedDate"));
				member.setUpdateTime(results.getDate("UpdateTime"));
				return member;
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DBUtils.getInstance().getConnection();
		System.out.println(connection);
		MemberDAO md = new MemberDAOImpl();
		System.out.println(md.Login("1", "1"));
	}

	@Override
	public boolean UpdateMember(int id, String firstname, String lastname, String phone, String description) throws SQLException {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_MEMBER);
			preparedStatement.setString(1, firstname);		
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, description);		
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
			isUpdated = true;
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return isUpdated;
	}

	
	@Override
	public void AddMember(Member member) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ADD_MEMBER);
			preparedStatement.setString(1, member.getUsername());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getEmail());
			preparedStatement.executeUpdate();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
