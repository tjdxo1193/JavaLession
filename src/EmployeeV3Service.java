import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeV3Service {
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("|  인사관리 프로그램v3 |\n")
                .append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("|  1. 인사 정보 입력  |\n")
                .append("|  2. 인사 정보 조회  |\n")
                .append("|  3. 정보 상세 조회  |\n")
                .append("|  4. 인사 정보 수정  |\n")
                .append("|  5. 인사 정보 삭제  |\n")
                .append("|  0. 프로 그램 종료  |\n")
                .append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("원하는 작업[1,2,3,4,5,0]:");
        System.out.print(sb);
    }

    public void newEmployee() {
        int empno;
        String fname;
        String lname;
        String email;
        String phone;
        String hdate;
        String jobid;
        int sal;
        double comm;
        int mgrid;
        int deptid;

        Scanner sc = new Scanner(System.in);
        System.out.print("직원 이름을 입력하시오 :" );
        fname = sc.nextLine();
        System.out.print("직원 성을 입력하시오 :" );
        lname = sc.nextLine();
        System.out.print("이메일을 입력하시오 :" );
        email = sc.nextLine();
        System.out.print("전화번호를 입력하시오 :" );
        phone = sc.nextLine();
        System.out.print("입사 날짜를 입력하시오 :" );
        hdate = sc.nextLine();
        System.out.print("직책을 입력하시오 :" );
        jobid = sc.nextLine();
        System.out.print("연봉을 입력하시오 :" );
        sal = sc.nextInt();
        System.out.print("커미션을 입력하시오 :" );
        comm = sc.nextDouble();
        System.out.print("상사번호를 입력하시오 :" );
        mgrid = sc.nextInt();
        System.out.print("부서번호를 입력하시오 :" );
        deptid = sc.nextInt();
        EmployeeVO em = new EmployeeVO(
                fname, lname, email, phone, hdate, jobid, sal, comm, mgrid, deptid);

        //처리된 인사데이터를 동적배열에 저장
        //  최종적으로 처리한 성적데이터를 employ테이블에 저장하기 위해
        // EmployeeV3DAO의 insertEmployee메서드를 호출하고
        // 매개변수로 성적데이터를 넘김
        String result = EmployeeV3DAO.insertEmployee(em);
        System.out.println(result);
    }

    public void readEmployee() {
        StringBuilder sb = new StringBuilder();
        String fmt = "%10s %10s %10s %10s %10s %10s\n";

        String result = String.format(fmt,
                "empno","lname","email","jobid","mgrid","deptid"); // 제목출력
        sb.append(result);

        ArrayList<EmployeeVO> emps = EmployeeV3DAO.selectEmployee();

        for (EmployeeVO emp : emps) {
            result = String.format(fmt, emp.getEmpno(),emp.getLname(),emp.getEmail(),
                    emp.getJobid(), emp.getMgrid(), emp.getDeptid());
            sb.append(result);
        }

        System.out.println(sb.toString());
    }

    public void readOneEmployee() {
        String fmt = "직원 번호: %10s ,직원 이름: %10s ,직원 성: %10s ,이메일: %10s ,\n전화번호: %10s ,입사 날짜: %10s ," +
                "직책: %10s ,연봉: %10s \n, 커미션: %.2f ,상사 번호: %10s ,부서 번호: %10s \n";

        //상세조회할 사원번호 입력 받음
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번 : ");
        int empno = sc.nextInt();

        EmployeeVO em = EmployeeV3DAO.selectOneEmployee(empno);

        String result = String.format(fmt, em.getEmpno(), em.getFname(), em.getLname(),
                em.getEmail(), em.getPhone(), em.getHdate(), em.getJobid(), em.getSal(), em.getComm(),
                em.getMgrid(), em.getDeptid());

        System.out.println(result);
    }

    public void modifyEmployee() {
        Scanner sc = new Scanner(System.in);
        EmployeeVO em = new EmployeeVO();

        System.out.println("수정할 사원번호는? ");
        em.setEmpno(Integer.parseInt(sc.nextLine()));
        System.out.print("사원정보1를 수정할경우 1을, 사원정보2를 수정할 경우 2를 입력: ");
        int set = Integer.parseInt(sc.nextLine());
        if(set == 1) {
            System.out.println("수정할 성은? ");
            em.setFname(sc.nextLine());
            System.out.println("수정할 이름은? ");
            em.setLname(sc.nextLine());
            System.out.println("수정할 이메일은? ");
            em.setEmail(sc.nextLine());
            System.out.println("수정할 핸드폰은?");
            em.setPhone(sc.nextLine());
            System.out.println("수정할 입사일은?");
            em.setHdate(sc.nextLine());
        }else if(set == 2){
            System.out.println("수정할 직책은? ");
            em.setJobid(sc.nextLine());
            System.out.println("수정할 연봉은? ");
            em.setSal(sc.nextInt());
            System.out.println("수정할 커미션은? ");
            em.setComm(sc.nextInt());
            System.out.println("수정할 상사번호은?");
            em.setMgrid(sc.nextInt());
            System.out.println("수정할 부서번호는?");
            em.setDeptid(sc.nextInt());
        }else {
            System.out.println("잘 못누르셨습니다.");
            return;
        }

        String result = EmployeeV3DAO.updateEmployee(em);
        System.out.println(result);
    }

    public void removeEmployee() {

        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 사원번호는? ");
        int empno = sc.nextInt();

        String result = EmployeeV3DAO.deleteEmployee(empno);
        System.out.println(result);

    }
}
