package Exception;

public class InvalidProductException extends RuntimeException {
    private String mssg;
    public InvalidProductException(String mssg) {
        this.mssg = mssg;
    }


    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
