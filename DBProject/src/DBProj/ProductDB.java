package DBProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ProductDB {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/manage_system?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String Pwd = "qhdlvmfpsem1!";
	
	Product_List pList;
	
	public ProductDB() {
		
	}
	
	public ProductDB(Product_List pList){
		this.pList = pList;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, Pwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ProductDBdata getProductDBdata(String id) {
		ProductDBdata pDBdata = new ProductDBdata();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from Product where Product_ID=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				pDBdata.setpID(rs.getString("Product_ID"));
				pDBdata.setpName(rs.getString("Product_Name"));
				pDBdata.setpPrice(rs.getString("Price"));

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return pDBdata;
	}
	
	public Vector getProductList() {
		Vector data = new Vector(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from Product order by Product_Name asc";
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	String ID = rs.getString("Product_ID");
            	String Name = rs.getString("Product_Name");
            	String Price = rs.getString("Price");
            	
            	Vector row = new Vector();
            	row.add(ID);
            	row.add(Name);
            	row.add(Price);
	
            	data.add(row);
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean deleteProduct(String id) {
		boolean OK = false;
		
		Connection conn =null;
	    PreparedStatement ps =null;
	    
	    try {
            conn = getConnection();
            String sql = "delete from Product where Product_ID=?";
           
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int r = ps.executeUpdate(); // 실행 -> 삭제
           
            if (r>0) OK=true; //삭제됨;
           
        } catch (Exception e) {
            System.out.println(e + "-> 오류발생");
        }      
        return OK;
	}
	
	public boolean UpdateProduct(ProductDBdata PDBd) {
		boolean OK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            
            conn = getConnection();           
            String sql = "update Product set Product_Name=?, Price=?"+ "where Product_ID=? ";
           
            ps = conn.prepareStatement(sql);
           
            ps.setString(1, PDBd.getpName());
            ps.setString(2, PDBd.getpPrice());
            ps.setString(3, PDBd.getpID());

           
            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패
           
            if(r>0) OK = true; //수정이 성공되면 ok값을 true로 변경
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return OK;
	}
	
	public boolean insertProduct(ProductDBdata PDBd) {
		boolean OK = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            String sql = "insert into Product(" + "Product_ID, Product_Name, Price) "+  "values(?,?,?);";
           
            ps = conn.prepareStatement(sql);
            ps.setString(1, PDBd.getpID());
            ps.setString(2, PDBd.getpName());
            ps.setString(3, PDBd.getpPrice());
                     
            int r = ps.executeUpdate(); //실행 -> 저장
           
            if(r>0){  
                OK=true;
            }else{
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return OK;
	}

}
