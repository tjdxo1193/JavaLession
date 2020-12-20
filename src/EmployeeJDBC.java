public class EmployeeJDBC extends JDBCUtil{
    public static String insertEmployee =
            "insert into employee (fname, lname, email, phone, hdate, jobid, sal, comm, mgrid, deptid)"+
                    "values (?,?,?,?,?,?,?,?,?,?);";
    public static String selectEmployee =
            " select empno, lname, email, jobid, mgrid, deptid " +
                    "from employee ";
    public static String updateEmployee1 =
            "update employee " +
            "set fname = ?, lname = ?, email = ?, phone = ?, hdate = ? "+
            "where empno = ?";

    public static String updateEmployee2 =
            "update employee " +
                    "set jobid = ?, sal = ?, comm = ?, mgrid = ?, deptid = ? "+
                    "where empno = ?";

    public static String deleteEmployee =
            "delete from employee where empno = ?";
    public static String selectOneEmployee =
            " select * from employee where empno = ? ";
}
