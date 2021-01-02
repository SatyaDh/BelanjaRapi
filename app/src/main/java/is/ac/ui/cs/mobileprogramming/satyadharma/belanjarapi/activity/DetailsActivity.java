package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.R;

public class DetailsActivity extends AppCompatActivity{
    private TextView detailsTitle;
    private TextView detailsItemName;
    private TextView detailsLocationName;
    private TextView detailsDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_details);

        detailsTitle = findViewById(R.id.details_view_title);
        detailsItemName = findViewById(R.id.details_view_item_name);
        detailsLocationName = findViewById(R.id.details_view_location_name);
        detailsDate = findViewById(R.id.details_view_date);

        //call intent from ShoppingListFragment
        Intent intent = getIntent();

        if (intent.hasExtra("judul")){
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String date =  format.format((Date) intent.getSerializableExtra("tanggal"));

            detailsTitle.setText(intent.getStringExtra("judul"));
            detailsItemName.setText(intent.getStringExtra("barang"));
            detailsLocationName.setText(intent.getStringExtra("lokasi"));
            detailsDate.setText(date);

        }
    }

}
