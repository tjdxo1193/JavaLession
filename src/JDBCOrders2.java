import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders2 {
    public static void main(String[] args) {
        //데이터베이스 관련변수
        String sql = " insert into BookOrders values (?,?,?,?,?) ";

        //도서정보 입력받음
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("주문번호는? ");
        int orderid = Integer.parseInt(sc.nextLine());
        System.out.print("고객 아이디는? ");
        int custid = Integer.parseInt(sc.nextLine());
        System.out.print("도서아이디는? ");
        int bookid = Integer.parseInt(sc.nextLine());
        System.out.print("도서가격은? ");
        int saleprice = Integer.parseInt(sc.nextLine());
        System.out.print("주문날짜는? ");
        String orderdate = sc.nextLine();

        //입력받은 도서 정보를 테이블에 저장
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderid);
            pstmt.setInt(2, custid);
            pstmt.setInt(3, bookid);
            pstmt.setInt(4, saleprice);
            pstmt.setString(5, orderdate);
            //보안문제 해결
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) System.out.println("추가완료");
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destroyConn(conn, pstmt);
    }
}