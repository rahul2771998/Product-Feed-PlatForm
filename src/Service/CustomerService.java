package Service;

import Model.Customer;
import Model.Seller;
import Repository.CustomerRepository;
import Repository.PostRepository;
import Repository.SellerRepository;
import Response.CreateCustomerResponse;
import Response.DesubscribeToSellerResponse;
import Response.SubscribeToSellerResponse;
import Exception.*;
import Response.*;
import Model.*;

import java.util.*;

public class CustomerService {

    public static CreateCustomerResponse createCustomer(String id, String name, String email, long phone, String address)
    {
        if(CustomerRepository.isExist(id)==false) {


            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);
            customer.setAddress(address);
            return new CreateCustomerResponse("Customer " + id+ " Registered Successfully");

        }
        else
        {
            return new CreateCustomerResponse("Customer " + id+ " Already exist");
        }
    }
    public static List<Seller> getSeller()
    {
        List<Seller>listSeller=new ArrayList<>();
        for(Seller seller: SellerRepository.findAll())
        {
           listSeller.add(seller);
        }
        return listSeller;
    }
    public static SubscribeToSellerResponse subscribeToSeller(String customerId,String sellerId) {
        if (CustomerRepository.isExist(customerId) && SellerRepository.isExist(sellerId)){
            Customer customer = CustomerRepository.findById(customerId);
            List<String> sellerIds = CustomerRepository.findById(customerId).getSubSellerId();sellerIds.add(sellerId);
            customer.setSubSellerId(sellerIds);
            CustomerRepository.save(customer);
            return new SubscribeToSellerResponse("Customer "+ customerId+" subscribe to seller "+ sellerId+"  successfully");

    }
        else
        {
            if(CustomerRepository.isExist(customerId))
                throw new InvalidSellerException("Invalid Seller Id");
            else
                throw new InvalidCustomerException("Invalid Customer Id");
        }

    }
    public static DesubscribeToSellerResponse desubscribeToSeller(String customerId,String sellerId)
    {
        if(CustomerRepository.isExist(customerId)&& SellerRepository.isExist(sellerId)) {
            Customer customer = CustomerRepository.findById(customerId);
            List<String> sellerIds = CustomerRepository.findById(customerId).getSubSellerId();
            List<String> newSellerIds = new ArrayList<>();

                for (String id : sellerIds) {
                    if (id.equalsIgnoreCase(sellerId))
                        continue;
                    newSellerIds.add(id);
                }

                    customer.setSubSellerId(sellerIds);
                    CustomerRepository.save(customer);
                    return new DesubscribeToSellerResponse("Customer " + customerId + " desubscribe to seller " + sellerId + "  successfully");

        }
        else
        {
            if(CustomerRepository.isExist(customerId))
                throw new InvalidSellerException("Invalid Seller Id");
            else
                throw new InvalidCustomerException("Invalid Customer Id");


        }
    }

    public CustomerUpvotePostResponse customerUpvotePost(String customerId,String postId)
    {
        if(CustomerRepository.isExist(customerId)&& PostRepository.isExist(postId))
        {
            if(isDownVotedPost(customerId,postId)==true)
            {
                CustomerRepository.findById(customerId).getDownVotePost().remove(postId);

                Set<String>s=CustomerRepository.findById(customerId).getUpVotePost();
                s.add(postId);
                Customer customer=CustomerRepository.findById((customerId));
                customer.setUpVotePost(s);
                CustomerRepository.save(customer);
                Post post=PostRepository.findById(postId);
                Integer upvote=post.getUpvote();
                upvote+=1;
                Integer downvote=post.getDownvote();
                downvote-=1;
                post.setUpvote(upvote);
                post.setDownvote(downvote);
                PostRepository.save(post);
                Seller seller=SellerRepository.findById(post.getPublishedBy());
                Integer upvoteCount=seller.getTotoalUpvote();
                upvote+=1;
                downvote =seller.getTotalDownVote();
                downvote-=1;
                seller.setTotalDownVote(downvote);
                seller.setTotoalUpvote(upvote);
                Double rating=(5*upvote)*1.0/(upvote+downvote);
                seller.setRating(rating);
                SellerRepository.save(seller);

                return new CustomerUpvotePostResponse(customerId+" upvoted Successfully "+postId);


            }
            else
            {

                Set<String>s=CustomerRepository.findById(customerId).getUpVotePost();
                s.add(postId);
                Customer customer=CustomerRepository.findById((customerId));
                customer.setUpVotePost(s);
                CustomerRepository.save(customer);
                Post post=PostRepository.findById(postId);
                Integer upvote=post.getUpvote();
                upvote+=1;
                post.setUpvote(upvote);
                PostRepository.save(post);
                Seller seller=SellerRepository.findById(post.getPublishedBy());
                Integer upvoteCount=seller.getTotoalUpvote();
                upvote+=1;
                Integer downvote =seller.getTotalDownVote();
                Double rating=(5*upvote)*1.0/(upvote+downvote);
                seller.setRating(rating);
                SellerRepository.save(seller);

                return new CustomerUpvotePostResponse(customerId+" upvoted Successfully "+postId);
            }
        }
        else
        {
            if(CustomerRepository.isExist(customerId))
                throw new InvalidPostException("Invalid Post Id");
            else
                throw new InvalidCustomerException("Invalid Customer Id");
        }
    }

    public static boolean isUpVotedPost(String customerId, String postId)
    {
        if(CustomerRepository.isExist(customerId) && PostRepository.isExist(postId))
        {
            if(CustomerRepository.findById(customerId).getUpVotePost().contains(postId))
                return true;
            return false;
        }
        else
        {
            if(CustomerRepository.isExist(customerId))
                throw new InvalidPostException("Invalid Post Id");
            else
                throw new InvalidCustomerException("Invalid Customer Id");
        }
    }
    public static boolean isDownVotedPost(String customerId, String postId)
    {
        if(CustomerRepository.isExist(customerId) && PostRepository.isExist(postId))
        {
            if(CustomerRepository.findById(customerId).getDownVotePost().contains(postId))
                return true;
            return false;
        }
        else
        {
            if(CustomerRepository.isExist(customerId))
                throw new InvalidPostException("Invalid Post Id");
            else
                throw new InvalidCustomerException("Invalid Customer Id");
        }
    }

    public CustomerDownvotePostResponse customerDowntePost(String customerId,String postId)
    {
        if(CustomerRepository.isExist(customerId)&& PostRepository.isExist(postId))
        {
            if(isUpVotedPost(customerId,postId)==true)
            {
                CustomerRepository.findById(customerId).getUpVotePost().remove(postId);
                Set<String>s=CustomerRepository.findById(customerId).getDownVotePost();
                s.add(postId);
                Customer customer=CustomerRepository.findById((customerId));
                customer.setDownVotePost(s);
                CustomerRepository.save(customer);
                Post post=PostRepository.findById(postId);
                Integer upvote=post.getUpvote();
                upvote-=1;
                Integer downvote=post.getDownvote()+1;
                post.setUpvote(upvote);
                post.setDownvote(downvote);
                PostRepository.save(post);
                Seller seller=SellerRepository.findById(post.getPublishedBy());
                Integer upvoteCount=seller.getTotoalUpvote();
                upvote-=1;
                downvote= seller.getTotalDownVote()+1;

                Double rating=(5*upvote)*1.0/(upvote+downvote);
                seller.setRating(rating);
                seller.setTotoalUpvote(upvoteCount);
                seller.setTotalDownVote(downvote);
                SellerRepository.save(seller);

                return new CustomerDownvotePostResponse(customerId+" Downvoted Successfully "+postId);

            }
            else
            {
                Set<String>s=CustomerRepository.findById(customerId).getDownVotePost();
                s.add(postId);
                Customer customer=CustomerRepository.findById((customerId));
                customer.setDownVotePost(s);
                CustomerRepository.save(customer);
                Post post=PostRepository.findById(postId);
                Integer upvote=post.getUpvote();

                Integer downvote=post.getDownvote()+1;
                post.setUpvote(upvote);
                post.setDownvote(downvote);
                PostRepository.save(post);
                Seller seller=SellerRepository.findById(post.getPublishedBy());
                Integer upvoteCount=seller.getTotoalUpvote();
                downvote= seller.getTotalDownVote()+1;

                Double rating=(5*upvote)*1.0/(upvote+downvote);
                seller.setRating(rating);
                seller.setTotoalUpvote(upvoteCount);
                seller.setTotalDownVote(downvote);
                SellerRepository.save(seller);

                return new CustomerDownvotePostResponse(customerId+" Downvoted Successfully "+postId);
            }
        }
        else
        {
            if(CustomerRepository.isExist(customerId))
                throw new InvalidPostException("Invalid Post Id");
            else
                throw new InvalidCustomerException("Invalid Customer Id");
        }
    }


}
   /* Features expected:
        1. Seller
        a. Seller can be created using platform
        b. Seller can publish multiple posts.
        2. Customer
        a. Customers can be created using a platform.
        b. Customers can get a list of existing sellers.
        c. Customers can subscribe to sellers.
        3. Feed
        a. Customer can fetch feeds based on Ranking function.
        4. Seller can delete his multiple posts.
        5. Customer can unsubscribe to sellers.
        6. Bonus(only attempt if time permits):
        Customers can upvote/downvote a product post by a seller.
        Seller’s current rating will be function of total upvotes & downvotes on their posts. For
        simplicity consider rating = Positive of [5 * (total upvotes)/(total upvotes + total downvotes)]. ie.
        Here 5 is beginning rating.

    */