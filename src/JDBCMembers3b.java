import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMembers3b {
    public static void main(String[] args) {
        // Books테이블의 저장된 모든 내용을 출력함
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from BookMembers where name = ?";
        String fmt = "%s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("회원이름은 ? ");
        String cname = sc.nextLine();
        //연결
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,cname);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String custid = rs.getString(1);
                String name = rs.getString(2);
                String adress = rs.getString(3);
                String phone = rs.getString(4);
                String result = String.format(fmt,
                        custid, name, adress, phone);
                sb.append(result);
            }
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }

        //종료
        JDBCUtil.destroyConn(conn, pstmt, rs);
        // 결과출력
        System.out.println(sb.toString());
    }
}