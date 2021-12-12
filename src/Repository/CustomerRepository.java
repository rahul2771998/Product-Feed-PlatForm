package Repository;

import java.util.*;
import Model.Customer;
import com.sun.deploy.security.SelectableSecurityManager;

public class CustomerRepository {
    public static Map<String, Customer>customerRepo=new HashMap<>();

    public static boolean isExist(String customerId)
    {
        if(customerRepo.containsKey(customerId))
            return true;
        return false;
    }
    public static Customer findById(String customerId)
    {
        return customerRepo.get(customerId);

    }
    public static List<Customer> findAll()
    {
        List<Customer>customerList=new ArrayList<>();
            for(Customer cust:customerRepo.values())
            {
                customerList.add(cust);
            }
        return customerList;

    }
    public static void  save(Customer customer)
    {
            customerRepo.put(customer.getId(),customer);

    }



}
