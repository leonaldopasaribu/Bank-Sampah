package com.example.banksampah.activity.user;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banksampah.R;
import com.example.banksampah.activity.admin.AdminActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    EditText Email, Password;
    Button LogInButton, RegisterButton, ButtonTest;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    FirebaseUser mUser;
    String email, password;
    ProgressDialog dialog;
    public static final String userEmail="";

    public static final String TAG="LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogInButton = (Button) findViewById(R.id.btnLogin);
        RegisterButton = (Button) findViewById(R.id.btnRegister);
        ButtonTest = (Button) findViewById(R.id.btnTest);

        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        dialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mUser != null) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Log.d(TAG,"AuthStateChanged:Logout");
                }

            }
        };

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSign();
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        ButtonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //removeAuthSateListner is used  in onStart function just for checking purposes,it helps in logging you out.
        mAuth.removeAuthStateListener(mAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListner != null) {
            mAuth.removeAuthStateListener(mAuthListner);
        }
    }

    @Override
    public void onBackPressed() {
        LoginActivity.super.finish();
    }

    private void userSign() {
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(LoginActivity.this, "Enter the correct Email", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "Enter the correct password", Toast.LENGTH_SHORT).show();
            return;
        } else if(Email.getText().toString().equals("admin") && Password.getText().toString().equals("admin")){
            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
            startActivity(intent);
        }
        dialog.setMessage("Loging in please wait...");
        dialog.setIndeterminate(true);
        dialog.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    dialog.dismiss();

                    Toast.makeText(LoginActivity.this, "Login not successfull", Toast.LENGTH_SHORT).show();

                } else {
                    dialog.dismiss();
                    checkIfEmailVerified();
                }
            }
        });
    }

    //This function helps in verifying whether the email is verified or not.
    private void checkIfEmailVerified(){
        FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
        boolean emailVerified=users.isEmailVerified();
        if(!emailVerified){
            Toast.makeText(this,"Verify the Email Id", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            finish();
        }
        //Intent to AdminActivity
        else if (Email.getText().equals("admin") && Password.getText().equals("admin")){
            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
            startActivity(intent);
        }
        else {
            Email.getText().clear();
            Password.getText().clear();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(userEmail, email);
            startActivity(intent);

        }
    }
}
