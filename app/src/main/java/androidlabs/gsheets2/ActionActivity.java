package androidlabs.gsheets2;




//ActionActivity

//package com.example.vatsc.mysafetyapp;

        import android.Manifest;
        import android.app.PendingIntent;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;
//        import androidlabs.gsheets2.R;

public class ActionActivity extends AppCompatActivity
{
    EditText et1,mssg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_activity);
        // et1=findViewById(R.id.ptCaller);

    }

    public void onClickCall(View view)
    {
        //Intent intent=getIntent();

        Toast.makeText(getApplicationContext(),"STARTING TO CALL....",Toast.LENGTH_SHORT).show();
        String number = "+919051807242";//et1.toString();
        //String number=intent.getStringExtra(MainActivity);
        Intent callintent = new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse("TEL No: "+number));
        callintent.putExtra(Intent.EXTRA_TEXT,number);
        startActivity(Intent.createChooser(callintent,"CALL VIA"));


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(getApplicationContext(),"COULD NOT GRANT PERMISSION",Toast.LENGTH_SHORT).show();
            return;
        }

    }

    public void onClickMssg(View view)
    {

        Toast.makeText(getApplicationContext(), "Sending SMS To the Person Concerned", Toast.LENGTH_SHORT).show();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"INSERT THE SUBJECT here");
        String app_url =  "I am in Danger, please Help";
        shareIntent.putExtra(Intent.EXTRA_TEXT,app_url);
        startActivity(Intent.createChooser(shareIntent,"SHARE VIA"));

        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                Toast.LENGTH_LONG).show();
    }

//    public void onClickMssg(View view)
//    {
//        Intent intent =new Intent(this,CallerActivity.class);
//        startActivity(intent);
//    }


}
