package github2b2b.razzmatazz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ChooseTopping extends AppCompatActivity {

    ArrayList<Integer> tags = new ArrayList<>();

    public void onClickTopping(View v){

        Integer curToppingTag = Integer.parseInt(v.getTag().toString());             //Look at the tag of the item and find the corresponding tag in ingredient manager. **Ask Shane
        Topping curTopping = IngredientManager.toppingList.get(curToppingTag);             //Create object

        if(((ToggleButton) v).isChecked()){
            //on
            tags.add(curToppingTag);
            System.out.println(tags);
            Sandwich.sand.addIngredient(curTopping);
            Sandwich.sand.print();                                                     //Print contents of current sandwich ** Debug
        }else{
            //off
            tags.remove(curToppingTag);
            System.out.println(tags);
            Sandwich.sand.removeIngredient(curTopping);                                 //Remove current ingredient (Button is not highlighted anymore)
            Sandwich.sand.print();                                                   //Print contents of current sandwich ** Debug
        }

    }

    public void onClickCompleteSandwich(View v){

        Cart.addItem(Sandwich.sand);                        //add static sandwich instance to cart
        Sandwich.sand.removeAllIngredients();               //wipe the temp sandwich object

        Intent intent = new Intent(this, continueOrFinish.class);  //change when new class is implemented
        startActivity(intent);
    }

    public void backToPrev(View v){
        Sandwich.sand.removeIngredientsFromTopping(tags);
        super.onBackPressed();
    }

    //When the exit button is clicked, activity will go back to start screen.
    public void exitToStart(View v){
        for(MenuItem m : Cart.chosenItems){
            Log.i("predelete:", m.itemName);
        }
        Cart.cancelOrder();                    //Clear the cart and the current sandwich if applicable
        Sandwich.sand.removeAllIngredients();
        for(MenuItem m : Cart.chosenItems){
            Log.i("post delete:", m.itemName);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }






    ////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_topping);
        if(tags.size()!=0){
            tags.clear();
        }
        Intent intent = getIntent();
    }
}
