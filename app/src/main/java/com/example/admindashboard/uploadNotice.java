package com.example.admindashboard;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class uploadNotice extends AppCompatActivity {
    private CardView noticeImage;
    private ImageView noticeImageView;
    //private EditText noticeTitle = findViewById(R.id.noticeTitle);
    //private Button uploadnotice=findViewById(R.id.noticeUpload);
    //private DatabaseReference DataReference;
    //private StorageReference storeReference;
    ActivityResultLauncher<String> showImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_notice);


        noticeImage = findViewById(R.id.addNotice);
        noticeImageView = findViewById(R.id.noticeImageView);
    //    DataReference= FirebaseDatabase.getInstance().getReference();
    //    storeReference= FirebaseStorage.getInstance().getReference();

        showImage = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                noticeImageView.setImageURI(result);
            }
        });
        noticeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage.launch("image/*");
            }
        });

//        uploadnotice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(noticeTitle.getText().toString().isEmpty()){
//                    noticeTitle.setError("Empty Title");
//                    noticeTitle.requestFocus();
//                }
//                else if(noticeImage==null){
//                    uploadData();
//                }
//                else{
//                    uploadImage();
//                }
//            }
//        });




    }

//    private void uploadImage() {
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        .compress(Bitmap.CompressFormat.JPEG,50,baos);
//    }
//
//    private void uploadData() {
//
//    }
}