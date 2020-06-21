package com.personal.DonateApp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEditUsername;
    private EditText mEditEmail;
    private EditText mEditPassword;
    private Button mBtnEnter;
    private Button mBtnSelectedPhoto;
    private ImageView mImgPhoto;
    private Uri mSelecedUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEditUsername =  findViewById(R.id.edit_username);
        mEditEmail =  findViewById(R.id.edit_email);
        mEditPassword =  findViewById(R.id.edit_password);
        mBtnEnter =  findViewById(R.id.btn_enter);
        mBtnSelectedPhoto =  findViewById(R.id.btn_selected_photo);
        mImgPhoto =  findViewById(R.id.img_photo);

        mBtnSelectedPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPhoto();
            }
        });

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0){
            mSelecedUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                mImgPhoto.setImageBitmap(bitmap);
                mBtnSelectedPhoto.setAlpha(0);
            } catch (IOException e) {
            }

        }

    }

    public void selectPhoto(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);

    }

    public void createUser(){

        String nome = mEditUsername.getText().toString();
        String email = mEditEmail.getText().toString();
        String senha = mEditPassword.getText().toString();

        if(nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty()){
            Toast.makeText(this,"Nome, email e senha devem ser preenchidos",Toast.LENGTH_SHORT).show();
            return;
        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.i("teste",task.getResult().getUser().getUid());

                                saveUserInFirebase();

                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.i("teste",e.getMessage());
                        }
                    });
        }

    }

    public void saveUserInFirebase(){

            String filename = UUID.randomUUID().toString();
            final StorageReference ref  = FirebaseStorage.getInstance().getReference("/images/" + filename);
            ref.putFile(mSelecedUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Log.i("Teste", uri.toString());

                                    String uid = FirebaseAuth.getInstance().getUid();
                                    String username  = mEditUsername.getText().toString();
                                    String profileUrl  = uri.toString();

                                    mUser user = new mUser(uid, username, profileUrl);

                                    FirebaseFirestore.getInstance().collection("users")
                                            .document(uid)
                                            .set(user)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Intent intent = new Intent(RegisterActivity.this, MessagesActivity.class);

                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                                    startActivity(intent);
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Log.i("Teste", e.getMessage());
                                                }
                                            });
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("Teste", e.getMessage());
                }
            });
        }

}
