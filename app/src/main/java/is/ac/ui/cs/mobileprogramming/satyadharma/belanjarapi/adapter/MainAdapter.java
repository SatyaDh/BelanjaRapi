package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
private OnActListener listener;

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
        if (checkConnection(holder.imageViewLocaleImg.getContext())) {
            new DownloadImageTask(holder).execute(current.getTempat_belanja().getImage_url());
        }
        else {
            Context context = holder.imageViewLocaleImg.getContext();
            CharSequence text = "No internet connection, cannot load file!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
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

    class MainHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewItemName;
        private TextView textViewStatus;
        private TextView textViewDate;
        private ImageView imageViewLocaleImg;
        private TextView textViewLocaleName;
        private Button detailsButton;
        private Button timerButton;

        public MainHolder (View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewItemName = itemView.findViewById(R.id.text_view_item_name);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            textViewStatus = itemView.findViewById(R.id.text_view_status);
            imageViewLocaleImg = itemView.findViewById(R.id.image_view_locale_img);
            textViewLocaleName = itemView.findViewById(R.id.text_view_locale_name);
            detailsButton = itemView.findViewById(R.id.button_details);
            timerButton = itemView.findViewById(R.id.button_start_timer);

            detailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onActClick(aktivitasBelanjas.get(position));
                    }
                }
            });
            timerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onTimerClick(aktivitasBelanjas.get(position));
                    }
                }
            });


        }

    }

    public interface OnActListener{
        void onActClick (AktivitasBelanja aktivitasBelanja);
        void onTimerClick(AktivitasBelanja aktivitasBelanja);
    }

    public void SetOnActListener(OnActListener listener){
        this.listener = listener;
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

    public boolean checkConnection (Context context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }



}
