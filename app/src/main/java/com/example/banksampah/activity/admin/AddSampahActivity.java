package com.example.banksampah.activity.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.banksampah.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class AddSampahActivity extends AppCompatActivity {
    //Firebase
    private DatabaseReference mDatabaseRef;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef  = storage.getReference();
    private Button chooseImg, uploadImg;
    ImageView imgView;
    int PICK_IMAGE_REQUEST = 111;
    Uri filePath;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sampah);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("JenisSampah");
        final EditText nameEdit = (EditText) findViewById(R.id.jenis_sampah);
        final EditText emailEdit = (EditText) findViewById(R.id.imageSampah);
        Button addBtn = (Button) findViewById(R.id.btnAdd);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                String email = emailEdit.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                } else {

                    DatabaseReference data = mDatabaseRef.push();
                    data.child("jenis").setValue(name);
                    data.child("image").setValue(email);

                    nameEdit.setText("");
                    emailEdit.setText("");
                }
            }
        });

//        chooseImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_PICK);
//                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
//            }
//        });
//
//        uploadImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(filePath != null) {
//                    pd.show();
//
//                    StorageReference childRef = storageRef.child("image.jpg");
//
//                    //uploading the image
//                    UploadTask uploadTask = childRef.putFile(filePath);
//
//                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            pd.dismiss();
//                            Toast.makeText(AddSampahActivity.this, "Upload successful", Toast.LENGTH_SHORT).show();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            pd.dismiss();
//                            Toast.makeText(AddSampahActivity.this, "Upload Failed -> " + e, Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//                else {
//                    Toast.makeText(AddSampahActivity.this, "Select an image", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            filePath = data.getData();
//
//            try {
//                //getting image from gallery
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
//
//                //Setting image to ImageView
//                imgView.setImageBitmap(bitmap);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
    }
}
