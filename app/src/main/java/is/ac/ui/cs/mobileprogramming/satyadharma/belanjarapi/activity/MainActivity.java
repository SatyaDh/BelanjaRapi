package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.R;

public class MainActivity extends AppCompatActivity {

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

    }


}