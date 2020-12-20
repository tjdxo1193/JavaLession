import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMembers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("고객 아이디는?");
        int custid = Integer.parseInt(sc.nextLine());
        System.out.print("고객 이름은?");
        String name = sc.nextLine();
        System.out.print("고객 주소는?");
        String address = sc.nextLine();
        System.out.print("고객 전화번호?");
        String phone = sc.nextLine();

        String sql = " insert into BookMembers values "+
                "(" + custid + ",'" + name + "','" + address + "','" + phone + "')";
        System.out.println(sql);

        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cmhqke6zpvyh.us-east-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
            stmt = conn.createStatement();
            int cnt = stmt.executeUpdate(sql);
            if(cnt > 0)
                System.out.println("데이터 추가완료!");
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC 드라이버를 확인하세요");
        } catch (SQLException ex) {
            System.out.println("JDBC 연결 실패!");
        }finally {
            if (stmt != null) { try {
                    stmt.close();
                } catch (SQLException ex) { }
            }
            if (conn != null) { try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
}
