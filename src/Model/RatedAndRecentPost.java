package Model;

import java.util.Comparator;

public class RatedAndRecentPost {
    private String postId;
    private String sellerId;
    private double sellerRating;
    private long recency;
    private Integer upvote;
    private Integer downvote;
    private String productId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(double sellerRating) {
        this.sellerRating = sellerRating;
    }

    public long getRecency() {
        return recency;
    }

    public void setRecency(long recency) {
        this.recency = recency;
    }

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }


    public static Comparator<RatedAndRecentPost> RecentPost = new   Comparator<RatedAndRecentPost>() {

        public int compare(RatedAndRecentPost a, RatedAndRecentPost b) {
            if (a.getRecency() > b.getRecency())
                return 1;
            else if (b.getRecency() == a.getRecency())
                return a.getSellerRating() - b.getSellerRating() > 0 ? 1 : -1;

            return -1;

        }
    };

    public static Comparator<RatedAndRecentPost> RatedPost = new   Comparator<RatedAndRecentPost>() {

        public int compare(RatedAndRecentPost a, RatedAndRecentPost b) {
            if (a.getSellerRating() > a.getSellerRating())
                return 1;
            else if (b.getRecency() == a.getRecency())
                return b.getRecency() - a.getRecency() > 0 ? 1 : -1;

            return -1;

        }
    };


}
