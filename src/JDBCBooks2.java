import java.sql.*;
import java.util.Scanner;

public class JDBCBooks2 {
    // 반면, 동적쿼리문은 불완전한 형태의 문장을 만들어주고
    // 실행전에 매개변수에 실제로 전달할 값을 지정할수 있음
    // 또한 캐쉬기능을 지원하기 때문에 반복적으로 실행하는
    // 문장의 경우 1), 2) 과정을 건너뛰고 3)으로 바로 갈수 있음


    // PreparedStatement의 IN/OUT 매개변수
    // sql 질의문 객체 생성시 사용하는 매개변수는 ?로 표기
    // IN 매개변수는 질의문 생성시 입력값 대용으로 사용
    // OUT 매개변수는 질의문을 실행하고 넘겨주는 결과값을 받을때 사용
    // Java => ?, ?
    // python => %s, %d
    // c# => @name, @passwd
    // oracle => :1, :2

    // JDBC 드라이버 초기화 및 Connection 객체 생성
    public static Connection makeConn() {
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

    public static void main(String[] args) {
       //데이터베이스 관련변수
        String sql = " insert into Books values (?,?,?,?)";

        //도서정보 입력받음
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("도서번호는? ");
        int bookid = Integer.parseInt(sc.nextLine());
        System.out.print("도서제목은? ");
        String bookname = sc.nextLine();
        System.out.print("도서출판사는? ");
        String publisher = sc.nextLine();
        System.out.print("도서가격은? ");
        int price = Integer.parseInt(sc.nextLine());

        //입력받은 도서 정보를 테이블에 저장
        conn = makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookid);
            pstmt.setString(2, bookname);
            pstmt.setString(3, publisher);
            pstmt.setInt(4, price);
            //보안문제 해결
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) System.out.println("추가완료");
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        destroyConn(conn,pstmt);
    }
}