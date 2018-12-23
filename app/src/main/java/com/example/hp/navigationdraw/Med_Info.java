package com.example.hp.navigationdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.Random;

public class Med_Info extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_med__info);
    PDFView pdfV= (PDFView)findViewById(R.id.pdfView);
    int random = new Random().nextInt(7);
    String s="Plant"+random+".pdf";
    pdfV.fromAsset(s).load();
  }
}
