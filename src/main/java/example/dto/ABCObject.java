package example.dto;

import java.util.List;

public class ABCObject {
    private String a1;
    private String a2;
    private String a3;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public List<BBObject> getB() {
        return b;
    }

    public void setB(List<BBObject> b) {
        this.b = b;
    }

    private List<BBObject> b;
}
