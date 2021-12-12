package Repository;

import Model.Customer;
import Model.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerRepository {
    public static Map<String, Seller> sellerRepo=new HashMap<>();

    public static boolean isExist(String customerId)
    {
        if(sellerRepo.containsKey(customerId))
            return true;
        return false;
    }
    public static Seller findById(String sellerId)
    {
        if(isExist(sellerId))
            return sellerRepo.get(sellerId);
        return null;
    }
    public static List<Seller> findAll()
    {
        List<Seller>sellerList=new ArrayList<>();
        for(Seller seller:sellerRepo.values())
        {
            sellerList.add(seller);
        }
        return sellerList;

    }
    public static String save(Seller seller)
    {
        if(isExist(seller.getId())==false)
        {
            sellerRepo.put(seller.getId(),seller);
            return "saved";
        }
        return "Seller Already Registered ";

    }
}
