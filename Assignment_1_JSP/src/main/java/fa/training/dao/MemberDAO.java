package fa.training.dao;

import java.sql.SQLException;

import fa.training.entity.Member;

public interface MemberDAO {
	public Member Login(String email, String password) throws SQLException;
	
	public boolean UpdateMember(int id, String firstname, String lastname, String phone, String description) throws SQLException;

	public void AddMember(Member member) throws SQLException;
}
