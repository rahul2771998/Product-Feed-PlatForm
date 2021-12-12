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
            System.out.println(str);

            String arr[]=str.split(" ");
            if(arr[0].equalsIgnoreCase("Add"))
            {
                if(arr[1].equalsIgnoreCase("User"))
                {
                    // Add User user1 email 272616271
                    //String userId, String name, String email, Long phone
                    Long phone=Long.valueOf(arr[5]);
                    UserCreationResponse uResponse=service.addUser(arr[2],arr[3],arr[4],phone);

                    System.out.println(uResponse.getMessage());

                }

                else if(arr[1].equalsIgnoreCase("Song"))
                {
                    if(arr[2].equalsIgnoreCase("To") && arr[3].equalsIgnoreCase("PlayList"))
                    {
                        // Add Song To PlayList song1 playList1
                        AddSongToPlayListResponse response=service.addSongsToPlayList(arr[4],arr[5]);
                        System.out.println(response.getMessage());

                    }
                    else {
                        // Add Song songId name genre singer tempo
                        AddSongResponse response=service.addSong(arr[2], arr[3], arr[4], arr[5], Integer.parseInt(arr[6]));
                        System.out.println(response.getMessage());
                    }
                }

                else if(arr[1].equalsIgnoreCase("Friend"))
                {
                    // Add Friend user1 user2
                    AddFriendResponse response= service.addFriend(arr[2],arr[3]);
                    System.out.println(response.getMessage());

                }
            }
            else if(arr[0].equalsIgnoreCase("Create"))
            {
                if(arr[1].equalsIgnoreCase("PlayList"))
                {
                    // Create PlayList userId playListId songIds
                    List<String>songsIds=new ArrayList<>();
                    for(int i=4;i<arr.length;i++)
                        songsIds.add(arr[i]);

                    CreatePlayListResponse response= service.createPlayList(arr[2],arr[3],songsIds);
                    System.out.println(response.getMessage());


                }
            }

            else if(arr[0].equalsIgnoreCase("Show") && arr[1].equalsIgnoreCase("PlayList"))
            {
                // Show PlayList userId playListId
                service.showPlayList(arr[2],arr[3]);
            }
            else if(arr[0].equalsIgnoreCase("Follow"))
            {
                // Follow userId1 To userId2
                FollowFriendResponse response=service.follow(arr[1],arr[3]);
                System.out.println(response.getMessage());

            }
            else if(arr[0].equalsIgnoreCase("Recommend"))
            {
                // Recommend Songs userId

                service.recommendSongs(arr[2]);

            }



            t-=1;


        }

    }
}



// Add User user1 email 272616271
// Add Song songId name genre singer tempo
//Create PlayList user1 playList1 song1 song2 song3
// Add Song To PlayList playList1 song4
// Show PlayList userId playListId
// Add Friend user1 user2
// Follow userId1 To userId2
// Recommend Songs userId


//1.Add User user1 Rahul abc@tila.com 92382937
//2.Add User user2 Mohit XYZ@tila.com 38929032
//3.Add User user3 Nitish abxaj@email.com 38210378
//4.Add Friend user1 user2
//5.Follow user1 To user3
//6.Add Song song8 song8 Folk AB 60
//7.Create PlayList user1 playList1 song1 song2 song3
//8.Add Song To PlayList playList1 song4
//9.Show PlayList user1 playList1
//10.Recommend Songs user1
