import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukV10Service {
    public SungJukV10Service() {
    }
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("|  성적 처리프로그램 v9    |\n")
                .append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("| 1. 성적 데이터 직접입력  |\n")
                .append("| 2. 성적 데이터 간단조회  |\n")
                .append("| 3. 성적 데이터 상세조회  |\n")
                .append("| 4. 성적 데이터 수정하기  |\n")
                .append("| 5. 성적 데이터 삭제하기  |\n")
                .append("| 0. 성적 프로그램 종료함  |\n")
                .append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("원하는 작업[1,2,3,4,5,0]:");
        System.out.print(sb);
    }
    public void newSungJuk() {
        String name;
        int kor, eng, mat;
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        name = sc.nextLine();
        System.out.print("국어을 입력하세요: ");
        kor = sc.nextInt();
        System.out.print("영어을 입력하세요: ");
        eng = sc.nextInt();
        System.out.print("수학을 입력하세요: ");
        mat = sc.nextInt();

        SungJukVO sj = new SungJukVO(name, kor, eng, mat, 0, 0, '가');

        computeSungJuk(sj);
        //  최종적으로 처리한 성적데이터를 sungjuk테이블에 저장하기 위해
        // SungjukV10DAO의 inserSungJuk메서드를 호출하고
        // 매개변수로 성적데이터를 넘김
        String result = SungJukV10DAO.insertSungJuk(sj);
        System.out.println(result);
    }


    public void computeSungJuk(SungJukVO sj) {
        sj.setSum(sj.getKor() + sj.getEng() + sj.getMat());
        sj.setMean(sj.getSum() / 3.0);
        switch ((int) (sj.getMean() / 10)) {
            case 10:
            case 9:
                sj.setGrd('수');
                break;
            case 8:
                sj.setGrd('우');
                break;
            case 7:
                sj.setGrd('미');
                break;
            case 6:
                sj.setGrd('양');
                break;
            default:
                sj.setGrd('가');
        }
    }

    //조회할 성적데이터를 DAO로부터 넘겨받아 출력
    public void readSungJuk(){
        String fmt = "번호:%s, 이름:%s, 국어:%s, 영어:%s, 수학:%s, 등록일:%s\n";
        StringBuilder sb = new StringBuilder();

        ArrayList<SungJukVO> sjs = SungJukV10DAO.selectSungJuk();

        for(SungJukVO sj : sjs){
            String result = String.format( fmt, sj.getSjno(),
                    sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(), sj.getRegdate().substring(0,10) );
            sb.append(result);
        }

        System.out.println(sb.toString());
    }

    public void readOneSungJuk() {
        String fmt = "번호: %s, 이름:%s, 국어:%d, 영어:%d, 수학:%d\n" +
                "총점:%d, 평균:%.1f, 학점:%s, 등록일:%s\n";

        //상세조회할 학생이름 입력 받음
        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 성적번호는? : ");
        String sjno = sc.nextLine();

        SungJukVO sj = SungJukV10DAO.selectOneSungJuk(sjno);

        String result = String.format(fmt, sj.getSjno(),
                sj.getName(), sj.getKor(),
                sj.getEng(), sj.getMat(), sj.getSum(), sj.getMean(), sj.getGrd(), sj.getRegdate());
        System.out.println(result);
    }

    public void modifySungJuk() {
        Scanner sc = new Scanner(System.in);
        SungJukVO sj = new SungJukVO();

        System.out.println("수정할 성적번호는? ");
        sj.setSjno(sc.nextInt());
        System.out.println("수정할 국어점수는? ");
        sj.setKor(sc.nextInt());
        System.out.println("수정할 영어점수는? ");
        sj.setEng(sc.nextInt());
        System.out.println("수정할 수학점수는?");
        sj.setMat(sc.nextInt());

        computeSungJuk(sj);

        String result = SungJukV10DAO.updateSungJuk(sj);
        System.out.println(result);
    }

    public void removeSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 성적번호는? ");
        int sjno = sc.nextInt();

        String result = SungJukV10DAO.deleteSungJuk(sjno);
        System.out.println(result);
    }
}