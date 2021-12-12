package Response;

public class CustomerDownvotePostResponse {
    private String mssg;
    public CustomerDownvotePostResponse(String mssg) {

        this.mssg = mssg;
    }

    public String getMssg() {
        return mssg;
    }


    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
