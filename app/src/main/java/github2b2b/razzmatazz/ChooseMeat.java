package github2b2b.razzmatazz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class ChooseMeat extends AppCompatActivity {

    //When a button is clicked...
    public void onClickMeat(View v){

        int curMeatTag = Integer.parseInt(v.getTag().toString());             //Look at the tag of the item and find the corresponding tag in ingredient manager. **Ask Shane

        Meat curMeat = IngredientManager.meatList.get(curMeatTag);             //Create object

        if(((ToggleButton) v).isChecked()){
            //on
            Sandwich.addIngredient(curMeat);                                    //set the bread type for the sandwich **Ask Shane
            Sandwich.print();                                                   //Print contents of current sandwich ** Debug
        }else{
            //off
            Sandwich.removeIngredient(curMeat);                                 //Remove current ingredient (Button is not highlighted anymore)
            Sandwich.print();                                                   //Print contents of current sandwich ** Debug
        }

    }

    //Advance to next page
    public void nextPage(View v){

        Intent intent = new Intent(this, ChooseCheese.class);
        startActivity(intent);
    }

    //Return to Previous page
    public void backToPrev(View v){

        Sandwich.removeAllIngredients();                    //wipe all ingredients.
        super.onBackPressed();
    }

    //When the exit button is clicked, activity will go back to start screen.
    public void exitToStart(View v){
        for(MenuItem m : Cart.chosenItems){
            Log.i("predelete:", m.itemName);
        }
        Cart.cancelOrder();                    //Clear the cart and the current sandwich if applicable
        Sandwich.removeAllIngredients();

        for(MenuItem m : Cart.chosenItems){
           Log.i("post delete:", m.itemName);
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_meat);

        Intent intent = getIntent();
    }
}
