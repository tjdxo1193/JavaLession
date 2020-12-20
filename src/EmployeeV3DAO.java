import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeV3DAO {

    public static String insertEmployee(EmployeeVO em) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String result = "사원데이터 처리중....?!?";
        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.insertEmployee);
            pstmt.setString(1, em.getFname());
            pstmt.setString(2, em.getLname());
            pstmt.setString(3, em.getEmail());
            pstmt.setString(4, em.getPhone());
            pstmt.setString(5, em.getHdate());
            pstmt.setString(6, em.getJobid());
            pstmt.setInt(7, em.getSal());
            pstmt.setDouble(8, em.getComm());
            pstmt.setInt(9, em.getMgrid());
            pstmt.setInt(10, em.getDeptid());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "사원데이터 저장완료!";
        } catch (SQLException ex) {
            System.out.println("insertSQL문 오류!!");
        }
        EmployeeJDBC.destroyConn(conn, pstmt);
        return result;
    }

    //"empno", "lname", "email", "jobid", "mgrod", ""
    // employee 테이블에서 사원번호, 성, 이메일, 직책, 상사, 부서번호들을
    // 조회해서 ArrayList로 구성한 후 EmployeeV3Service로 넘김
    public static ArrayList<EmployeeVO> selectEmployee() {
        ArrayList<EmployeeVO> eml = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.selectEmployee);
            rs  = pstmt.executeQuery();
            while(rs.next()){
                EmployeeVO em = new EmployeeVO(
                        rs.getInt(1), // empno
                        rs.getString(2), //lname
                        rs.getString(3), //email
                        rs.getString(4), //jobid
                        rs.getInt(5),// mgrid
                        rs.getInt(6)); //deptid
                eml.add(em);
            }
        } catch (SQLException ex) {
            System.out.println("selectEmployee에서 오류발생!!");
            ex.printStackTrace();
        }
        EmployeeJDBC.destroyConn(conn, pstmt);
        return eml;
    }
    // 입력받은 사원번호로 employee 테이블을 조회하고
    // 그 결과를 EmployeeVO로 구성한 후 EMployeeV3Service 로 넘김
    public static EmployeeVO selectOneEmployee(int empno) {
        EmployeeVO em = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.selectOneEmployee);
            pstmt.setInt(1, empno);
            rs  = pstmt.executeQuery();
            if (rs.next()){
                em = new EmployeeVO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getInt(10),
                        rs.getInt(11));
            }
        } catch (SQLException ex) {
            System.out.println("selectEmployee에서 오류발생!!");
            ex.printStackTrace();
        }
        SungJukJDBC.destroyConn(conn,pstmt,rs);
        return em;
    }


    public static String updateEmployee(EmployeeVO em) {
        String result = "사원데이터를 수정하는중....!?!";
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.updateEmployee1);
            pstmt.setString(1, em.getFname());
            pstmt.setString(2, em.getLname());
            pstmt.setString(3, em.getEmail());
            pstmt.setString(4, em.getPhone());
            pstmt.setString(5, em.getHdate());
            pstmt.setInt(6, em.getEmpno());

            int cnt = pstmt.executeUpdate();
            if(cnt > 0) result = "사원데이터 수정완료!!";

        } catch (SQLException ex) {
            System.out.println("사원데이터 수정 오류!!");
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return result;
    }

    public static String deleteEmployee(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원데이터를 삭제하는 중...!?!";

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.deleteEmployee);
            pstmt.setInt(1, empno);
            int cnt = pstmt.executeUpdate();
            if(cnt > 0) result = "사원데이터 삭제 완료!";
        } catch (SQLException ex) {
            System.out.println("사원삭제 오류 발생!!");
        }


        EmployeeJDBC.destroyConn(conn, pstmt);
        return result;
    }
}