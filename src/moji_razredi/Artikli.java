package moji_razredi;


import java.util.ArrayList;
import java.util.List;



public class Artikli implements Searchable{

    private List<Artikel> seznamArtiklov;

    public Artikli() {
        this.seznamArtiklov = new ArrayList<>();
    }

    public List<Artikel> getSeznamArtiklov() {
        return seznamArtiklov;
    }

    public void setSeznamArtiklov(List<Artikel> seznamArtiklov) {
        this.seznamArtiklov = seznamArtiklov;
    }

    @Override
    public String toString() {
        return "Artikli{" +
                "seznamArtiklov=" + seznamArtiklov +
                '}';
    }

    public boolean search(String niz) {
        int isExists = this.toString().indexOf(niz);
        if (isExists >= 0){
            return true;
        }
        else{
            return false;
        }
    }


}
