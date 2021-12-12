package Service;

import Repository.CustomerRepository;
import Model.*;
import Exception.*;
import Repository.*;
import java.util.*;

import java.util.ArrayList;

public class FeedService {
    public static void fetchPostsByRecency(String customerId)
    {
        
        if(CustomerRepository.isExist(customerId))
        {
            List<RatedAndRecentPost>recenyPosts=new ArrayList<>();
            Customer customer=CustomerRepository.findById(customerId);
            for(String sellerId:customer.getSubSellerId())
            {
                for(String postId:SellerRepository.findById(sellerId).getPostIds())
                {
                    RatedAndRecentPost rpost=new RatedAndRecentPost();
                    rpost.setSellerId(sellerId);
                    rpost.setPostId(postId);
                    rpost.setSellerRating(SellerRepository.findById(sellerId).getRating());
                    rpost.setRecency(PostRepository.findById(postId).getTimestamp());
                    rpost.setProductId(PostRepository.findById(postId).getProductId());
                    recenyPosts.add(rpost);
                    
                }
            }
            Collections.sort(recenyPosts, RatedAndRecentPost.RecentPost);
            for(RatedAndRecentPost  rpost:recenyPosts)
            {
                System.out.println(rpost.getPostId()+" "+rpost.getProductId()+ " "+ProductRepository.findById(rpost.getProductId()).getName()+" "+ProductRepository.findById(rpost.getProductId()).getPrice()+" "+ProductRepository.findById(rpost.getProductId()).getCategory());
            }
                

            

        }
        else
        {
            throw new InvalidCustomerException("Invalid Customer Id");
        }
    }
    public static void fetchPostsBySellerRating(String customerId)
    {
        if(CustomerRepository.isExist(customerId))
        {

            List<RatedAndRecentPost>retedAndPosts=new ArrayList<>();
            Customer customer=CustomerRepository.findById(customerId);
            for(String sellerId:customer.getSubSellerId())
            {
                for(String postId:SellerRepository.findById(sellerId).getPostIds())
                {
                    RatedAndRecentPost rpost=new RatedAndRecentPost();
                    rpost.setSellerId(sellerId);
                    rpost.setPostId(postId);
                    rpost.setSellerRating(SellerRepository.findById(sellerId).getRating());
                    rpost.setRecency(PostRepository.findById(postId).getTimestamp());
                    rpost.setProductId(PostRepository.findById(postId).getProductId());
                    retedAndPosts.add(rpost);
                }
            }
            Collections.sort(retedAndPosts, RatedAndRecentPost.RatedPost);

            for(RatedAndRecentPost  rpost:retedAndPosts)
            {
                System.out.println(rpost.getPostId()+" "+rpost.getProductId()+ " "+ProductRepository.findById(rpost.getProductId()).getName()+" "+ProductRepository.findById(rpost.getProductId()).getPrice()+" "+ProductRepository.findById(rpost.getProductId()).getCategory());
            }
        }
        else
        {
            throw new InvalidCustomerException("Invalid Customer Id");
        }

    }
}
