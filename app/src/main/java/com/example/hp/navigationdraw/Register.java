package com.example.hp.navigationdraw;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class Register extends Fragment implements View.OnClickListener{

  android.app.FragmentManager fragmentManager = getFragmentManager();
  View myView;
  private Button bsignup,bclear;
  private EditText email;
  private EditText password;
  private ProgressDialog progressBar;
  private FirebaseAuth firebaseAuth;


  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    myView = inflater.inflate(R.layout.register, container, false);
    firebaseAuth = FirebaseAuth.getInstance();
    email=(EditText)myView.findViewById(R.id.editTextUNreg);
    password=(EditText)myView.findViewById(R.id.editTextPWreg);
    bsignup=(Button)myView.findViewById(R.id.buttonsigninreg);
    bsignup.setOnClickListener(this);
    bclear=(Button)myView.findViewById(R.id.buttonclearreg);
    bclear.setOnClickListener(this);

    progressBar = new ProgressDialog(getActivity());
    return myView;
  }

  private void registerUser(){
    String EMAIL = email.getText().toString().trim();
    String PASSWORD = password.getText().toString().trim();
    if(TextUtils.isEmpty(EMAIL)){
      Toast.makeText(getActivity(), "Please enter the email",Toast.LENGTH_SHORT).show();
      return;
    }
    if(TextUtils.isEmpty(PASSWORD)){
      Toast.makeText(getActivity(),"Please enter the Password",Toast.LENGTH_SHORT).show();
      return;
    }

    progressBar.setMessage("Registering User...");
    progressBar.show();

    firebaseAuth.createUserWithEmailAndPassword(EMAIL,PASSWORD)
      .addOnCompleteListener(getActivity(),new OnCompleteListener<AuthResult>(){
        public void onComplete(@NonNull Task<AuthResult> task ) {
          if (task.isSuccessful()) {
            Toast.makeText(getActivity(), "Registerd sucessfully", Toast.LENGTH_SHORT).show();
            progressBar.cancel();
          } else {
            //Toast.makeText(getActivity(), "Could not register", Toast.LENGTH_SHORT).show();
            FirebaseAuthException e = (FirebaseAuthException )task.getException();
            Toast.makeText(getActivity(), "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();

          }
        }

    });


  }
  @Override
  public void onClick(View v) {

    if(v == bsignup)
    {
      registerUser();
    }


  }
}
