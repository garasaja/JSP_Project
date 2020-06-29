package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.dto.ProductResponseDto;
import com.cos.blog.model.Product;


public class ProductRepository {
	private static final String TAG = "ProductRepository : ";
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int profile(int pid, String pprofile) {
		final String SQL = "UPDATE product SET pProfile = ? WHERE pid = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, pprofile);
			pstmt.setInt(2, pid);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"update(id, userProfile) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	public int update(Product product) {
		final String SQL = "UPDATE product SET ptitle = ?, pcontent = ?,pcategory = ?, pplace = ?, pprice = ? pprofile = ? WHERE pid = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, product.getPtitle());
			pstmt.setString(2, product.getPcontent());
			pstmt.setString(3, product.getPcategory());
			pstmt.setString(4, product.getPplace());
			pstmt.setInt(5, product.getPprice());
			pstmt.setString(6, product.getPprofile());
			pstmt.setInt(7, product.getPid());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"update : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	public ProductResponseDto findById(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.id, p.userId, p.title, p.content, p.readCount, p.createDate, u.username ");
		sb.append("FROM product p INNER JOIN users u ");
		sb.append("ON p.userId = u.id ");
		sb.append("WHERE p.id = ?");
		final String SQL = sb.toString();
		ProductResponseDto productDto = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기 
			pstmt.setInt(1, id);
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productDto = new ProductResponseDto();
				Product product = Product.builder()
						.pid(rs.getInt(1))
						.puserId(rs.getInt(2))
						.ptitle(rs.getString(3))
						.pcategory(rs.getString(4))
						.pplace(rs.getString(5))
						.pcontent(rs.getString(6))
						.preadCount(rs.getInt(7))
						.pcreateDate(rs.getTimestamp(8))
						.build();
				productDto.setProduct(product);
				productDto.setUsername(rs.getString(7));
				
			}
			return productDto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findById : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public List<Product> findAll(int pid) {
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate,pprofile FROM product WHERE PID = ? ORDER BY pid DESC";
		List<Product> productlist = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = Product.builder()
						.pid(rs.getInt(1))
						.puserId(rs.getInt(2))
						.ptitle(rs.getString(3))
						.pcategory(rs.getString(4))
						.pplace(rs.getString(5))
						.pcontent(rs.getString(6))
						.preadCount(rs.getInt(7))
						.pcreateDate(rs.getTimestamp(8))
						.pprofile(rs.getString(9))
						.build();
						//rs.getInt("pid")
						/*rs.getInt("pid"),
						rs.getInt("puserId"),
						rs.getString("ptitle"),
						rs.getString("pcategory"),
						rs.getString("pplace"),
						rs.getString("pcontent"),
						rs.getInt("preadcount"),
						rs.getTimestamp("createDate")*/
				
				productlist.add(product);
			}
			
			return productlist;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public List<Product> findAll() {
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate,pprofile FROM product ORDER BY pid DESC";
		List<Product> productlist = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = Product.builder()
						.pid(rs.getInt(1))
						.puserId(rs.getInt(2))
						.ptitle(rs.getString(3))
						.pcategory(rs.getString(4))
						.pplace(rs.getString(5))
						.pcontent(rs.getString(6))
						.preadCount(rs.getInt(7))
						.pcreateDate(rs.getTimestamp(8))
						.pprofile(rs.getString(9))
						.build();
						//rs.getInt("pid")
						/*rs.getInt("pid"),
						rs.getInt("puserId"),
						rs.getString("ptitle"),
						rs.getString("pcategory"),
						rs.getString("pplace"),
						rs.getString("pcontent"),
						rs.getInt("preadcount"),
						rs.getTimestamp("createDate")*/
				
				productlist.add(product);
			}
			
			return productlist;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	//조회수 증가
	public int UpdatereadCount(int pid) {
		final String SQL = "UPDATE product SET readCount = readCount + 1 WHERE pid = ?";
		try {
			conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, pid);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	
	// 상품 등록
	public int register(Product product) {
		final String SQL = "INSERT INTO product(puserid,pid,ptitle,pcategory,pplace,pcontent,pprice,pprofile,pcreateDate) values(?,product_seq.nextval,?,?,?,?,?,?,sysdate)";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, product.getPuserId());
			pstmt.setString(2, product.getPtitle());
			pstmt.setString(3, product.getPcategory());
			pstmt.setString(4, product.getPplace());
			pstmt.setString(5, product.getPcontent());
			pstmt.setInt(6, product.getPprice());
			pstmt.setString(7, product.getPprofile());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
