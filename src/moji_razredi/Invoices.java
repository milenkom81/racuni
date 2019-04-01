package moji_razredi;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Invoices {
    private List<Racun> seznamRacunov;

    public Invoices() {
        this.seznamRacunov = new ArrayList<>();
    }

    public List<Racun> getSeznamRacunov() {
        return seznamRacunov;
    }

    public void setSeznamRacunov(List<Racun> seznamRacunov) {
        this.seznamRacunov = seznamRacunov;
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "seznamRacunov=" + seznamRacunov +
                '}';
    }

    public String toJSON(){
        String json = new Gson().toJson(this);
        return json;

    }

    public <T> T fromJSON(String json){
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        Invoices target2 = gson.fromJson(json, this.getClass()); // deserializes json into target2
        return (T)target2;
    }

}
