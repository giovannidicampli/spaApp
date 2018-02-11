package com.vanni.spaApp.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vanni.spaApp.models.Offerta;

import java.util.ArrayList;

public class ResultOfferte {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message = null;
    @SerializedName("offerte")
    @Expose
    private ArrayList<Offerta> offerta;

    public ArrayList<Offerta> getOfferte() {
        return offerta;
    }

    public void setOfferte(ArrayList<Offerta> offerta) { this.offerta = offerta; }

    public Boolean getResult() { return result; }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
