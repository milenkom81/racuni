package DAO;

import moji_razredi.Podjetje;

public interface CompanyDao extends DaoCrud<Podjetje>  {
    public Podjetje getByDavcna(String code);
}
