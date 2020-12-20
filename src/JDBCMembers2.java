import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMembers2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = " insert into BookMembers values (?,?,?,?)";
        Scanner sc = new Scanner(System.in);
        System.out.print("고객 아이디는?");
        int custid = Integer.parseInt(sc.nextLine());
        System.out.print("고객 이름은?");
        String name = sc.nextLine();
        System.out.print("고객 주소는?");
        String address = sc.nextLine();
        System.out.print("고객 전화번호?");
        String phone = sc.nextLine();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, custid);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, phone);
            int cnt = pstmt.executeUpdate();
            if (cnt > 0 ) System.out.println("회원정보 추가 완료");
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destroyConn(conn, pstmt);
    }
}
