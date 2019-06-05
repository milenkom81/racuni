package DAO;

import moji_razredi.Artikel;

public interface ArticleDao extends DaoCrud<Artikel> {
     Artikel getByBarcode(String code);
}