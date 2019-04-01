package moji_razredi;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Companies implements JsonSupport {
    private List<Podjetje> seznamPodjetji;

    public Companies() {
        this.seznamPodjetji = new ArrayList<>();
    }

    public List<Podjetje> getSeznamPodjetji() {
        return seznamPodjetji;
    }

    public void setSeznamPodjetji(List<Podjetje> seznamPodjetji) {
        this.seznamPodjetji = seznamPodjetji;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "seznamPodjetji=" + seznamPodjetji +
                '}';
    }

    public String toJSON(){
        String json = new Gson().toJson(this);
        return json;

    }

    public <T> T fromJSON(String json){
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        Companies target2 = gson.fromJson(json, this.getClass()); // deserializes json into target2
        return (T)target2;
    }


}
