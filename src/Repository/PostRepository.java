package Repository;

import Model.Customer;
import Model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    public static Map<String, Post> postRepo=new HashMap<>();

    public static boolean isExist(String postId)
    {
        if(postRepo.containsKey(postId))
            return true;
        return false;
    }
    public static Post findById(String postId)
    {
        if(isExist(postId))
            return postRepo.get(postId);
        return null;
    }
    public static List<Post> findAll()
    {
        List<Post>postList=new ArrayList<>();
        for(Post post:postRepo.values())
        {
            postList.add(post);
        }
        return postList;

    }
    public static void save(Post post)
    {
            postRepo.put(post.getId(),post);

    }
}
