public class SungJukJDBC extends JDBCUtil{

    public static String insertSungJuk =
            "insert into sungjuk (name, kor, eng, mat, tot, mean, grd)"+
            "values (?,?,?,?,?,?,?);";
    public static String selectSungJuk =
            "select sjno, name, kor, eng, mat, regdate from sungjuk order by sjno desc";
    public static String updateSungJuk =
            "update sungjuk " +
                    "set kor = ?, eng = ?, mat = ?, tot = ?, mean = ?, grd = ?, regdate = ? where sjno = ? ";
    public static String deleteSungJuk =
            "delete from sungjuk where sjno = ?";
    public static String selectOneQuery = "select * from sungjuk where sjno = ?";

}
