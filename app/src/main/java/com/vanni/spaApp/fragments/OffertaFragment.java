package com.vanni.spaApp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vanni.spaApp.R;
import com.vanni.spaApp.api.APIService;
import com.vanni.spaApp.models.Offerta;
import com.vanni.spaApp.results.ResultOfferta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vanni.spaApp.api.APIUrl.BASE_URL;

public class OffertaFragment extends Fragment {

    TextView textViewNome, textViewDataInizio, textViewDataFine, textViewDescrizione, textViewPrezzo;
    SwipeRefreshLayout swipeOfferta;
    String nome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offerta, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.offerta);

        textViewNome = getView().findViewById(R.id.textViewNomeOfferta);
        textViewDataInizio = getView().findViewById(R.id.textViewDataInizio);
        textViewDataFine = getView().findViewById(R.id.textViewDataFine);
        textViewDescrizione = getView().findViewById(R.id.textViewDescrizione);
        textViewPrezzo = getView().findViewById(R.id.textViewPrezzo );

        loadOfferta();

        swipeOfferta = getView().findViewById(R.id.swipeOfferta);

        swipeOfferta.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeOfferta.setRefreshing(true);

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipeOfferta.setRefreshing(false);
                        loadOfferta();
                    }
                }, 100);
            }
        });
    }

    private void loadOfferta() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getContext().getResources().getString(R.string.load));
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<ResultOfferta> call = service.getOfferta(nome);

        call.enqueue(new Callback<ResultOfferta>() {
            @Override
            public void onResponse(Call<ResultOfferta> call, Response<ResultOfferta> response) {
                progressDialog.dismiss();

                String nome = response.body().getOfferta().getNome();
                String dataInizio = response.body().getOfferta().getDataInizio();
                String dataFine = response.body().getOfferta().getDataFine();
                String descrizione = response.body().getOfferta().getDescrizione();
                String prezzo = response.body().getOfferta().getPrezzo();

                Offerta offerta = new Offerta(nome, dataInizio, dataFine, descrizione, prezzo);

                textViewNome.setText(offerta.getNome());
                textViewDataInizio.setText(offerta.getDataInizio());
                textViewDataFine.setText(offerta.getDataFine());
                textViewDescrizione.setText(offerta.getDescrizione());
                String euro = "€";
                textViewPrezzo.setText(offerta.getPrezzo() + euro);
            }

            @Override
            public void onFailure(Call<ResultOfferta> call, Throwable t) {

            }
        });
    }



    public void setNome(String nome) {
        this.nome = nome;
    }
}
