package com.example.abhijeet.ablogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/* This program is developed by Abhijeet Das  on April 2018 under a vocational training by IMAD HASURA */
public class MainActivity extends AppCompatActivity {
      TextView textView;
      EditText editText;
      private static final String TAG ="Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textView = (TextView)findViewById(R.id.textview);
       editText =(EditText)findViewById(R.id.edittext);
        Button button=(Button)findViewById(R.id.button);
          // mak ethe button usable

           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // gets called when the button is clicked.................


                   Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_LONG).show();
                  String enteredText = editText.getText().toString().trim();
                    if(enteredText.isEmpty()){
                         //show an alert
                          showalert();
                   }
                      else {
                           //replace the string...
                          replaceText(enteredText);
                    }
               }
           });

        Log.i(TAG,"Inside Oncreate");
        }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void replaceText(String newText){
            textView.setText(newText);
            editText.setText("");
          }
       private void showalert()
       //building the dialog.........................................................
       {
           AlertDialog.Builder builder = new AlertDialog.Builder(this);
              builder.setTitle("Empty!");
              builder.setMessage("No string to replace");
              builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                  }
              });
              builder.show();
       }
}
