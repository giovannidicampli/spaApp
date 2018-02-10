package com.vanni.spaApp.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vanni.spaApp.models.Offerta;

public class ResultOfferta {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("offerta")
    @Expose
    private Offerta offerta;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Offerta getOfferta() {
        return offerta;
    }

    public void setOfferta(Offerta offerta) {
        this.offerta = offerta;
    }
}
