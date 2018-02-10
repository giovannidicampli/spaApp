package com.vanni.spaApp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offerta {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("dataInizio")
    @Expose
    private String dataInizio;
    @SerializedName("dataFine")
    @Expose
    private String dataFine;
    @SerializedName("descrizione")
    @Expose
    private String descrizione;
    @SerializedName("prezzo")
    @Expose
    private String prezzo;


    public Offerta(String nome, String dataInizio, String dataFine, String descrizione, String prezzo) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.descrizione = descrizione;
        this.prezzo = prezzo;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getDescrizione() { return descrizione; }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }
}
