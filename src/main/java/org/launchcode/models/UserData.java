package org.launchcode.models;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    //add
    public static void add(User newUser) {
        users.add(newUser);
    }


    //get all
    public static ArrayList<User> getAll() {
        return users;
    }

    //get by Id
    public static User getById(int userID) {

        User theUser = null;

        for (User candidateUser : users) {
            if (candidateUser.getUserID() == userID) {
                theUser = candidateUser;
            }
        }

        return theUser;
    }

}
