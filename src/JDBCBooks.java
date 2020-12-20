import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCBooks {
    public JDBCBooks() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("도서번호는? ");
        int bookid = Integer.parseInt(sc.nextLine());
        System.out.print("도서제목은? ");
        String bookname = sc.nextLine();
        System.out.print("도서출판사는? ");
        String publisher = sc.nextLine();
        System.out.print("도서가격은? ");

        int price = Integer.parseInt(sc.nextLine());
        String sql = "insert into Books values "+
                "(" + bookid + ",'" + bookname + "','" + publisher + "'," + price + ")";
        System.out.println(sql);
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cmhqke6zpvyh.us-east-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("JDBC 드라이버를 확인하세요!!");
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (SQLException ex) {
            System.out.println("디비 접속 주소나 아이디/비번을 확인하세요!");
        }

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            boolean isfail = stmt.execute(sql);
            if (isfail) {
                System.out.println("데이터 추가완료!!");
            }
        } catch (SQLException ex) {
            System.out.println("JDBC - SQL 실행 오류");
        }        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }

    }
}