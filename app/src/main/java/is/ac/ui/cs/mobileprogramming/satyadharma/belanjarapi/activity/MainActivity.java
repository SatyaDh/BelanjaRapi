package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.R;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addAktivitas;
    private final int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //portrait
        if (findViewById(R.id.layout_port ) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.list_frag, new ShoppingListFragment())
                    .commit();
        }
        //landscape
        else{
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.list_frag, new ShoppingListFragment())
                    .add(R.id.calendar_frag, new CalendarFragment())
                    .commit();
        }

        addAktivitas = findViewById(R.id.button_add_act);
        addAktivitas.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        } );


    }

    //asking for calendar permission
    private void requestPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CALENDAR)){
            //explanation as to why the permission is needed
            new AlertDialog.Builder(this)
                    .setTitle(R.string.perm_title)
                    .setMessage(R.string.perm_exp)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[] {Manifest.permission.READ_CALENDAR},
                                    CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_CALENDAR},
                    CODE);
        }
    }

    //move to another activity if confirmed
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CODE ){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permission granted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}