package github2b2b.razzmatazz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ChooseCheese extends AppCompatActivity {

    ArrayList<Integer> tags = new ArrayList<>();

    //When a button is clicked..
    public void onClickCheese(View v){

        Integer curCheeseTag = Integer.parseInt(v.getTag().toString());             //Look at the tag of the item and find the corresponding tag in ingredient manager. **Ask Shane
        Cheese curCheese = IngredientManager.cheeseList.get(curCheeseTag);             //Create object

        if(((ToggleButton) v).isChecked()){
            //on
            tags.add(curCheeseTag);
            System.out.println(tags);
            Sandwich.sand.addIngredient(curCheese);
            Sandwich.sand.print();                                                     //Print contents of current sandwich ** Debug
        }else{
            //off
            tags.remove(curCheeseTag);
            System.out.println(tags);
            Sandwich.sand.removeIngredient(curCheese);                                 //Remove current ingredient (Button is not highlighted anymore)
            Sandwich.sand.print();                                                   //Print contents of current sandwich ** Debug
        }
    }

    public void nextPage(View v){
        Intent intent = new Intent(this, ChooseTopping.class);
        startActivity(intent);
    }

    public void backToPrev(View v){
        Sandwich.sand.removeIngredientsFromCheese(tags);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cheese);
        if(tags.size()!=0){
            tags.clear();
        }
        Intent intent = getIntent();
    }
}
