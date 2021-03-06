import java.util.Scanner;

/*
작성일 : 2020.12.16

프로그램 설명: 성적처리프로그램 v10
성적처리 프로그램에 저장기능을 추가함
즉, mariadb 데이터베이스에
sungjuk테이블을 생성해서
입력한 성적데이터를 여기에 저장해 둠
 */
public class SungJukV10Main {
    public static void main(String[] args) {
        SungJukV10Service sjsrv =
                new SungJukV10Service();
        Scanner sc = new Scanner(System.in);
        String menu = null;
        while (true) {
            sjsrv.displayMenu();
            menu = sc.nextLine();
            switch (menu) {
                case "1":
                    sjsrv.newSungJuk();
                    break;
                case "2":
                    sjsrv.readSungJuk();
                    break;
                case "3":
                    sjsrv.readOneSungJuk();
                    break;
                case "4":
                    sjsrv.modifySungJuk();
                    break;
                case "5":
                    sjsrv.removeSungJuk();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }

    }
}
