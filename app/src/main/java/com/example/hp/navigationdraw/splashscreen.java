package com.example.hp.navigationdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splashscreen);
    Thread welcomeThread = new Thread() {

      @Override
      public void run() {
        try {
          super.run();
          sleep(1000);  //Delay of 10 seconds
        } catch (Exception e) {

        } finally {

          Intent i = new Intent(splashscreen.this,
            MainActivityIntro.class);
          startActivity(i);
          finish();
        }
      }
    };
    welcomeThread.start();

  }
}
