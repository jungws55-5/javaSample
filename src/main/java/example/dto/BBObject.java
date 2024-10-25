package example.dto;

import java.util.List;

public class BBObject {
    private String b1;
    private String b2;
    private String b3;


    private List<CC> C;

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public List<CC> getC() {
        return C;
    }

    public void setC(List<CC> c) {
        C = c;
    }
}
