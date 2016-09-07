package com.example.android.decodebodyidplates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[][] modelListings = {
            {"82211", "82311", "82411", "82611", "82811", "82911", "82369", "82469", "82569", "82869"},
            {"Torana (1200 or 1200S)", "Torana S (6cyl)", "Torana S (6cyl) or Deluxe 1200", "Torana SL (1200 or 1200S)",
                    "Torana Deluxe (1600)", "Torana GTR or XU-1 (6cyl)", "Torana S (6cyl)", "Torana S (6cyl) or Deluxe (OHV 4)",
                    "Torana SL (6cyl)", "Torana Deluxe 1600"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method runs when the checkPlate button is pressed.
    public void checkPlate(View view) {
        // This reads the id of the modelEditText view so we can extract the data entered by the user.
        EditText mmodelEditText = (EditText) findViewById(R.id.modelEditText);
        //This extracts the text, converts it to a String and stores it in the variable mModel.
        String mModelText = mmodelEditText.getText().toString();
        //This extracts the model (LC or LJ) from the inputs first 2 characters and stores it in mModelLCLJ
        //substring includes the start point but now the end point. So substring(0,2) includes char[0] and char[1] only.
        String mModelLCLJ = mModelText.substring(0, 2);
        //This extracts the model variant (2 door, 4 door, GTR, S, SL) from the input characters 2 to 6 and stores it in mModel
        String mModel = mModelText.substring(2, 7);
        /** TODO: 6/09/2016 This whole code needs to be expanded to accept the proper String from
         * the plate and then separate it into the style (LC or LJ) the body option (82911, 82311 etc)
         * and the suffix (which I need to check what it means
         */

        // This loop tests for a model code and finds the description of that model
        for (int i = 0; i < 10; i++) {
            if (mModel.equalsIgnoreCase(modelListings[0][i]))
                Toast.makeText(this, "It's an " + mModelLCLJ + " " + modelListings[1][i], Toast.LENGTH_SHORT).show();
        }

    }
}
