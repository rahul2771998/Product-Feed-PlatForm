package Model;
import java.util.*;
public class Customer {
    private String id;
    private String name;
    private String email;
    private Long phone;
    private String address;
    private List<String>subSellerId;
    private Set<String>upVotePost=new HashSet<>();
    private Set<String>downVotePost=new HashSet<>();


    public Customer(String id, String name, String email, Long phone, List<String> subSellerId, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.subSellerId = subSellerId;
        this.address=address;
    }

    public Customer()
    {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public List<String> getSubSellerId() {
        return subSellerId;
    }

    public void setSubSellerId(List<String> subSellerId) {
        this.subSellerId = subSellerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Set<String> getUpVotePost() {
        return upVotePost;
    }

    public void setUpVotePost(Set<String> upVotePost) {
        this.upVotePost = upVotePost;
    }

    public Set<String> getDownVotePost() {
        return downVotePost;
    }

    public void setDownVotePost(Set<String> downVotePost) {
        this.downVotePost = downVotePost;
    }
}
