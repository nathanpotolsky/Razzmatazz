package github2b2b.razzmatazz;


import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by Katipo on 10/4/2015.
 */
public class Cart {

    static ArrayList<MenuItem> chosenItems = new ArrayList<>();
    public static Currency totalPrice;
    public static int orderNum = 0;
    public static int itemsInCart = 0;

    public static void checkOut(){
        //TODO: Display order on screen. Send order. Print recipt

        //Wipe Cart, and Sandwich. Increment Order Number and return to main menu. ??Write order to log??

    }

    public static void cancelOrder(){
        //TODO: empty chosenItems list. Clear totalPrice. Basically start the app over without actually doing that..
        if(chosenItems.size()!=0) {
            chosenItems.clear();
        }
        Sandwich.removeAllIngredients();


    }

    public static void addItem(MenuItem chosenItem){
        chosenItems.add(chosenItem);
        //TODO: Update totalPrice
    }

    public static void removeItem(MenuItem chosenItem){
        //Todo: Loop through, search for item in menu. When found, erase. Don't forget to use toString or something similar
    }






}
