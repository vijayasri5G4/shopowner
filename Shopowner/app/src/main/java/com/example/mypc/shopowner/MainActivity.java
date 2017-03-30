package com.example.mypc.shopowner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import android.app.ProgressDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class MainActivity extends AppCompatActivity {
    EditText userid,stores,stored;

    public ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid=(EditText) findViewById(R.id.editText4);
        stores=(EditText)findViewById(R.id.editText2);
        stored=(EditText)findViewById(R.id.editText3);
        progressDialog = new ProgressDialog(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReferenceFromUrl("https://products-e4ac8.firebaseio.com/shopper/");

    }
    public void ok(View view){

        DatabaseReference id=databaseReference.push();

        id.child("userid").setValue(userid.getText().toString());
        id.child("stores").setValue(stores.getText().toString());
        id.child("stored").setValue(stored.getText().toString());
    }

}
