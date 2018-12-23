package com.example.hp.navigationdraw;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.util.Random;

/**
 * Created by hp on 27-12-2017.
 */

public class Thirdfragment extends Fragment implements View.OnClickListener {
    View myView;
    ImageButton ib1,ib2,ib3,ib4;
    Button b1,b2,b3,b4;
    private static final int a=123;
    private File imageFile;
  private FirebaseAuth firebaseAuth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.camera,container,false);
        ib1=(ImageButton)myView.findViewById(R.id.imageButton1);
        ib1.setOnClickListener(this);
        ib2=(ImageButton)myView.findViewById(R.id.imageButton2);
        ib2.setOnClickListener(this);
        ib3=(ImageButton)myView.findViewById(R.id.imageButton3);
        ib3.setOnClickListener(this);
        ib4=(ImageButton)myView.findViewById(R.id.buttonclear);
        ib4.setOnClickListener(this);
        b1=(Button)myView.findViewById(R.id.logout);
        b1.setOnClickListener(this);
        b2=(Button)myView.findViewById(R.id.Bmedicinal);
        b2.setOnClickListener(this);
        b3=(Button)myView.findViewById(R.id.Bfind);
        b3.setOnClickListener(this);
      firebaseAuth = FirebaseAuth.getInstance();

      //if the user is not logged in
      //that means current user will return null
      if(firebaseAuth.getCurrentUser() == null){
        Fragment fragment = null;
        fragment = new Secondfragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.f2, fragment);
        transaction.commit();
      }

      //getting current user
      FirebaseUser user = firebaseAuth.getCurrentUser();


        return myView;
    }

    @Override
    public void onClick(View v) {
        if(v==ib1||v==ib2||v==ib3||v==ib4)
        {

            Intent n = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "test.jpg");
            Uri tempuri = Uri.fromFile(imageFile);
            n.putExtra(MediaStore.EXTRA_OUTPUT, tempuri);
            n.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            startActivityForResult(n, 0);
          if (imageFile.exists()) {
            String fileName = imageFile.getAbsolutePath();
            BitmapFactory.Options opts = new BitmapFactory.Options();
            Bitmap bm;
            opts.inJustDecodeBounds = false;

            bm = BitmapFactory.decodeFile(fileName, opts);
            int intArray[] = new int[bm.getWidth()*bm.getHeight()];

            //copy pixel data from the Bitmap into the 'intArray' array
            bm.getPixels(intArray, 0, bm.getWidth(), 0, 0, bm.getWidth(), bm.getHeight());
            String s="";
            for(int i=0;i<intArray.length;i++)
              s=s+intArray[i];
            Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
          }
        }
        if(v==b1)
        {
          firebaseAuth.signOut();
          Fragment fragment = null;
          fragment = new Secondfragment();
          FragmentManager manager = getFragmentManager();
          FragmentTransaction transaction = manager.beginTransaction();
          transaction.replace(R.id.f2, fragment);
          transaction.commit();

        }
        if(v==b2)
        {
           Intent i=new Intent(getActivity(),Med_Info.class);
           startActivity(i);
        }
        if(v==b3)
        {
            Toast.makeText(getActivity(),"File is being processed,Please wait!!",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)
        {
            switch(resultCode)
            {
                case Activity.RESULT_OK:
                    if(imageFile.exists())
                    {
                        Toast.makeText(getActivity(),"The fle was saved at "+imageFile.getAbsolutePath(),Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity(),"There was an error",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
    }
}
