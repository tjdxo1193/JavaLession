import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders3b {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "Select * from BookOrders where orderid = ?";
        String fmt = "%s %s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        //조회할 항목을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("주문번호는? ");
        int orid = sc.nextInt();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,orid);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int orderid = rs.getInt(1);
                int custid = rs.getInt(2);
                int bookid = rs.getInt(3);
                int saleprice = rs.getInt(4);
                String orderdate = rs.getString(5);
                String result = String.format(fmt,
                        orderid, custid, bookid,saleprice, orderdate);
                sb.append(result);
            }
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류!");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);
        System.out.println(sb.toString());
    }
}