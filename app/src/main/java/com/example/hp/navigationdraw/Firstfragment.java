package com.example.hp.navigationdraw;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by hp on 27-12-2017.
 */

public class Firstfragment extends Fragment implements View.OnClickListener {
    View myView;
    //android.app.FragmentManager fragmentManager = this.getChildFragmentManager();
    // android.app.FragmentManager fragmentManagermain = getFragmentManager();
    //FragmentTransaction transaction = getChildFragmentManager().beginTransaction();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.home,container,false);
        ImageButton i1=(ImageButton)myView.findViewById(R.id.imageButton1),i2=(ImageButton)myView.findViewById(R.id.imageButton2),
                i3=(ImageButton)myView.findViewById(R.id.imageButton3),i4=(ImageButton)myView.findViewById(R.id.buttonclear),
                i5=(ImageButton)myView.findViewById(R.id.imageButton5),i6=(ImageButton)myView.findViewById(R.id.imageButton6),
                i7=(ImageButton)myView.findViewById(R.id.imageButton7),i8=(ImageButton)myView.findViewById(R.id.imageButton8),
                i9=(ImageButton)myView.findViewById(R.id.imageButton9),i10=(ImageButton)myView.findViewById(R.id.imageButton10),
                i11=(ImageButton)myView.findViewById(R.id.imageButton11);
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);
        i7.setOnClickListener(this);
        i8.setOnClickListener(this);
        i9.setOnClickListener(this);
        i10.setOnClickListener(this);
        i11.setOnClickListener(this);
        return myView;
    }





    @Override
    public void onClick(View v) {
        int id = v.getId();



        if (id == R.id.imageButton1)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new tulsi_home()).commit();
        }
        else if (id == R.id.imageButton2)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new ashwagandha_home()).commit();
        }
        else if (id == R.id.imageButton3)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new neem_home()).commit();
        }
        else if (id == R.id.buttonclear)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new lemon_home()).commit();
        }
        else if (id == R.id.imageButton5)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new ammabhji_home()).commit();
        }
        else if (id == R.id.imageButton6)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new niruri_home()).commit();
        }
        else if (id == R.id.imageButton7)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new nyct_home()).commit();
        }
        else if (id == R.id.imageButton8)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new psor_home()).commit();
        }
        else if (id == R.id.imageButton9)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new rauw_home()).commit();
        }
        else if (id == R.id.imageButton10)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new solnum_home()).commit();
        }
        else if (id == R.id.imageButton11)
        {
            getChildFragmentManager().beginTransaction().replace(R.id.f1, new trapa_home()).commit();
        }

    }
}
