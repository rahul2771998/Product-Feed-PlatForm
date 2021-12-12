package Exception;

public class InvalidCustomerException extends RuntimeException{
    private String mssg;
    public InvalidCustomerException(String mssg) {
        this.mssg = mssg;
    }


    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
