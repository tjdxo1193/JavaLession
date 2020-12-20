public class SamKwangCODPVO {
    private int 고객번호;
    private String 고객이름;
    private String 주소;
    private String 시도;
    private String 우편번호;
    private String 전화번호;
    private int 주문번호;
    private String 주문일;
    private String 납기일;
    private int 인사번호;


    private int 제품번호;
    private int 수량;

    private String 제품이름;
    private String 제품분류;
    private int 단가;
    private int 재고량;

    public SamKwangCODPVO() {
    }

    public SamKwangCODPVO(int 고객번호, String 고객이름, int 주문번호, String 주문일, int 제품번호, int 수량, String 제품이름, int 단가) {
        this.고객번호 = 고객번호;
        this.고객이름 = 고객이름;
        this.주문번호 = 주문번호;
        this.주문일 = 주문일;
        this.제품번호 = 제품번호;
        this.수량 = 수량;
        this.제품이름 = 제품이름;
        this.단가 = 단가;
    }

    public SamKwangCODPVO(int 제품번호, int 주문번호, int 고객번호, String 고객이름, String 주소, String 시도, String 우편번호, String 전화번호, String 주문일, String 납기일, int 인사번호, int 수량, String 제품이름, String 제품분류, int 단가, int 재고량) {
        this(고객번호, 고객이름, 주문번호, 주문일, 제품번호, 수량, 제품이름, 단가);
        // 이미 정의된 생성자중 유사한 매개변수 순서와 유형이 동일한 생성자 호출

        this.주소 = 주소;
        this.시도 = 시도;
        this.우편번호 = 우편번호;
        this.전화번호 = 전화번호;
        this.납기일 = 납기일;
        this.인사번호 = 인사번호;
        this.제품분류 = 제품분류;
        this.재고량 = 재고량;
    }

    public int get고객번호() {
        return 고객번호;
    }

    public void set고객번호(int 고객번호) {
        this.고객번호 = 고객번호;
    }

    public String get고객이름() {
        return 고객이름;
    }

    public void set고객이름(String 고객이름) {
        this.고객이름 = 고객이름;
    }

    public String get주소() {
        return 주소;
    }

    public void set주소(String 주소) {
        this.주소 = 주소;
    }

    public String get시도() {
        return 시도;
    }

    public void set시도(String 시도) {
        this.시도 = 시도;
    }

    public String get우편번호() {
        return 우편번호;
    }

    public void set우편번호(String 우편번호) {
        this.우편번호 = 우편번호;
    }

    public String get전화번호() {
        return 전화번호;
    }

    public void set전화번호(String 전화번호) {
        this.전화번호 = 전화번호;
    }

    public int get주문번호() {
        return 주문번호;
    }

    public void set주문번호(int 주문번호) {
        this.주문번호 = 주문번호;
    }

    public String get주문일() {
        return 주문일;
    }

    public void set주문일(String 주문일) {
        this.주문일 = 주문일;
    }

    public String get납기일() {
        return 납기일;
    }

    public void set납기일(String 납기일) {
        this.납기일 = 납기일;
    }

    public int get인사번호() {
        return 인사번호;
    }

    public void set인사번호(int 인사번호) {
        this.인사번호 = 인사번호;
    }

    public int get제품번호() {
        return 제품번호;
    }

    public void set제품번호(int 제품번호) {
        this.제품번호 = 제품번호;
    }

    public int get수량() {
        return 수량;
    }

    public void set수량(int 수량) {
        this.수량 = 수량;
    }

    public String get제품이름() {
        return 제품이름;
    }

    public void set제품이름(String 제품이름) {
        this.제품이름 = 제품이름;
    }

    public String get제품분류() {
        return 제품분류;
    }

    public void set제품분류(String 제품분류) {
        this.제품분류 = 제품분류;
    }

    public int get단가() {
        return 단가;
    }

    public void set단가(int 단가) {
        this.단가 = 단가;
    }

    public int get재고량() {
        return 재고량;
    }

    public void set재고량(int 재고량) {
        this.재고량 = 재고량;
    }
}