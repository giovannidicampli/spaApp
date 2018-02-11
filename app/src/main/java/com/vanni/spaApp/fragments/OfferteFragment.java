package com.vanni.spaApp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vanni.spaApp.R;
import com.vanni.spaApp.adapters.AdapterOfferte;
import com.vanni.spaApp.api.APIService;
import com.vanni.spaApp.models.Offerta;
import com.vanni.spaApp.results.ResultOfferte;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vanni.spaApp.api.APIUrl.BASE_URL;

public class OfferteFragment extends Fragment {

    private RecyclerView recyclerViewOfferte;
    private RecyclerView.Adapter adapter;
    SwipeRefreshLayout swipeOfferte;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offerte, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.offerte);

        recyclerViewOfferte = getView().findViewById(R.id.recyclerViewOfferte);
        recyclerViewOfferte.setHasFixedSize(true);
        recyclerViewOfferte.setLayoutManager(new LinearLayoutManager(getContext()));

        loadOfferte();

        swipeOfferte = getView().findViewById(R.id.swipeOfferte);

        swipeOfferte.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeOfferte.setRefreshing(true);

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipeOfferte.setRefreshing(false);
                        loadOfferte();
                    }
                },100);
            }
        });
    }

    private void loadOfferte() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getContext().getResources().getString(R.string.load));
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<ResultOfferte> call = service.getOfferte();

        call.enqueue(new Callback<ResultOfferte>() {
            @Override
            public void onResponse(Call<ResultOfferte> call, Response<ResultOfferte> response) {
                progressDialog.dismiss();

                ArrayList<Offerta> offerta = response.body().getOfferte();

                adapter = new AdapterOfferte(offerta, getContext());
                recyclerViewOfferte.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResultOfferte> call, Throwable t) {

            }
        });
    }
}
