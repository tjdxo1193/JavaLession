import java.util.ArrayList;
import java.util.Scanner;

public class SamKwangFinalService {


    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("|  비지니스 관리 프로그램 |\n")
                .append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("|  1.   |\n")
                .append("|  2. CODP 조회  |\n")
                .append("|  3. CODP 상세 조회  |\n")
                .append("|  4. SOE  조회      |\n")
                .append("|  5. SOE  상세조회  |\n")
                .append("|  0. 프로 그램 종료  |\n")
                .append("*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*\n")
                .append("원하는 작업[1,2,3,4,5,0]:");
        System.out.print(sb);
    }
    // 고객 : 고객번호, 고객이름
    // 주문 : 주문번호, 주문일
    // 주문항목 : 제품번호, 수량
    // 제품 : 제품이름, 단가
    public void readCODP() {
        String fmt = "%10s %10s %10s %10s\n%10s %10s %10s %10s\n";
        StringBuilder sb = new StringBuilder();
        String result = "";
        ArrayList<SamKwangCODPVO> codps = SamKwangFinalDAO.selectCODP();
        for (SamKwangCODPVO codp : codps){
            result = String.format(fmt, codp.get고객번호(), codp.get고객이름(), codp.get주문번호(),
                    codp.get주문일().substring(0,10), codp.get제품번호(), codp.get수량(), codp.get제품이름(),
                    codp.get단가());
            sb.append(result);
        }
        System.out.println(sb.toString());
    }

    public void readOneCODP() {
        StringBuilder sb = new StringBuilder();
        String fmt = "%10s %10s %10s %10s %10s\n%10s %10s %10s %10s %10s\n%10s %10s %10s %10s %10s %10s\n-------------------------------\n";
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 주문번호는? ");
        int 주문번호 = sc.nextInt();
        ArrayList<SamKwangCODPVO> codps = SamKwangFinalDAO.selectOneCODP(주문번호);

// 고객번호, 고객이름, 주소, 시도, 우편번호, 전화번호,
// 주문번호, 주문일, 납기일, 인사번호, 제품번호, 수량
// 제품이름, 제품분류, 단가, 제고량
        for ( SamKwangCODPVO codp : codps) {
            result = String.format(fmt, codp.get제품번호(),
                    codp.get주문번호(), codp.get고객번호(),
                    codp.get고객이름(), codp.get주소(),
                    codp.get시도(), codp.get우편번호(),
                    codp.get전화번호(), codp.get주문일(),
                    codp.get납기일(), codp.get인사번호(),
                    codp.get수량(), codp.get제품이름(),
                    codp.get제품분류(), codp.get단가(),
                    codp.get재고량());
            sb.append(result);
        }

        System.out.println(sb.toString());
    }

    public void readSOE() {
        String fmt = "%10s %10s %10s %10s %10s %10s\n";
        StringBuilder sb = new StringBuilder();
        String result = "";
        ArrayList<SamKwangSOEVO> soes = SamKwangFinalDAO.selectSOE();
        for (SamKwangSOEVO soe : soes){
            result = String.format(fmt, soe.get인사번호(), soe.get주문번호(), soe.get운송ID(), soe.get운송이름(),
                    soe.get주문일().substring(0,10), soe.get직책());
            sb.append(result);
        }

        System.out.println(sb.toString());
    }

    public void readOneSOE() {
        String fmt = "%10s %10s %10s %10s %10s %10s\n%10s %10s %10s %10s %10s\n";
        String result = "찾으시는 운송ID가 존재하지 않아요!!";

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 운송ID는? ");
        int 운송ID = sc.nextInt();

        SamKwangSOEVO soe = SamKwangFinalDAO.selectOneSOE(운송ID);
        if(result != null){
            result = String.format(fmt, soe.get인사번호(), soe.get주문번호(),
                    soe.get운송ID(), soe.get운송이름(), soe.get담당자전화번호(),
                    soe.get주문일(), soe.get납기일(),
                    soe.get고객번호(), soe.get주민등록번호(),
                    soe.get소속부서(), soe.get직책(),
                    soe.get입사일());
        }
        System.out.println(result);
    }
}