package com.example.hp.navigationdraw;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by hp on 27-12-2017.
 */

public class Secondfragment extends Fragment implements View.OnClickListener{
    View myView;

    EditText e1,e2;
    TextView tv1;
    Button b1,b2;

  private ProgressDialog progressDialog;
  private FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.login,container,false);
        e1=(EditText)myView.findViewById(R.id.editTextUN);
        e2=(EditText)myView.findViewById(R.id.editTextPW);
        b1=(Button)myView.findViewById(R.id.buttonsignin);
        b1.setOnClickListener(this);
        b2=(Button)myView.findViewById(R.id.buttonclear);
        b2.setOnClickListener(this);
        tv1=(TextView)myView.findViewById(R.id.textView9);
        tv1.setOnClickListener(this);
      firebaseAuth = FirebaseAuth.getInstance();
      if(firebaseAuth.getCurrentUser() != null){
        Fragment fragment = null;
        fragment = new Thirdfragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.f2, fragment);
        transaction.commit();
      }
      progressDialog = new ProgressDialog(getActivity());
        return myView;


    }

  private void signinUser(){
    final String email = e1.getText().toString().trim();
    final String password  = e2.getText().toString();
    //getting email and password from edit texts


    //checking if email and passwords are empty
    if(TextUtils.isEmpty(email)){
      Toast.makeText(getActivity(),"Please enter email",Toast.LENGTH_LONG).show();
      return;
    }

    if(TextUtils.isEmpty(password)){
      Toast.makeText(getActivity(),"Please enter password",Toast.LENGTH_LONG).show();
      return;
    }

    //if the email and password are not empty
    //displaying a progress dialog

    progressDialog.setMessage("Registering Please Wait...");
    progressDialog.show();


    firebaseAuth.signInWithEmailAndPassword(email, password)
      .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
          //checking if success
          if(task.isSuccessful()){
            Fragment fragment = null;
            fragment = new Thirdfragment();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.f2, fragment);
            transaction.commit();
            Toast.makeText(getActivity(),"Logged in",Toast.LENGTH_LONG).show();
          }
          else{
            //display some message here
            FirebaseAuthException e = (FirebaseAuthException )task.getException();
            Toast.makeText(getActivity(), "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
          }
          progressDialog.dismiss();
        }
      });

  }
    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v == tv1)
        {
          fragment = new Register();
          FragmentManager manager = getFragmentManager();
          FragmentTransaction transaction = manager.beginTransaction();
          transaction.replace(R.id.f2, fragment);
          transaction.commit();
        }
        else if(v==b1)
        {
          signinUser();
        }


    }
}
