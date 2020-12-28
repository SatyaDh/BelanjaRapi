package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.R;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.adapter.MainAdapter;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.viewmodel.AktivitasBelanjaViewModel;

public class ShoppingListFragment extends Fragment {
    private AktivitasBelanjaViewModel aktivitasBelanjaViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MainAdapter mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        aktivitasBelanjaViewModel = new ViewModelProvider(getActivity()).get(AktivitasBelanjaViewModel.class);
        aktivitasBelanjaViewModel.getAllAktivitasBelanja().observe(getActivity(), new Observer<List<AktivitasBelanja>>() {
            @Override
            public void onChanged(List<AktivitasBelanja> aktivitasBelanjas) {
                mainAdapter.setAktivitasBelanjas(aktivitasBelanjas);
            }
        });
        mainAdapter.SetOnActListener(new MainAdapter.OnActListener() {
            @Override
            public void onActClick(AktivitasBelanja aktivitasBelanja) {
                Intent intent = new Intent(getActivity(),DetailsActivity.class);
                intent.putExtra("judul", aktivitasBelanja.getJudul_pembelian());
                intent.putExtra("barang", aktivitasBelanja.getBarang_pembelian().getNama());
                intent.putExtra("lokasi", aktivitasBelanja.getTempat_belanja().getNama());
                intent.putExtra("tanggal", aktivitasBelanja.getTanggal_belanja());
                startActivity(intent);
            }

            @Override
            public void onTimerClick(AktivitasBelanja aktivitasBelanja) {

            }
        });

        return v;

    }
}
