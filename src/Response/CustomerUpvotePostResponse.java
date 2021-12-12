package Response;

public class CustomerUpvotePostResponse {

    private String mssg;
    public CustomerUpvotePostResponse(String mssg) {

        this.mssg = mssg;
    }

    public String getMssg() {
        return mssg;
    }


    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
