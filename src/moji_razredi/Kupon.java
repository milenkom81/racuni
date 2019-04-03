package moji_razredi;

public class Kupon {
    private String eanKupon;
    private int procent;
    public Kupon(String eanKupon) {
        this.eanKupon = eanKupon;
        String procenti = this.getEanKupon().substring(8,10);
        int result = Integer.parseInt(procenti);
        this.setProcent(result);
    }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public String getEanKupon() {
        return eanKupon;
    }

    public void setEanKupon(String eanKupon) {
        this.eanKupon = eanKupon;

    }
}


//Vaja 3.3 (neobvezna)
//        V aplikaciji podprite kupone za popust (npr. 10% na celotni nakup). Kupon
//        prepoznamo na podlagi ˇcrtne kode, ki se priˇcne z 99. Razmislite kaj vse bi
//        lahko ˇse bilo zapisano v ˇcrtni kodi kupona (tip, veljavnost...). Ustvarite vsaj
//        tri razliˇcne kupone in demonstrirajte delovanje. Ne pozabite popraviti izpis na
//        raˇcunu.