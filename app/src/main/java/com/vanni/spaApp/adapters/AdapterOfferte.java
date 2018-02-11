package com.vanni.spaApp.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vanni.spaApp.MainActivity;
import com.vanni.spaApp.R;
import com.vanni.spaApp.fragments.OffertaFragment;
import com.vanni.spaApp.models.Offerta;

import java.util.List;

public class AdapterOfferte extends RecyclerView.Adapter<AdapterOfferte.ViewHolder>{

    private List<Offerta> listaOfferta;
    private Context context;

    //Creato dal fragment
    public AdapterOfferte(List<Offerta> listaOfferta, Context context) {
        this.listaOfferta = listaOfferta;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_offerte, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Offerta offerte = listaOfferta.get(position);

        holder.textViewNome.setText(offerte.getNome());
        holder.textViewdataInizio.setText(offerte.getDataInizio());
        holder.textViewdataFine.setText(offerte.getDataFine());
        holder.textViewPrezzo.setText(offerte.getPrezzo());


    }

    @Override
    public int getItemCount() {
        return listaOfferta.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNome, textViewdataInizio, textViewdataFine, textViewPrezzo;
        public CardView cardViewOfferte;



        public ViewHolder(View itemView) {
            super(itemView);

            textViewNome = itemView.findViewById(R.id.textViewNomeOfferta);
            textViewdataInizio = itemView.findViewById(R.id.textViewDataInizio);
            textViewdataFine = itemView.findViewById(R.id.textViewDataFine);
            textViewPrezzo = itemView.findViewById(R.id.textViewPrezzo);

            cardViewOfferte = itemView.findViewById(R.id.cardViewOfferte);

            //Creo un generico OffertaFragment relativo all'offerta su cui "tappo"
            cardViewOfferte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = ((MainActivity)context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    String nome = textViewNome.getText().toString();


                    OffertaFragment offertaFragment = new OffertaFragment();
                    offertaFragment.setNome(nome);
                    fragmentTransaction.replace(R.id.fragment_container, offertaFragment).commit();
                }
            });

        }

    }
}
