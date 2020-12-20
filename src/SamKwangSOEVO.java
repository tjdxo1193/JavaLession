public class SamKwangSOEVO{

    private int 인사번호;
    private int 주문번호;
    private int 운송ID;
    private String 운송이름;
    private String 담당자전화번호;
    private String 주문일;
    private String 납기일;
    private int 고객번호;
    private String 주민등록번호;
    private String 성명;
    private String 소속부서;
    private String 직책;
    private String 입사일;

    public SamKwangSOEVO() { }

    public SamKwangSOEVO(int 인사번호, int 주문번호, int 운송ID, String 운송이름, String 담당자전화번호, String 주문일, String 납기일, int 고객번호, String 주민등록번호, String 성명, String 소속부서, String 직책, String 입사일) {
        this(인사번호, 주문번호, 운송ID, 운송이름, 주문일, 직책);
        this.담당자전화번호 = 담당자전화번호;
        this.납기일 = 납기일;
        this.고객번호 = 고객번호;
        this.주민등록번호 = 주민등록번호;
        this.성명 = 성명;
        this.소속부서 = 소속부서;
        this.입사일 = 입사일;
    }

    public SamKwangSOEVO(int 인사번호, int 주문번호, int 운송ID, String 운송이름, String 주문일, String 직책) {
        this.인사번호 = 인사번호;
        this.주문번호 = 주문번호;
        this.운송ID = 운송ID;
        this.운송이름 = 운송이름;
        this.주문일 = 주문일;
        this.직책 = 직책;
    }

    public int get인사번호() {
        return 인사번호;
    }

    public void set인사번호(int 인사번호) {
        this.인사번호 = 인사번호;
    }

    public int get주문번호() {
        return 주문번호;
    }

    public void set주문번호(int 주문번호) {
        this.주문번호 = 주문번호;
    }

    public int get운송ID() {
        return 운송ID;
    }

    public void set운송ID(int 운송ID) {
        this.운송ID = 운송ID;
    }

    public String get운송이름() {
        return 운송이름;
    }

    public void set운송이름(String 운송이름) {
        this.운송이름 = 운송이름;
    }

    public String get담당자전화번호() {
        return 담당자전화번호;
    }

    public void set담당자전화번호(String 담당자전화번호) {
        this.담당자전화번호 = 담당자전화번호;
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

    public int get고객번호() {
        return 고객번호;
    }

    public void set고객번호(int 고객번호) {
        this.고객번호 = 고객번호;
    }

    public String get주민등록번호() {
        return 주민등록번호;
    }

    public void set주민등록번호(String 주민등록번호) {
        this.주민등록번호 = 주민등록번호;
    }

    public String get성명() {
        return 성명;
    }

    public void set성명(String 성명) {
        this.성명 = 성명;
    }

    public String get소속부서() {
        return 소속부서;
    }

    public void set소속부서(String 소속부서) {
        this.소속부서 = 소속부서;
    }

    public String get직책() {
        return 직책;
    }

    public void set직책(String 직책) {
        this.직책 = 직책;
    }

    public String get입사일() {
        return 입사일;
    }

    public void set입사일(String 입사일) {
        this.입사일 = 입사일;
    }
}
