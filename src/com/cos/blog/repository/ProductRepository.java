package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.dto.BoardResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.Buy;
import com.cos.blog.model.Product;
import com.cos.blog.model.Users;


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
	
	public int deleteById(int pid) {
		final String SQL = "DELETE FROM product WHERE pid = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, pid);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteById : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
	public int save(Buy buy, int pid) {
		final String SQL = "INSERT INTO buy(id,userid, productid, buyaddress, buyrequest, buyprice, buypayment) VALUES(buy_SEQ.nextval, ?,?,?,?,?,?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, buy.getUserid());
			pstmt.setInt(2, buy.getProductid());
			pstmt.setString(3, buy.getBuyaddress());
			pstmt.setString(4, buy.getBuyrequest());
			pstmt.setInt(5, buy.getBuyprice());
			pstmt.setString(5, buy.getBuypayment());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int count(String keyword) {
		final String SQL = "SELECT count(*) FROM product WHERE ptitle LIKE ? OR pcontent LIKE ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"count(keyword) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return -1;
	}
	
	public Product findById(int pid) {
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate,pprofile,pprice FROM product WHERE PID = ?";
		
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
						.pprice(rs.getInt(10))
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
				
				return product;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public List<Product> findAll(String keyword) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT pid, ");
		//sb.append("SELECT /*+ INDEX_DESC(product SYS_C007969)*/pid,");
		sb.append("puserId, ptitle, pcontent, preadCount, pcreateDate, pcategory, pplace, pprice, pprofile ");
		sb.append("FROM product ");
		sb.append("WHERE ptitle like ? OR pcontent like ? or pprofile like ?");
		
		//System.out.println(sb.toString());
		final String SQL = sb.toString();
		List<Product> productlist = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setString(3, "%"+keyword+"%");
			
			// while 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = Product.builder()
						.pid(rs.getInt(1))
						.puserId(rs.getInt(2))
						.ptitle(rs.getString(3))
						.pcontent(rs.getString(4))
						.preadCount(rs.getInt(5))
						.pcreateDate(rs.getTimestamp(6))
						.pcategory(rs.getString(7))
						.pplace(rs.getString(8))
						.pprice(rs.getInt(9))
						.pprofile(rs.getString(10))
						.build();
				productlist.add(product);
			}
			
			return productlist;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll(keyword) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	public int updateReadCount(int pid) {
		final String SQL = "UPDATE product SET preadCount = preadCount + 1 WHERE pid = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기

			pstmt.setInt(1, pid);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"updateReadCount : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}

		return -1;
	}
	
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
		final String SQL = "UPDATE product SET ptitle = ?, pcontent = ?,pcategory = ?, pplace = ?, pprice = ?, pprofile = ? WHERE pid = ?";
		
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
	
	/*public ProductDetailResponseDto findById(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.id, p.userId, p.title, p.content, p.readCount, p.createDate, u.username ");
		sb.append("FROM product p INNER JOIN users u ");
		sb.append("ON p.userId = u.id ");
		sb.append("WHERE p.id = ?");
		final String SQL = sb.toString();
		ProductDetailResponseDto productDto = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기 
			pstmt.setInt(1, id);
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productDto = new ProductDetailResponseDto();
				Product product = Product.builder()
						.pid(rs.getInt(1))
						.puserId(rs.getInt(2))
						.ptitle(rs.getString(3))
						.pcategory(rs.getString(4))
						.pplace(rs.getString(5))
						.pcontent(rs.getString(6))
						.preadCount(rs.getInt(7))
						.pcreateDate(rs.getTimestamp(8))
						.pprice(rs.getInt(9))
						.pprofile(rs.getString(10))
						.build();
				productDto.setProduct(product);
				productDto.setUsername(rs.getString(11));
				
			}
			return productDto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findById : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}*/
	
	public List<Product> findAll(int pid) {
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate,pprofile,pprice FROM product WHERE PID = ? ORDER BY pid DESC";
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
						.pprice(rs.getInt(10))
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
	
	public List<Product> likeAll() {
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate,pprofile,pprice FROM product ORDER BY pid DESC";
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
						.pprice(rs.getInt(10))
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
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate,pprofile,pprice FROM product ORDER BY pid DESC";
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
						.pprice(rs.getInt(10))
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
