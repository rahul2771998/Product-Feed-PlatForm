package Model;

import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Seller {
    private String id;
    private String name;
    private String email;
    private Long phone;
    private String address;
    private double rating=5;
    private Set<String>  postIds=new HashSet<>();
    private Set<String> productIds=new HashSet<>();
    private Integer totoalUpvote=1;
    private Integer totalDownVote=0;
    private Set<String>subscribers=new HashSet<>();
    private Set<String>desubcrbers=new HashSet<>();

    public Seller(String id, String name, String email, Long phone, String address, Integer rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.rating = rating;

    }
    public Seller()
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<String> getPostIds() {
        return postIds;
    }

    public void setPostIds(Set<String> postIds) {
        this.postIds = postIds;
    }

    public Set<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<String> productIds) {
        this.productIds = productIds;
    }

    public Integer getTotoalUpvote() {
        return totoalUpvote;
    }

    public void setTotoalUpvote(Integer totoalUpvote) {
        this.totoalUpvote = totoalUpvote;
    }

    public Integer getTotalDownVote() {
        return totalDownVote;
    }

    public void setTotalDownVote(Integer totalDownVote) {
        this.totalDownVote = totalDownVote;
    }

    public Set<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<String> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<String> getDesubcrbers() {
        return desubcrbers;
    }

    public void setDesubcrbers(Set<String> desubcrbers) {
        this.desubcrbers = desubcrbers;
    }
}
