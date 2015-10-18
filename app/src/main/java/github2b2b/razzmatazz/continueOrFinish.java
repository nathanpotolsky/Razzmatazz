package github2b2b.razzmatazz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class continueOrFinish extends AppCompatActivity {

    public void onClickSubmit(){

    }


     public void onClickAddMore(){
         Intent intent = new Intent(this, ChooseBread.class);
         startActivity(intent);
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_or_finish);
    }
}
