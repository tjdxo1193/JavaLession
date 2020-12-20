public class SamKwangFinalJDBC extends JDBCUtil{
    public static String insertSamKwangFinal =
            "insert into SamKwangFinal ()"+
                    "values ();";
    public static String selectSamKwangFinal =
            " select  " +
                    "from SamKwangFinal ";
    public static String updateSamKwangFinal =
            "update SamKwangFinal " +
                    "set  = ?,  = ?,  = ?,  = ?,  = ? "+
                    "where  = ?";

    public static String deleteSamKwangFinal =
            "delete from SamKwangFinal where  = ?";
    public static String selectOneCODP =
            " select * from CODP where 주문번호 = ?";
    public static String selectCODP =
            " select 고객번호, 고객이름, 주문번호, 주문일, 제품번호, 수량, 제품이름, 단가" +
                    " from CODP order by 주문번호 desc";

    public static String selectSOE =
            "select 인사번호, 주문번호, 운송ID, 운송이름, 주문일, 직책 " +
                    " from SOE order by 운송ID desc";
    public static String selectOneSOE =
            "select * from SOE where 운송ID = ?";
}