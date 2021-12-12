package Response;

public class CreateCustomerResponse {
    private String messg;
    public CreateCustomerResponse(String messg) {
        this.messg = messg;
    }



    public String getMessg() {
        return messg;
    }

    public void setMessg(String messg) {
        this.messg = messg;
    }
}
