public class Stocks {
    private String code;
    private String name;
    private float CorrentPrice;
    private float YestoOpenprice;
    private String time ;
    private float rate;

    @Override
    public String toString() {
        return "Stocks{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", CorrentPrice=" + CorrentPrice +
                ", YestoOpenprice=" + YestoOpenprice +
                ", time='" + time + '\'' +
                ", rate=" + rate +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCorrentPrice() {
        return CorrentPrice;
    }

    public void setCorrentPrice(float correntPrice) {
        CorrentPrice = correntPrice;
    }

    public float getYestoOpenprice() {
        return YestoOpenprice;
    }

    public void setYestoOpenprice(float yestoOpenprice) {
        YestoOpenprice = yestoOpenprice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
