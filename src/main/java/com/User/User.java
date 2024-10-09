package com.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {

    private int uId;
    private int qty;
    private String name;
    private Map<Integer,String> p;

    private User u;


    static Scanner sc = new Scanner(System.in);

    // map for storing user product
  static Map<Integer, String> map = new HashMap<>();

    public User(int uId, int qty, String name, User u) {
        this.uId = uId;
        this.qty = qty;
        this.name = name;
        this.u = u;
    }

    // getters and setters
    public Map<Integer, String> getP()
    {
        return p;
    }

    public void setP(Map<Integer, String> p)
    {
        this.p = p;
    }

    public User() {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getuId()
    {
        return uId;
    }

    public void setuId(int uId)
    {
        this.uId = uId;
    }

    public int getQty()
    {
        return qty;
    }

    public void setQty(int qty)
    {
        this.qty = qty;
    }

    public User getU()
    {
        return u;
    }

    public void setU(User u)
    {
        this.u = u;
    }



    public boolean purchaseProduct(int qty, String name) {

        Integer uQty = Integer.valueOf(qty);
        try
        {
            map.put(uQty,name);
            this.setP(map);
            return  true;

        }
        catch (Exception e)
        {
            System.out.println("Problem Map me hai");

       }
        return false;
    }

    public Map<Integer,String> userShowProduct(){
//        System.out.println("Map of product purchased in user class" + map);
        if(map.isEmpty()){
//            System.out.println("inside if map is empty Map of product purchased in user class" + map);
            System.out.println("\nNo Item Found InYour Cart");
        }
        else {
            return map;
        }

        return null;
    }
}
