package com.admin;
import com.User.User;
import java.util.*;

public class Product {


    private int pId;
    private String pName;
    private int qty;

    static private Product p;

    static Scanner sc = new Scanner(System.in);

    //  list for storing product ddetails
    static HashSet<Product> list = new HashSet<>();

    // parametrised constructor
    public Product(int pId, String pName, int qty) {
        this.pId = pId;
        this.pName = pName;
        this.qty = qty;
    }

//    // setting new Product p1 to current Product p
//    public Product(Product p1) {
//        p = p1;
//    }


    // default constructor
    public Product() {

    }

    // getters and setters
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    //**********************************Admin DAO***************************************************


    // method for adding product by admin
    public static boolean adminAddProduct(int pId, String pName, int qty){

        // checking product details if not empty
        if(pId!=0 && !pName.equals("") && qty!=0) {

            Iterator<Product> i = list.iterator();

            while(i.hasNext()){

                Product p = i.next();
                if(p.getpName().equals(pName)){

                    System.out.println("Duplicate Product Name Found");
                    return false;
                }
            }


           Product p1 = new Product();

           // adding product details to Product p1 Object
            p1.setpId(pId);
            p1.setpName(pName);
            p1.setQty(qty);
            list.add(p1);
            return true;
        }
        return false;

    }

    // method for printing all stored products
    public static void showProducts() {

        // getting all products from list
        Iterator<Product> i = list.iterator();

        if(list.isEmpty()){
            System.out.println("\nNo Product Found");
        }
        else {

            // getting each product details from list
            while (i.hasNext()){

                Product p = i.next();
                System.out.println("\nProduct Id : "+p.getpId());
                System.out.println("Product Name : "+p.getpName());
                System.out.println("Product Qty : "+p.getQty());

            }
        }


    }


    // method for deleteing products by admin
    public static boolean deleteProducts() {

        // traversing list

        if(list.isEmpty())
        {
            System.out.println("\nNo Product Found");
        }
        else
        {
            boolean flag = false;
            while(!flag) {
                try {


                    System.out.print("\nEnter Product Id To Verify : ");
                    int id = sc.nextInt();

                    Iterator<Product> it = list.iterator();

                    // iterating each product from list
                    while (it.hasNext()) {

                        Product p = it.next();

                        // checking id form the list Product id to delete from the list
                        for (int j = 0; j < list.size(); j++) {
                            if (id != p.getpId()) {
                                System.out.println("No Product Id found");
                                break;
                            } else {
                                list.remove(p);
                                flag = true;
                                return true;
                            }
                        }

                    }

                } catch (Exception e) {
                    System.out.println("Invalid input, try again");
                    sc.next();
                }
            }

        }
        return false;



    }


    // admin method to update product details
    public static boolean updateProducts() {

        Iterator<Product> i = list.iterator();

        if(list.isEmpty()){
            System.out.println("\nNo Product Found");
        }
        else
        {

            boolean flag = false;
            while(!flag) {
                try {

                    System.out.print("\nVerify Product Id : ");
                    int id = sc.nextInt();


                    Iterator<Product> it = list.iterator();
                    // iterating list
                    while (it.hasNext()) {


                        Product p = it.next();
                        // checking input id form the list Product's id to update
                        for (int j = 0; j < list.size(); j++) {
                            if (id != p.getpId()) {
                                System.out.println("No Product Id found");
                                 break;
                            } else {
                                // if id found in list then -> update details
                                System.out.println("\nEnter New Details");
//                                System.out.print("Enter Product ID : ");
//                                int upId = sc.nextInt();

                                System.out.print("Enter Product Name : ");
                                String upName = sc.next();

                                //  checking if product name is not string
                                for(int k=0;k<upName.length();k++)
                                {
                                    if(Character.isDigit(upName.charAt(k)))
                                    {
                                        System.out.println("Product name can't have numeric values");
                                        return false;
                                    }
                                }

                                System.out.print("Enter Product QTY : ");
                                int upQty = sc.nextInt();
                                if(upQty<=0){
                                    System.out.println("Product Quantity cannot be less than 0");
                                    return false;
                                }

//                                p.setpId(upId);
                                p.setpName(upName);
                                p.setQty(upQty);
                                flag = true;
                                return true;
                            }
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, try again");
                    sc.next();
                }
            }
        }

        return false;
    }

    // admin checking Product id if already exist in list
    public static boolean checkProductId(int id) {

        Iterator<Product> i = list.iterator();
        while(i.hasNext()){

            Product p = i.next();

            for(int j=0; j<list.size(); j++)
            {
                // if input id is equal to Product id in -> list
                if(id == p.getpId()){
                    return true;
                }
            }

        }
        return false;


    }



    //****************************************User DAO*******************************************************

    public static void showProductsToUser() {

        // getting all products from list
        Iterator<Product> i = list.iterator();

        if(list.isEmpty()){
            System.out.println("\nNo Product Found");
        }
        else {
            // getting each product details from list
            while (i.hasNext()){

                Product p = i.next();
                System.out.println("\nProduct Id : "+p.getpId());
                System.out.println("Product Name : "+p.getpName());
                System.out.println("Product Qty : "+p.getQty());

            }
        }
    }

    // user purchasing products
    public static boolean userPurchaseProduct() {

        if(list.isEmpty()){
            System.out.println("\nNo Products Available,try contacting Admin");
        }
        else {

            boolean flag = false;
            while (!flag) {

                try {
                    System.out.print("\nEnter Product Id : ");
                    int pId = sc.nextInt();
                    if(!Product.checkProductId(pId)){
                        System.out.println("No Product Id Found");
                        return false;

                    }


                    System.out.print("Enter Product Name : ");
                    String name = sc.next();
                    //  checking if product name is not string
                    for(int i=0;i<name.length();i++)
                    {
                        if(Character.isDigit(name.charAt(i)))

                        {
                            System.out.println("Product name can't have numeric values");
                            return false;
                        }
                    }

                    System.out.print("Enter Product Qty : ");
                    int qty = sc.nextInt();

                    if(qty<=0){
                        System.out.println("Product Quantity cannot be less than 0");
                        return false;
                    }



                    User u = new User();
                    u.setuId(pId);
                    u.setQty(qty);
                    u.setName(name);


                    // checking id form the list Product id to substract qty

                    Iterator<Product> i = list.iterator();
//                System.out.println(list);
                    while (i.hasNext()) {
                        Product p = i.next();

                        // traversing to products to compare that selected product is in list or not
                        if (u.purchaseProduct(qty, name)) {

                            for (int j = 0; j < list.size(); j++) {
                                if (pId != p.getpId()) {
                                    System.out.println("No such product found");
                                    return false;
                                } else {

                                    int qty1 = p.getQty();
                                    int qty2 = qty;
                                    int diffQty = qty1 - qty2;

                                    if (diffQty <= 0) {
                                        System.out.println("Insufficient Quantity, try again");
                                        return false;
                                    }
//                            System.out.println("Diffrence remaining + "+diffQty);
                                    p.setQty(diffQty);
                                    flag = true;
                                    return true;
                                }
                            }
                        } else {
                            System.out.println("Purchasing failed");
                        }

                    }


                }

                catch(Exception e)
            {

                System.out.println("Invalid input, try again");
                sc.next();
            }
        }

        }

        return false;
    }


    // by this method user can view the selected product
    public static void userGetProduct() {

     User u = new User();
     Map<Integer,String> m = u.userShowProduct();
//        System.out.println("Map of product of user fetched from User class = " +m);
     if(m!=null){

         for(Map.Entry<Integer,String> e : m.entrySet()){
             System.out.println("\nYou have following items in your cart");
             System.out.println("Product Qty : " + e.getKey());
             System.out.println("Product Name " + e.getValue());

         }
     }

    }
}
