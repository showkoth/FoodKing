package com.example.showkot.foodking.Common;

import com.example.showkot.foodking.Model.User;



public class Common {
    public static User currentUser;
    public static final String DELETE = "Deletea";
    public static volatile Common uniqueObject;

    private Common(User user) {
        currentUser = user;
    }

    public static Common getUniqueObject(){
        if(uniqueObject==null){
            System.out.println("Before synchronized");
            synchronized (Common.class){
                if(uniqueObject == null){
                    uniqueObject = new Common(currentUser);
                    System.out.println("Object is created");
                }
            }
        }
        return uniqueObject;
    }

}
