import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCBooks3c {
    public static void main(String[] args) {
        // 도서제목으로 도서정보 조회
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "Select * from Books where bookname like ?";
        String fmt = "%s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        // 조회할 도서제목을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("도서제목은? ");
        String name = sc.nextLine();

        //
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,'%'+name+'%');
            rs = pstmt.executeQuery();
            while(rs.next()){
                String bookid = rs.getString(1);
                String bookname = rs.getString(2);
                String publisher = rs.getString(3);
                int price = rs.getInt(4);
                String result = String.format(fmt, bookid, bookname,
                        publisher,price);
                sb.append(result);
            }
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 오류!");
        }
        JDBCUtil.destroyConn(conn,pstmt,rs);
        System.out.println(sb.toString());
    }
}