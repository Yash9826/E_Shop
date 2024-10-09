package com.main;

import com.admin.Product;

import java.util.Scanner;

public class Eshop {

     static Scanner sc = new Scanner(System.in);
    static  int choice=0;


    // main method
    public static void main(String[] args) {

        boolean flag = false;
        while(!flag) {
            try {

                do {

                    System.out.println("\n*****Select profile*****\n");
                    System.out.println("1). Select User");
                    System.out.println("2). Select Admin");
                    System.out.println("Press 3 for Exit");
                    System.out.print("Enter here :  ");
                    choice = sc.nextInt();


                    switch (choice) {

                        // user authentication
                        case 1:

                            System.out.println("\nWelcome User, Enter your Credentials");


                            System.out.print("Enter UserName : ");
                            Scanner sc = new Scanner(System.in);
                            String uName = sc.next();

                            System.out.print("Enter Password : ");
                            String uPassword = sc.next();

                            // for user login success
                            if (uName.equalsIgnoreCase("test@123") && uPassword.equals("12345")) {


                                System.out.println("User Login Successfully");
                                user();

                            }

                            // for wrong credential of user
                            else {

                                System.out.println("Incorrect username or password\n");
                            }
                            break;


                        // admin authentication and accessing data
                        case 2:
                            System.out.println("\nWelcome, Admin");
                            System.out.print("Enter UserName : ");
                            Scanner sc1 = new Scanner(System.in);
                            String userName = sc1.next();

                            System.out.print("Enter Password : ");
                            String password = sc1.next();

                            // for admin login success
                            if (userName.equalsIgnoreCase("yash@123") && password.equals("12345")) {
                                System.out.println("Admin Login Successfully");
                                admin();

                            }


                            // for admin login failed
                            else {

                                System.out.println("Incorrect username or password\n");
                            }
                            break;

                        case 3:

                            System.out.println("You have been logged out....");
                            flag = true;
                            break;

                        default:
                            System.out.println("Pls choose correct option\n");
                            break;


                    }


                }
                while (choice != 3);

            } catch (Exception e) {
                System.out.println("Invalid input, try again");
                sc.next();
            }
        }


    }


    // admin method
    public static void admin() {



        do {

            // admin dashboard
            System.out.println("\n1). Add Product");
            System.out.println("2). Show Product");
            System.out.println("3). Update Product");
            System.out.println("4). Delete Product");
            System.out.println("Press 5 for Main Menu");
            System.out.print("Enter here : ");

            choice = sc.nextInt();

            switch (choice) {


                case 1:
                           boolean flag = false;

                        while (!flag) {
                            try {

                                System.out.println("\nEnter Product Details");
                                System.out.print("Enter Product ID : ");
                                int id = sc.nextInt();
                                // checking product id if already exist
                                if (Product.checkProductId(id)) {
                                    System.out.println("Product with same id already exist, try with other");
                                    break;
                                }

                                System.out.print("Enter Product Name : ");
                                String name = sc.next();

//                                if(name.equals("[[A-Z][a-zA-Z]*,\\s[A-Z][a-zA-Z]*]")){
//                                    System.out.println("Product name cann't be numeric");
//                                    break;
//                                }


                                //  checking if product name is not string
                                for(int i=0;i<name.length();i++)
                                {
                                    if(Character.isDigit(name.charAt(i)))
                                    {
                                        System.out.println("Product name can't have numeric values");
                                        return;
                                    }
                                }

                                System.out.print("Enter Product QTY : ");
                                int qty = sc.nextInt();
                                if(qty<=0){
                                    System.out.println("Product Quantity cannot be less than 0");
                                    break;
                                }

                                // adding product to list by admin
                                boolean b = Product.adminAddProduct(id, name, qty);


                                if (b) {
                                    System.out.println("Product Added Sucessfully!!");
                                    flag = true;
                                } else {
                                    System.out.println("Product Addition Failed");
                                }
                            }
                            catch (Exception e){
                                System.out.println("\nInvalid input");
                                sc.next();
                            }
                        }


                    break;


                case 2:

                      // displying product by admin
                      Product.showProducts();
                      break;


                case 3:

                    // update product by admin
                    if(Product.updateProducts()){

                        System.out.println();
                        System.out.println("Product Updated Sucessfully!!");
                    }
                    else
                    {

                        System.out.println("Product Updation Failed");

                    }
                    break;

                case 4:

//                    System.out.println("\nDelete product");


                    if(Product.deleteProducts())
                    {

                        System.out.println("Product Deleted Sucessfully!!");
                    }
                    else
                    {

                        System.out.println("Product Deletion Failed");

                    }
                    break;


                default:
                    System.out.println("Plss choose correct option\n");
                    break;

            }

        }
        while (choice!=5);


    }


    //***************************************************************************************************

    //user method
    private static void user() {

        boolean flag = false;
        while (!flag)
        {
            try {
                do {

                    // user dashboard
                    System.out.println("\n1). Show Product");
                    System.out.println("2). Buy Product");
                    System.out.println("3).  Show Your Cart");
                    System.out.println("Press 4 for Main Menu");
                    System.out.print("Enter here : ");

                    choice = sc.nextInt();

                    switch (choice)
                    {

                        case 1 :

                            // user viewing products
                            Product.showProductsToUser();
                            break;

                        case 2 :

                            // user buying product
                            if(Product.userPurchaseProduct()){
                                System.out.println("Purchased sucessfully");
                            }


                            break;



                        case 3 :
                            // user getting products from his/her cart
                            Product.userGetProduct();

                            break;

                        case 4 :
                            flag = true;
                            break;

                        default:
                            System.out.println("Pls Choose Correct Option");
                    }

                }
                while (choice!=4);
            }
            catch (Exception e){
                System.out.println("Invalid input, try again");
                sc.next();
            }
        }


    }

}



