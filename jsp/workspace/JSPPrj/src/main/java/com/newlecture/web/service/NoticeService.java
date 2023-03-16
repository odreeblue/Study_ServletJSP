package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	public int removeNoticeAll(int[] ids) {
		return 0;
	}
	public int pubNoticeAll(int[] oids,int[] cids) {
		
		List<String> oidsList = new ArrayList<>();
		for(int i=0; i<oids.length;i++) {
			oidsList.add(String.valueOf(oids[i]));
		}
		
		List<String> cidsList = new ArrayList<>();
		for(int i=0; i<cids.length;i++) {
			cidsList.add(String.valueOf(cids[i]));
		}
		
		return pubNoticeAll(oidsList,cidsList);
	}
	public int pubNoticeAll(List<String> oids,List<String> cids) {
		String oidsCSV = String.join(",", oids);
		String cidsCSV = String.join(",", cids);;
		return pubNoticeAll(oidsCSV,cidsCSV);
	}
	// "20,30,43,56.."
	public int pubNoticeAll(String oidsCSV,String cidsCSV) {
		
		int result = 0;
		String sqlOpen = String.format("UPDATE NOTICE SET PUB=\"true\" WHERE ID IN (%s)",oidsCSV);
	
		String sqlClose = String.format("UPDATE NOTICE SET PUB=\"false\" WHERE ID IN (%s)",cidsCSV);
		
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			Statement stOpen = con.createStatement();
			result += stOpen.executeUpdate(sqlOpen);
			
			Statement stClose = con.createStatement();
			result += stClose.executeUpdate(sqlClose);
			
			stOpen.close();
			stClose.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int insertNotice(Notice notice) {
		int result = 0;
		
		String sql = "INSERT INTO NOTICE(TITLE,CONTENT,WRITER_ID,PUB,FILES) VALUES(?,?,?,?,?)";
		
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setString(4, notice.getPub());
			st.setString(5, notice.getFiles());

			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteNotice(int id) {
		return 0;
	}
	public int updateNotice(Notice notice) {
		return 0;
	}
	public List<Notice> getNoticeNewestList(){
		return null;
	}
	
	
	public List<Notice> getNoticeList(){
		
		return getNoticeList("title","",1);
	}
	public List<Notice> getNoticeList(int page){
		
		return getNoticeList("title","",page);
	}
	public List<Notice> getNoticeList(String field/*TITLE, WRITER_ID*/,String query/*A*/,int page){
		
		
		List<Notice> list = new ArrayList<>();
		
		String sql = "SELECT * FROM( "
				+ " SELECT @ROWNUM:=@ROWNUM+1 AS rowNUM, N.* "
				+ " FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ?) N,(SELECT @ROWNUM:=0) R ORDER BY REGDATE DESC) T"
				+ " LIMIT ?,?;";
		//1,11,21,31 -> an=1+(page-1)*10
		//10,20,30,40 -> page*10
		
		//String url="jdbc:oracle:thin:@localhost:1521/xepdb1"; // Oracle
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		//String sql="SELECT * FROM NOTICE";
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, (page-1)*10);
			st.setInt(3, page*10-1);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				Notice notice = new Notice(id,title,writerId,regdate,hit,files,content,pub);
				list.add(notice);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Notice> getNoticePubList(String field, String query, int page) {
List<Notice> list = new ArrayList<>();
		
		String sql = "SELECT * FROM( "
				+ " SELECT @ROWNUM:=@ROWNUM+1 AS rowNUM, N.* "
				+ " FROM (SELECT * FROM NOTICE WHERE PUB=\"true\" AND "+field+" LIKE ?) N,(SELECT @ROWNUM:=0) R ORDER BY REGDATE DESC) T"
				+ " LIMIT ?,?;";
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, (page-1)*10);
			st.setInt(3, page*10-1);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				Notice notice = new Notice(id,title,writerId,regdate,hit,files,content,pub);
				list.add(notice);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	public int getNoticeCount(String field,String query) {
		int count =0;

		String sql = "SELECT COUNT(ID) COUNT"
				+ " FROM(SELECT * FROM NOTICE WHERE "+field+" LIKE ?) N";
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");	
			}
			

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Notice getNotice(int id) {
		
		Notice notice=null;
		
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				notice = new Notice(nid,title,writerId,regdate,hit,files,content,pub);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notice;
	}
	
	
	public Notice getNextNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE"
				+ " WHERE ID = ("
				+ "	SELECT ID FROM NOTICE WHERE REGDATE >(SELECT REGDATE FROM NOTICE WHERE ID=?) LIMIT 1)";
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				notice = new Notice(nid,title,writerId,regdate,hit,files,content,pub);
				
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE "
				+ " WHERE ID = ("
				+ "	SELECT ID FROM NOTICE WHERE REGDATE <(SELECT REGDATE FROM NOTICE WHERE ID=?) ORDER BY ID DESC LIMIT 1"
				+ " )";
		
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				notice = new Notice(nid,title,writerId,regdate,hit,files,content,pub);	
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	public int deleteNoticeAll(int[] ids) {
		int result = 0;
		String params = "";
		for(int i=0; i<ids.length; i++) {
			params+=ids[i];
			if (i < ids.length-1) {
				params +=",";
			}
		}
		String sql = "DELETE FROM NOTICE WHERE ID IN ("+params+")";
		
		String url = "jdbc:mariadb://152.67.208.143:3306/test"; // Mariadb
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");
			Statement st = con.createStatement();
			

			result = st.executeUpdate(sql);
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	
	

}
