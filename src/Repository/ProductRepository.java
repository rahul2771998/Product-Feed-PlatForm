package Repository;

import Model.Customer;
import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    public static Map<String, Product> productRepo=new HashMap<>();

    public static boolean isExist(String customerId)
    {
        if(productRepo.containsKey(customerId))
            return true;
        return false;
    }
    public static Product findById(String productId)
    {
        if(isExist(productId))
            return productRepo.get(productId);
        return null;
    }
    public static List<Product> findAll()
    {
        List<Product>productList=new ArrayList<>();
        for(Product product:productRepo.values())
        {
            productList.add(product);
        }
        return productList;

    }
    public static void save(Product product)
    {
        productRepo.put(product.getId(),product);

    }
}
