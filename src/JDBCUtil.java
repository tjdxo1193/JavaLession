import java.sql.*;

public class JDBCUtil {
    public static Connection makeConn(){
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cmhqke6zpvyh.us-east-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC 드라이버가 없어요!");
        } catch (SQLException ex) {
            System.out.println("JDBC 연결 실패!");
        }
        return conn;
    }

    public static void destroyConn(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null) try{
            pstmt.close();
        } catch (SQLException ex) { }
        if (conn != null) try{
            conn.close();
        } catch (SQLException ex) { }
    }

    public static void destroyConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(rs != null) try {
            rs.close();
        }catch(SQLException ex){}

        destroyConn(conn, pstmt);
    }
}
