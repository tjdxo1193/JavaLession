import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SamKwangFinalDAO {
    // CODP 테이블에서 기본정보만 조회한후에 넘김
    public static ArrayList<SamKwangCODPVO> selectCODP() {
        ArrayList<SamKwangCODPVO> codps = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = SamKwangFinalJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangFinalJDBC.selectCODP);
            rs = pstmt.executeQuery();
            while(rs.next()){
                SamKwangCODPVO codp = new SamKwangCODPVO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)
                        );
                codps.add(codp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("selectCODP에서 오류 발생!");
        }

        SamKwangFinalJDBC.destroyConn(conn, pstmt, rs);
        return codps;
    }

    public static ArrayList<SamKwangCODPVO> selectOneCODP(int 주문번호) {
        ArrayList<SamKwangCODPVO> codps = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;


        conn = SamKwangFinalJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangFinalJDBC.selectOneCODP);
            pstmt.setInt(1, 주문번호);
            rs = pstmt.executeQuery();
            while(rs.next()){
                SamKwangCODPVO codp = new SamKwangCODPVO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(15),
                        rs.getInt(16)
                        );
                codps.add(codp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("selectOneCODP에서 오류 발생!");
        }

        SamKwangFinalJDBC.destroyConn(conn, pstmt, rs);
        return codps;
    }

    public static ArrayList<SamKwangSOEVO> selectSOE() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<SamKwangSOEVO> soes = new ArrayList<>();

        conn = SamKwangFinalJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangFinalJDBC.selectSOE);
            rs = pstmt.executeQuery();
            while (rs.next()){
                SamKwangSOEVO soe = new SamKwangSOEVO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                soes.add(soe);
            }
        } catch (SQLException ex) {
            System.out.println("selectSOE에 오류발생");
            ex.printStackTrace();
        }
        return soes;
    }
    // 넘겨준 운송ID를 이용해서 SOE에서 배송정보를 조회하고 결과를 넘겨줌
    public static SamKwangSOEVO selectOneSOE(int 운송ID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SamKwangSOEVO soe = null;

        conn = SamKwangFinalJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangFinalJDBC.selectOneSOE);
            pstmt.setInt(1, 운송ID);
            rs = pstmt.executeQuery();

            if (rs.next()){
                soe = new SamKwangSOEVO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)
                );
            }

        } catch (SQLException ex) {
            System.out.println("selectOneSOE에서 오류발생!!");
            ex.printStackTrace();
        }
        SamKwangFinalJDBC.destroyConn(conn, pstmt, rs);
        return soe;
    }
}