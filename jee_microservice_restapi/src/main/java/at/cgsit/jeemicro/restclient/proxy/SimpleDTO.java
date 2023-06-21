package at.cgsit.jeemicro.restclient.proxy;

public class SimpleDTO {

    private String valueA;
    private String valueB;

    public String getValueA() {
        return valueA;
    }

    public void setValueA(String valueA) {
        this.valueA = valueA;
    }

    public String getValueB() {
        return valueB;
    }

    public void setValueB(String valueB) {
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return "SimpleDTO{" +
                "valueA='" + valueA + '\'' +
                ", valueB='" + valueB + '\'' +
                '}';
    }
}
