package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.R;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
private List<AktivitasBelanja> aktivitasBelanjas = new ArrayList<>();

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shopping_activity,parent,false);
        return new MainHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        AktivitasBelanja current = aktivitasBelanjas.get(position);
        holder.textViewTitle.setText(current.getJudul_pembelian());
        holder.textViewItemName.setText(current.getBarang_pembelian().getNama());
        holder.textViewDate.setText(new SimpleDateFormat("dd.MM.yyyy").format(current.getTanggal_belanja()));
        holder.textViewStatus.setText(current.getStatus().name());
        new DownloadImageTask(holder).execute(current.getTempat_belanja().getImage_url());
        holder.textViewLocaleName.setText(current.getTempat_belanja().getNama());
    }

    @Override
    public int getItemCount() {
        return aktivitasBelanjas.size();
    }

    public void setAktivitasBelanjas(List<AktivitasBelanja> aktivitasBelanjas){
        this.aktivitasBelanjas = aktivitasBelanjas;
        notifyDataSetChanged();
    }

    class MainHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewItemName;
        private TextView textViewStatus;
        private TextView textViewDate;
        private ImageView imageViewLocaleImg;
        private TextView textViewLocaleName;

        public MainHolder (View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewItemName = itemView.findViewById(R.id.text_view_item_name);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            textViewStatus = itemView.findViewById(R.id.text_view_status);
            imageViewLocaleImg = itemView.findViewById(R.id.image_view_locale_img);
            textViewLocaleName = itemView.findViewById(R.id.text_view_locale_name);
        }
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

        private MainHolder mainHolder;

        private DownloadImageTask(MainHolder mainHolder){
            this.mainHolder = mainHolder;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        @Override
        protected void onPostExecute(Bitmap res) {
            mainHolder.imageViewLocaleImg.setImageBitmap(res);
        }
    }

}
