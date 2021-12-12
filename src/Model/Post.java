package Model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private String name;
    private String dateTime;
    private String productId;
    private Integer upvote=0;
    private Integer downvote=0;
    private Long timestamp;
    private List<String>upVoteCustomerList=new ArrayList<>();
    private List<String>downVoteCustomerList=new ArrayList<>();
    private String publishedBy;//Seller ID

    public Post(String id, String name, String dateTime, String productId, Integer upvote, Integer downvote,long timestamp,String publishedBy) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.productId = productId;
        this.upvote = upvote;
        this.downvote = downvote;
        this.timestamp=timestamp;
        this.publishedBy=publishedBy;
    }
    public Post()
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getUpvote() {
        return this.upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getDownvote() {
        return this.downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getUpVoteCustomerList() {
        return this.upVoteCustomerList;
    }

    public void setUpVoteCustomerList(List<String> upVoteCustomerList) {
        this.upVoteCustomerList = upVoteCustomerList;
    }

    public List<String> getDownVoteCustomerList() {
        return this.downVoteCustomerList;
    }

    public void setDownVoteCustomerList(List<String> downVoteCustomerList) {
        this.downVoteCustomerList = downVoteCustomerList;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }
}
