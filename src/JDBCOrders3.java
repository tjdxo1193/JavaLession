import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOrders3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from BookOrders";
        String fmt = "%s %s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        //연결
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int orderid = rs.getInt(1);
                int custid = rs.getInt(2);
                int bookid = rs.getInt(3);
                int saleprice = rs.getInt(4);
                String orderdate = rs.getString(5);

                String result = String.format(fmt,
                        orderid, custid, bookid, saleprice, orderdate);
                sb.append(result);
            }
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);
        System.out.println(sb.toString());
    }
}