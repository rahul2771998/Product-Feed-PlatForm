package Exception;

public class InvalidPostException extends RuntimeException{
    private String mssg;
    public InvalidPostException(String mssg) {
        this.mssg = mssg;
    }


    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
