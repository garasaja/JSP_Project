package second.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import second.db.DBConn;
import second.model.Member;


// DAO
public class MemberRepository {
	
	private static final String TAG = "UsersRepository : ";
	private static MemberRepository instance = new MemberRepository();
	private MemberRepository() {}
	public static MemberRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 수정
	public Member findByUsername(String username) {
		final String SQL = "SELECT * FROM users WHERE username = ?";
		Member member = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, username);
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setUserProfile(rs.getString("userProfile"));
				member.setUserRole(rs.getString("userRole"));
				member.setCreateDate(rs.getTimestamp("createDate"));
				
				return member;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findByUsername : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public Member findByUsernameAndPassword(String username, String password) {
		final String SQL = "SELECT id, username, email, address, userProfile, userRole, createDate FROM users WHERE username = ? AND password = ?";
		Member member = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setUserProfile(rs.getString("userProfile"));
				member.setUserRole(rs.getString("userRole"));
				member.setCreateDate(rs.getTimestamp("createDate"));
			}
			
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findByUsernameAndPassword : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public int save(Member member) {
		final String SQL = "INSERT INTO member(id, username, password, email, address, userRole, createDate) VALUES(USERS_SEQ.nextval, ?,?,?,?,?,sysdate)";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getUserRole());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(int id, String userProfile) {
		final String SQL = "UPDATE member SET userProfile = ? WHERE id = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, userProfile);
			pstmt.setInt(2, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"update(id, userProfile) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	public int update(Member member) {
		final String SQL = "UPDATE member SET password = ?, email = ?, address = ? WHERE id = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getAddress());
			pstmt.setInt(4, member.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"update : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	public int deleteById(int id) {
		final String SQL = "";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteById : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	public List<Member> findAll() {
		final String SQL = "";
		List<Member> member = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			
			// while 돌려서 rs -> java오브젝트에 집어넣기
			
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public Member findById(int id) {
		final String SQL = "SELECT * FROM users WHERE id = ?";
		Member member = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = Member.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.address(rs.getString("address"))
						.userProfile(rs.getString("userProfile"))
						.createDate(rs.getTimestamp("createDate"))
						.build();				
			}
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findById : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
}
