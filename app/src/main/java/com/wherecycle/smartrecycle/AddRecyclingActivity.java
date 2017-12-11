package com.wherecycle.smartrecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.wherecycle.smartrecycle.model.Locations;

import javax.microedition.khronos.egl.EGLDisplay;

public class AddRecyclingActivity extends AppCompatActivity {
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
                
                long DBLat = eLat.getText().;
                long DBLong = eLong.toString();

                Locations push = new Locations(DBName, DBLat, DBLong, DBContact);

            }
        });
    }
}
