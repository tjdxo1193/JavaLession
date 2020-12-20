import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOrders {
    public static void main(String[] args) {

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

        String sql = " insert into BookOrders values " +
                "(" + orderid + ", " + custid + ", " + bookid + ", "
                + saleprice +", '" +orderdate + "')";

        System.out.println(sql);
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cmhqke6zpvyh.us-east-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
            stmt = conn.createStatement();
            int cnt = stmt.executeUpdate(sql);
            if (cnt > 0) System.out.println("주문정보 추가완료");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버가 없어요!");
        } catch (SQLException ex){
            System.out.println("JDBC 연결 실패!");
        } finally {
            if (stmt != null) try{
              stmt.close();
            } catch (SQLException ex) { }
            if (conn != null) try{
              conn.close();
            } catch (SQLException ex) { }
        }



    }
}
