import Model.*;
import Exception.*;
import Repository.*;
import Service.*;
import Response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class ProductFeedPlatFormDriver {
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t>0)
        {

            String str=sc.nextLine();
            //System.out.println(str);

            String arr[]=str.split(" ");
            if(arr[0].equalsIgnoreCase("Create"))
            {
                if(arr[1].equalsIgnoreCase("Customer"))
                {
                    // Add User user1 email 272616271
                    //String userId, String name, String email, Long phone
                    Long phone=Long.valueOf(arr[5]);
                    CreateCustomerResponse response=CustomerService.createCustomer(arr[2],arr[3],arr[4],phone,arr[6]);

                    System.out.println(response.getMessg());

                }

                else if(arr[1].equalsIgnoreCase("Seller"))
                {
                    Long phone=Long.valueOf(arr[5]);
                    CreateSellerResponse response=SellerService.createSeller(arr[2],arr[3],arr[4],phone,arr[6]);

                    System.out.println(response.getMssg());

                }

                else if(arr[1].equalsIgnoreCase("post"))
                {
                    // Add Friend user1 user2//String postId,String dateTime,String productId,String publishedBy
                    AddPostResponse response= SellerService.addPost(arr[2],arr[3],arr[4],arr[5]);
                    System.out.println(response.getMessg());

                }
            }
            else if(arr[0].equalsIgnoreCase("Add"))
            {
                if(arr[1].equalsIgnoreCase("Product"))
                {
                    //String id, String name, double price, String category, String addedBy
                    Double price=Double.parseDouble(arr[4]);
                    AddProductResponse response=SellerService.addProduct(arr[2],arr[3],price,arr[5],arr[6]);
                    System.out.println(response.getMessg());


                }
            }
            else if(arr[0].equalsIgnoreCase("Delete"))
            {
                List<String> postIds=new ArrayList<>();
                if(arr[1].equalsIgnoreCase("Posts"))
                {
                    for(int i=3;i<arr.length;i++)
                        postIds.add(arr[i]);
                    DeletePostResponse response =SellerService.deletePost(arr[2],postIds);
                    System.out.println(response.getMessg());
                }
            }
            else if(arr[0].equalsIgnoreCase("Subscribe") && arr[1].equalsIgnoreCase("Seller"))
            {
                SubscribeToSellerResponse response =CustomerService.subscribeToSeller(arr[2],arr[3]);
                System.out.println(response.getMessg());
            }
            else if(arr[0].equalsIgnoreCase("DeSubscribe") && arr[1].equalsIgnoreCase("Seller"))
            {
               DesubscribeToSellerResponse response =CustomerService.desubscribeToSeller(arr[2],arr[3]);
                System.out.println(response.getMessg());
            }
            else if(arr[0].equalsIgnoreCase("UpVote") && arr[1].equalsIgnoreCase("Post"))
            {
                CustomerUpvotePostResponse response=CustomerService.customerUpvotePost(arr[2],arr[3]);
                System.out.println(response.getMssg());
            }
            else if(arr[0].equalsIgnoreCase("DownVote") && arr[1].equalsIgnoreCase("Post"))
            {
                CustomerDownvotePostResponse response=CustomerService.customerDownvotePost(arr[2],arr[3]);
                System.out.println(response.getMssg());
            }
            else if(arr[0].equalsIgnoreCase("Customer") && arr[1].equalsIgnoreCase("Fetch")&& arr[2].equalsIgnoreCase("Posts") && arr[3].equalsIgnoreCase("Recency"))
            {
                FeedService.fetchPostsByRecency(arr[4]);
            }
            else if(arr[0].equalsIgnoreCase("Customer") && arr[1].equalsIgnoreCase("Fetch")&& arr[2].equalsIgnoreCase("Posts") && arr[3].equalsIgnoreCase("Seller")&& arr[4].equalsIgnoreCase("Rating"))
            {
                FeedService.fetchPostsBySellerRating(arr[5]);
            }

            


            t-=1;


        }

    }
}



