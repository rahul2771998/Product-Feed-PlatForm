package Exception;

public class InvalidSellerException extends RuntimeException {
    private String mssg;
    public InvalidSellerException(String mssg) {
        this.mssg = mssg;
    }


    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
