package com.wherecycle.smartrecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wherecycle.smartrecycle.model.Locations;

import javax.microedition.khronos.egl.EGLDisplay;

public class AddRecyclingActivity extends ChildActivity {
    private DatabaseReference myDB;
    private EditText eName;
    private EditText eContact;
    private EditText eLat;
    private EditText eLong;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recycling);

        myDB = FirebaseDatabase.getInstance().getReference();


        eName = (EditText)findViewById(R.id.enterRName);
        eContact = (EditText)findViewById(R.id.enterRContact);
        eLat = (EditText)findViewById(R.id.enterRLat);
        eLong = (EditText)findViewById(R.id.enterRLong);

        submit = (Button)findViewById(R.id.submitRecycling);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String DBName = eName.getText().toString();
                String DBContact = eContact.getText().toString();
                String strLat = eLat.getText().toString();
                double DBLat = Double.parseDouble(strLat);
                String strLong = eLong.getText().toString();
                double DBLong = Double.parseDouble(strLong);

                Locations newRecycler = new Locations(DBName, DBLat, DBLong, DBContact);
                myDB.child("Recycling Centres").push().setValue(newRecycler);

                Intent intent = new Intent(AddRecyclingActivity.this, DBLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
