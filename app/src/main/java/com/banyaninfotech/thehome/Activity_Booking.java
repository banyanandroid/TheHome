package com.banyaninfotech.thehome;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by User on 7/19/2016.
 */
public class Activity_Booking extends Activity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    String[] List_room = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] List_Adults = {"1", "2", "3"};
    String[] List_Childs = {"1", "2"};

    ImageView img_back;

    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        findViewById(R.id.booking_btn_proceed).setOnClickListener(this);
        findViewById(R.id.bookroom_img_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.booking_btn_proceed:

                Intent i = new Intent(Activity_Booking.this, Activity_Checkout.class);
                startActivity(i);
                finish();
                break;

            case R.id.bookroom_img_back:

                Intent j = new Intent(Activity_Booking.this, Activity_Select_Rooms.class);
                startActivity(j);
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()) {

            this.moveTaskToBack(true);
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();

        }
        back_pressed = System.currentTimeMillis();
    }
}
