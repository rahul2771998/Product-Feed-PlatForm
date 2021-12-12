package Service;

import Model.Customer;
import Repository.CustomerRepository;
import Response.CreateCustomerResponse;
import Response.CreateSellerResponse;
import Model.*;
import Exception.*;
import Repository.*;
import Exception.*;
import Response.*;
import java.util.*;
import Exception.InvalidProductException;

import java.security.Timestamp;


public class SellerService {

    public static CreateSellerResponse createCustomer(String id, String name, String email, long phone, String address)
    {
        if(CustomerRepository.isExist(id)==false) {


            Seller seller = new Seller();
            seller.setId(id);
            seller.setName(name);
            seller.setEmail(email);
            seller.setPhone(phone);
            seller.setAddress(address);
            return new CreateSellerResponse("Customer " + id+ " Registered Successfully");

        }
        else
        {
           throw new InvalidSellerException("Invalid Seller Id");
        }
    }

    public static AddProductResponse addProduct(String id, String name, double price, String category, String addedBy )
    {
        if(!ProductRepository.isExist(id) && SellerRepository.isExist(addedBy))
        {
            Product product =new Product();
            product.setId(id);
            product.setCategory(category);
            product.setPrice(price);
            product.setName(name);
            product.setAddedBy(addedBy);
            ProductRepository.save(product);
            Seller seller=SellerRepository.findById(addedBy);
            Set<String>s = seller.getProductIds();
            s.add(id);
            seller.setProductIds(s);
            SellerRepository.save(seller);
            return new AddProductResponse("Product "+id+" added Successfully");

        }
        else if(SellerRepository.isExist(addedBy)==false)
        {
            throw new InvalidSellerException("Invalid SellerId");
        }
        else
        {
            throw new InvalidProductException("Product Already Exist");
        }
    }

    public static AddPostResponse addPost( String postId,String dateTime,String productId,String publishedBy)
    {
        if(PostRepository.isExist(postId)==false && SellerRepository.isExist(publishedBy) && ProductRepository.isExist(productId))
        {
            Post post=new Post();
            post.setId(postId);
            post.setDateTime(dateTime);
            post.setName(postId);
            post.setPublishedBy(publishedBy);
            post.setProductId(productId);
            Calendar calendar = Calendar.getInstance();
            //Returns current time in millis
            Seller seller=SellerRepository.findById(publishedBy);
            Set<String> postIds=seller.getPostIds();
            postIds.add(postId);
            seller.setPostIds(postIds);
            SellerRepository.save(seller);

            long timeMilli2 = calendar.getTimeInMillis();
            post.setTimestamp(timeMilli2);
            PostRepository.save(post);

            return new AddPostResponse(postId+" published By "+publishedBy+ " sucessfully");
        }
        else
        {
            throw new InvalidPostException("Invalid post Id");
        }
    }

    public static DeletePostResponse deletePost( String postId,String dateTime,String productId,String publishedBy)
    {
        if(PostRepository.isExist(postId)==false && SellerRepository.isExist(publishedBy) && ProductRepository.isExist(productId))
        {
            Post post=new Post();
            post.setId(postId);
            post.setDateTime(dateTime);
            post.setName(postId);
            post.setPublishedBy(publishedBy);
            post.setProductId(productId);
            Calendar calendar = Calendar.getInstance();
            //Returns current time in millis
            Seller seller=SellerRepository.findById(publishedBy);
            Set<String> postIds=seller.getPostIds();
            postIds.add(postId);
            seller.setPostIds(postIds);
            SellerRepository.save(seller);

            long timeMilli2 = calendar.getTimeInMillis();
            post.setTimestamp(timeMilli2);
            PostRepository.save(post);

            return new DeletePostResponse(postId+" deleted By "+publishedBy+ " sucessfully");
        }
        else
        {
            throw new InvalidPostException("Invalid sellerId");
        }
    }
}
