package com.example.hp.navigationdraw;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by hp on 28-12-2017.
 */

public class Fourthfragment extends Fragment {
    View myView;
    ViewFlipper vf;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.about_us, container, false);
        int images[]={R.drawable.cvsir,R.drawable.hodsir,R.drawable.raghunandan,R.drawable.radha,R.drawable.kvs,R.drawable.kini,R.drawable.jeppu,R.drawable.nayak};
        vf=(ViewFlipper)myView.findViewById(R.id.id1);
        int i;
        for(i=0;i<images.length;i++)
        {
            slide(images[i]);
        }
        return myView;
    }
    public void slide(int image){
        ImageView iv=new ImageView(getActivity());
        iv.setBackgroundResource(image);
        vf.setFlipInterval(2000);
        vf.addView(iv);
        vf.setAutoStart(true);
        vf.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        vf.setOutAnimation(getActivity(),android.R.anim.slide_out_right);

    }
}
