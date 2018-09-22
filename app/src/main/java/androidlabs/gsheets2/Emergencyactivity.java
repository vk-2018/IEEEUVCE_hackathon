package androidlabs.gsheets2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import androidlabs.gsheets2.R;
//import androidlabs.gsheets2.ActionActivity;

public class Emergencyactivity extends AppCompatActivity
{
    EditText et1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

    }

    public void onClickEmergency(View view)
    {
        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);
    }

    public void onClickFather(View view)
    {
        //Intent in=getIntent();
//        Intent intent=getIntent();
//        String number = intent.getStringExtra(MainActivity.EXTRA);
        Intent inten=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(inten);
    }
    public void onClickMother(View view)
    {

        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);
    }
    public void onClickBrother(View view)
    {
        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);
    }
    public void onClickSister(View view)
    {
        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);

    }
    public void onClickAmbulance(View view)
    {
        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);

    }
    public void onClickHelpline(View view)
    {
        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);

    }
    public void onClickStalking(View view)
    {
        Intent intent=new Intent(Emergencyactivity.this,ActionActivity.class);
        startActivity(intent);
    }
}