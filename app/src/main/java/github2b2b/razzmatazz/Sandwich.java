package github2b2b.razzmatazz;

import java.util.ArrayList;

/**
 * Created by Katipo on 10/4/2015.
 */
public class Sandwich {

    public static ArrayList<Ingredient> ingredientList = new ArrayList<>();
    public static ArrayList<Ingredient> includedIngredients = new ArrayList<>();       //If the sandwhich has included ingredients, do things with stuff
    public static Bread breadType;


    //add all items from included ingredient list to ingredient list.
    public static void addIncludedIngredient(){
        ingredientList.addAll(includedIngredients);
        //TODO: Buttons will have to be depressed.
    }

    //Adds single ingredient
    public static void addIngredient(Ingredient givenIngredient){
        //if Toggle button is pressed
        ingredientList.add(givenIngredient);
    }

    //Removes single ingredient
    public static void removeIngredient(Ingredient ingredient){
        //if Toggle button is depressed
        System.out.println("To Be removed: "+ingredient.getIngredientName());
        ingredientList.remove(ingredient);

    }

    //TODO: SWITCH TO CHECK IF CHEESE OR TOPPING, then remove accordingly


    public static void removeIngredientsFromCheese(ArrayList<Integer> tagNum){

        if(tagNum.size()!=0) {

            for (int i = 0; i < tagNum.size(); i++) {
                Cheese curCheese = IngredientManager.cheeseList.get(tagNum.get(i));

                ingredientList.remove(curCheese);

            }
            Sandwich.print();

        }

    }
    public static void removeIngredientsFromTopping(ArrayList<Integer> tagNum){

        if(tagNum.size()!=0) {

            for (int i = 0; i < tagNum.size(); i++) {
                Topping curTopping = IngredientManager.toppingList.get(tagNum.get(i));

                ingredientList.remove(curTopping);

            }
            Sandwich.print();

        }

    }

    public static void print(){
       System.out.println("-------------------------------------------------------------------------");
       System.out.println("Current Bread Is: " + breadType.getIngredientName());
        for(int i =0; i < ingredientList.size(); i ++){
            System.out.println(" Current Ingredient = " + ingredientList.get(i).getIngredientName());
        }
    }



    //Wipes the ingredientList and returns breadType to null
    public static void removeAllIngredients(){
        if(ingredientList.size()!=0) {
            ingredientList.clear();
        }
        breadType = null;
    }


}
