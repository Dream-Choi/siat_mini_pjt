import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class JdbcDao {
    // JDBC Driver, Connection, Statement, PreparedStatement, ResultSet
    // 1. JDBC Driver Loading
    // 2. Connection
    // 3. Statement, PreparedStatement(SQL)
    // 4. ResultSet executeQuery - select, int executeUpdate - insert, update, delete
    // 5. ResultSet Handling
    // 6. Connection close

    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER= "hr";
    public static final String PASSWORD ="hr";

    public JdbcDao() {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver Loading Success");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Loading Failed");
            e.printStackTrace();
        }
    }
    public int insertRow(TodoRequestDTO request){
        System.out.println("-------dao insertRow");
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String insertSQL= "INSERT INTO JDBC_TODO_TBL(SEQ, TITLE, CONTENT, STATUS, PRIORITY) VALUES (JDBC_SEQ.NEXTVAL,?, ?, ?, ?)";
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, request.getTitle());
            pstmt.setString(2, request.getContent());
            pstmt.setString(3, String.valueOf(request.getStatus()));
            pstmt.setInt(4, request.getPriority());
            flag = pstmt.executeUpdate();
            System.out.println("insertRow Success");
        } catch (SQLException e) {
            System.out.println("insertRow Failed");
            e.printStackTrace();
        } catch (Exception e) {
            
        } finally {
             try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return flag;
    }
    public int updateRow(Map<String, Object> map) {
        System.out.println("-------dao updateRow");
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String updateSQL = "UPDATE JDBC_TODO_TBL SET TITLE=?, CONTENT=?, STATUS=?, PRIORITY=? WHERE SEQ=?";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, (String) map.get("title")); // Map에서 title 가져오기
            pstmt.setString(2, (String) map.get("content")); // Map에서 content 가져오기
            pstmt.setString(3, (String) map.get("status")); // Map에서 status 가져오기
            pstmt.setInt(4, (int) map.get("priority")); // Map에서 priority 가져오기
            pstmt.setInt(5, (int) map.get("seq")); // Map에서 seq 가져오기
            flag = pstmt.executeUpdate();
            System.out.println("updateRow Success");
        } catch (SQLException e) {
            System.out.println("updateRow Failed");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
    public int deleteRow(int seq) {
        System.out.println("-------dao deleteRow");
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String deleteSQL= "DELETE FROM JDBC_TODO_TBL WHERE SEQ=?";
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, seq);
            flag = pstmt.executeUpdate();
            System.out.println("deleteRow Success");
        } catch (SQLException e) {
            System.out.println("deleteRow Failed");
            e.printStackTrace();
        } catch (Exception e) {
            
        } finally {
             try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return flag;
    }
    public List<TodoResponseDTO> selectListRow() {
        System.out.println("-------dao selectRow");
        List<TodoResponseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String selectSQL= "SELECT SEQ, TITLE, CONTENT, TO_CHAR(STARTDATE,'YY\"년\" MM\"월\" DD\"일\"'), STATUS, ENDDATE, PRIORITY FROM JDBC_TODO_TBL";
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectSQL);
            rset = pstmt.executeQuery();
            while(rset.next()){
                TodoResponseDTO response = TodoResponseDTO.builder()
                        .seq(rset.getInt("SEQ"))
                        .title(rset.getString("TITLE"))
                        .content(rset.getString("CONTENT"))
                        .startDate(rset.getString("STARTDATE"))
                        .status(rset.getString("STATUS"))
                        .endDate(rset.getString("ENDDATE"))
                        .priority(rset.getInt("PRIORITY"))
                        .build();
                list.add(response);
            }
            System.out.println("selectRow Success");
        } catch (SQLException e) {
            System.out.println("selectRow Failed");
            e.printStackTrace();
        } catch (Exception e) {
            
        } finally {
             try {
            if (rset != null) rset.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return list;
    }
    public Optional<TodoResponseDTO> selectRow(int seq){
        System.out.println("-------dao selectDao");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String selectSQL= "SELECT * FROM JDBC_TODO_TBL WHERE SEQ=?";
        Optional<TodoResponseDTO> response=Optional.empty();
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, seq);
            rset = pstmt.executeQuery();
            if(rset.next()){
                response=Optional.of(TodoResponseDTO.builder()
                        .seq(rset.getInt("SEQ"))
                        .title(rset.getString("TITLE"))
                        .content(rset.getString("CONTENT"))
                        .startDate(rset.getString("STARTDATE"))
                        .status(rset.getString("STATUS"))
                        .endDate(rset.getString("ENDDATE"))
                        .priority(rset.getInt("PRIORITY"))
                        .build());
            }
            System.out.println("selectRow Success");
        } catch (SQLException e) {
            System.out.println("selectRow Failed");
            e.printStackTrace();
        } catch (Exception e) {
            
        } finally {
             try {
            if (rset != null) rset.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return response;
    }
}