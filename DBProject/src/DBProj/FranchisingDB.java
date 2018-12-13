package DBProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FranchisingDB {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/manage_system?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String Pwd = "qhdlvmfpsem1!";
	
	Franchising_List fList;
	
	public FranchisingDB() {
		
	}
	
	public FranchisingDB(Franchising_List fList) {
		this.fList = fList;
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
	
	public FranchisingDBdata getFranchisingDBdata(String id) {
		FranchisingDBdata fDBdata = new FranchisingDBdata();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from Franchising where Franchising_ID=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				fDBdata.setfID(rs.getString("Franchising_ID"));
				fDBdata.setfName(rs.getString("Franchising_Name"));
				fDBdata.setfLocation(rs.getString("Franchising_Location"));
				fDBdata.setfOffice_Hours(rs.getString("Franchising_Office_Hours"));
				fDBdata.setfNumber(rs.getString("Franchising_Number"));
				fDBdata.setfPerformance(rs.getString("Franchising_Performance"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return fDBdata;
	}
	
	public Vector getFranchisingList() {
		Vector data = new Vector(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from franchising order by Franchising_Name asc";
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	String ID = rs.getString("Franchising_ID");
            	String Name = rs.getString("Franchising_Name");
            	String Location = rs.getString("Franchising_Location");
            	String Office_Hours = rs.getString("Franchising_Office_Hours");
            	String Number = rs.getString("Franchising_Number");
            	String Performance = rs.getString("Franchising_Performance");
            	
            	Vector row = new Vector();
            	row.add(ID);
            	row.add(Name);
            	row.add(Location);
            	row.add(Office_Hours);
            	row.add(Number);
            	row.add(Performance);
            	
            	data.add(row);
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean deleteFranchising(String id) {
		boolean OK = false;
		
		Connection conn =null;
	    PreparedStatement ps =null;
	    
	    try {
            conn = getConnection();
            String sql = "delete from Franchising where Franchising_ID=?";
           
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int r = ps.executeUpdate(); // 실행 -> 삭제
           
            if (r>0) OK=true; //삭제됨;
           
        } catch (Exception e) {
            System.out.println(e + "-> 오류발생");
        }      
        return OK;
	}
	
	public boolean UpdateFranchising(FranchisingDBdata FDBd) {
		boolean OK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            
            conn = getConnection();           
            String sql = "update Franchising set Franchising_Name=?, Franchising_Location=?, Franchising_Office_Hours=?, Franchising_Number=?, Franchising_Performance=?"+ "where Franchising_ID=? ";
           
            ps = conn.prepareStatement(sql);
           
            ps.setString(1, FDBd.getfName());
            ps.setString(2, FDBd.getfLocation());
            ps.setString(3, FDBd.getfOffice_Hours());
            ps.setString(4, FDBd.getfNumber());
            ps.setString(5, FDBd.getfPerformance());
            ps.setString(6, FDBd.getfID());
           
            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패
           
            if(r>0) OK = true; //수정이 성공되면 ok값을 true로 변경
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return OK;
	}
	
	public boolean insertFranchising(FranchisingDBdata FDBd) {
		boolean OK = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            String sql = "insert into Franchising(" + "Franchising_ID, Franchising_Name, Franchising_Location, Franchising_Office_Hours, Franchising_Number, Franchising_Performance) "+  "values(?,?,?,?,?,?);";
           
            ps = conn.prepareStatement(sql);
            ps.setString(1, FDBd.getfID());
            ps.setString(2, FDBd.getfName());
            ps.setString(3, FDBd.getfLocation());
            ps.setString(4, FDBd.getfOffice_Hours());
            ps.setString(5, FDBd.getfNumber());
            ps.setString(6, FDBd.getfPerformance());
                     
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
