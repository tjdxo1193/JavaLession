import java.util.Scanner;

public class SamKwangFinalMain {
    public static void main(String[] args) {
        SamKwangFinalService sk = new SamKwangFinalService();
        Scanner sc = new Scanner(System.in);
        String menu = null;
        while (true) {
            sk.displayMenu();
            menu = sc.nextLine();
            switch (menu) {
                case "1":
                    ;
                    break;
                case "2":
                    sk.readCODP();
                    break;
                case "3":
                    sk.readOneCODP();
                    break;
                case "4":
                    sk.readSOE();
                    break;
                case "5":
                    sk.readOneSOE();
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