package Response;

public class CreateSellerResponse {
    private String mssg;
    public CreateSellerResponse(String mssg) {
        this.mssg = mssg;
    }

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
