package com.example.admindashboard;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {
    EditText regisName,regisUsername,regisEmail,regisClassid,regisPass,regisPhone;
    Button regisBtn;
    CardView image;
    ImageView viewPlace;

    ActivityResultLauncher<String> showImage;
    FirebaseDatabase dataConnect;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        image=findViewById(R.id.addimage);
        viewPlace=findViewById(R.id.ViewPhoto);

        regisBtn=findViewById(R.id.signInbtn);
        regisName=findViewById(R.id.full_name);
        regisUsername=findViewById(R.id.user_name);
        regisEmail=findViewById(R.id.email);
        regisClassid=findViewById(R.id.classs_id);
        regisPhone=findViewById(R.id.phone_no);
        regisPass=findViewById(R.id.password);

        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataConnect=FirebaseDatabase.getInstance();
                reference=dataConnect.getReference("users");

                String name=regisName.getText().toString();
                String username=regisUsername.getText().toString();
                String email=regisEmail.getText().toString();
                String phone=regisPhone.getText().toString();
                String classID=regisClassid.getText().toString();
                String password=regisPass.getText().toString();

                regisData dataCollect=new regisData(name,username,email,phone,classID,password);

                reference.child(classID).setValue(dataCollect);
                Intent btnIntent=new Intent(registration.this,MainActivity.class);
                startActivity(btnIntent);
            }
        });

        showImage=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                viewPlace.setImageURI(result);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage.launch("image/*");
            }
        });
    }
}