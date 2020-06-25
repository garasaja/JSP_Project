package second.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import second.db.DBConn;
import second.dto.ProductResponseDto;
import second.model.Product;

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
	
	public int update(Product product) {
		final String SQL = "UPDATE product SET ptitle = ?, pcontent = ?,pcategory = ?, pplace = ?, pprice = ?  WHERE pid = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, product.getPtitle());
			pstmt.setString(2, product.getPcontent());
			pstmt.setString(3, product.getPcategory());
			pstmt.setString(4, product.getPplace());
			pstmt.setInt(5, product.getPprice());
			pstmt.setInt(6, product.getPid());
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
	
	public List<Product> findAll() {
		final String SQL = "SELECT pid,puserid,ptitle,pcategory,pplace,pcontent,preadcount,pcreateDate FROM product ORDER BY pid DESC";
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
		final String SQL = "INSERT INTO product(puserid,ptitle,pcategory,pplace,pcontent,pcreatedate) values(product_seq.nextval,?,?,?,?,sysdate)";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, product.getPtitle());
			pstmt.setString(2, product.getPcategory());
			pstmt.setString(3, product.getPplace());
			pstmt.setString(4, product.getPcontent());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
