# Vaje 2018/

## 6. maj 2019

## Vodenje racunov

Napiˇsite vse potrebne razrede, pripadajoˇce metode, ki omogoˇcajo posamezno
funkcionalnost.
Ne pozabite da omogoˇcite: dodajanje, brisanje in popravljanje.

## Vaja 1.1

Cilj prve vaje je podpreti vnos posameznega raˇcuna. Ker so na raˇcunu razliˇcne
postavke (artikli, storitve) moramo imeti tudi seznam le-teh. V tej vaji ˇse ne
bomo shranjevali ali brali podatkov iz diska. Izdelajte predstavitev v pomnil-
niku, ki bo vsebovala minimalno ˇstevilo razredov:

- Artikel (ime, cena).
- Artikli (vsebuje seznam vseh artiklov na raˇcunu).
- Raˇcun (id, datum, seznam artiklov z njihovo ceno in koliˇcino).
Razmislite, kako bi implementirali skupni znesek raˇcuna. Smiselno uporabite
doloˇcila private, protected, public.
Ali za znesek uporabiti int ali double?
Kaj je ID? Kako ga implementirati?
Kaj je EAN koda? Ali je primerna za primarni kljuˇc? Vaˇsa aplikacija naj
vkljuˇcuje EAN kodo (dopolnite).
Poiˇsˇcite in slikajte vsaj dva raˇcuna razliˇcnih izdajateljev.

## Vaja 1.2

Prilagodi razred raˇcun tako, da bo v skladu z izbranim raˇcunom.

- Artiklom dodajte lastnost, davˇcna stopnja (na spletu preverite katere ve-
    ljajo v Sloveniji).
- Vodite seznam raˇcunov.
-Ali je smiselno uvesti ˇcasovno znaˇcko na nivoju artikla na raˇcunu?


## Vaja 2.1


Za vajo imate ˇcas dva tedna.Ce vajo zagovorite prvi teden (18.3.2019 - 22.3.2019),ˇ
lahko dobit vse pike.Ce zagovarjate po 22.3.2019 se vaji odbije ena pika. Enakoˇ
velja za neobvezne naloge.

Objavite vso vaˇso kodo na poljuben repozitorij (primer za GitHub). Po
potrebi dopolnite razred Raˇcun, da bo vseboval:

- izdajatelj,
- datum,
- (unikatna) ˇstevilka raˇcuna in
- davˇcna ˇstevilka kupca oziroma naroˇcnika (ID ˇstevilka za DDV podjetja).
- ime,
- davˇcna ˇstevilka,
- matiˇcna ˇstevilka in
- je davˇcni zavezanec.


Ustvarite vmesnik (interface) Searchable, ki ima metodo search. Metoda
prejme String in vrne boolean. Razredi Artikel, Podjetje in Raˇcun naj im-
plementirajo vmesnik Searchable. Metoda search vrne true, ˇce objekt vsebuje
podan String v katerikoli instanˇcni spremenljivki.
Ustvarite objekte po zgledu vaˇsih izbranih raˇcunov in treh poljubnih podjetij.
Vsi objekti se naj kreirajo ob zagonu aplikacije (hard-coded). Ustvarite vsaj
en original raˇcun (ima davˇcno ˇstevilko podjetja). Na raˇcunu preverite ali je
podjetje davˇcni zavezanec.

## Vaja 2.2


Razredu Artikel dodajte statiˇcno metodo checkDigit, ki prejme ˇcrtno kodo
vkljuˇcno s kontrolna ˇstevilko (check digit) in vrne boolean. Metoda naj pre-
veri ali je ˇcrtna koda veljavna (izraˇcun). Pri testiranju si lahko pomagate s
kalkulatorjem. Povozite metodo toString(), tako da bo izpis ˇcim bolj podoben
vaˇsem izbranem raˇcunu.

## Vaja 2.3 (neobvezna)

Razredu Artikel dodajte ˇse drˇzavo. Pri dodajanju artikla “izluˇsˇcite” drˇzavo iz
ˇcrtne kode. Ali imajo vse ˇcrtne kode drˇzavo?


## Vaja 3.1

Po 5.4.2019 se vaja zagovarja za poloviˇcno ˇstevilo pik!

Dodajte razred (Invoices), ki ima seznam raˇcunov in Companies, ki ima
seznam podjetij. V projektu podprite shranjevanje in branje iz JSON dato-
tek. Ustvarite vmesnik JsonSupport, ki ima metodi toJson (vrne JSON string)
in fromJson (prejme JSON string). Razredi Invoices, Companies in Articles
(Artikli) naj implementirajo vmesnik JsonSupport. Za parsanje in generiranje
JSON stringov lahko uporabite knjiˇznico Gson. Dodajte razred Helper, ki vse-
buje samo statiˇcne metode. Dodajte metodi za branje in pisanje datotek in ju
uporabite za pisanje/branje JSON stringov v datoteke.

## Vaja 3.2

Prodajalci lahko doloˇcijo interno ˇcrtno kodo za sveˇzo hrano (zelenjava, meso,
sadje, pekarski izdelki...). Za interno vodenje artiklov je po standardu v ˇcrtni
kodi rezerviranih zaˇcetnih nekaj ˇstevil (200 - 299). Cena teh artiklov je odvisna
od njihove teˇze. V aplikaciji podprite interno vodenje ˇcrtnih kod. V ˇcrtno kodo
lahko zapiˇsete teˇzo ali konˇcno ceno. Primer ˇcrtne kode s teˇzo: 2116789002000.
Kjer je 211 oddelek sadja, 6789 id za banane, 00200 teˇza (200 gramov) in 0
check digit. Torej iz ˇcrtne kode morate razbrati vse naˇstete lastnosti. Prav
tako morate popraviti ˇcrtno kodo, ˇce se spremeni teˇza ali cena artikla (odvisno
od implementacije). Ustvarite vsaj tri artikle iz razliˇcnih oddelkov. Na raˇcunu
mora biti vidna teˇza teh artiklov.

## Vaja 3.3 (neobvezna)

V aplikaciji podprite kupone za popust (npr. 10% na celotni nakup). Kupon
prepoznamo na podlagi ˇcrtne kode, ki se priˇcne z 99. Razmislite kaj vse bi
lahko ˇse bilo zapisano v ˇcrtni kodi kupona (tip, veljavnost...). Ustvarite vsaj
tri razliˇcne kupone in demonstrirajte delovanje. Ne pozabite popraviti izpis na
raˇcunu.

## Vaja 4.1 Podatkovna baza

Po26.4.2019se vaja zagovarja za poloviˇcno ˇstevilo pik!

Prenesite in namestite MySQL server. Namestite: server, workbench (vme-
snik za upravljanje), java connector (povezava do baze), MySQL shell (ukazna
vrstica) in primere (samples and examples). Dodajte uporabnika z vsemi pravi-
cami (admin). V orodju MySQL workbench pripravite shemo vaˇse podatkovne
baze (pomagajte si z EER diagramom). V tem koraku ˇse ne bomo dejan-


sko ustvarili podatkovne baze. Shemo preimenujte v InvoiceManagment. Vaˇsa
shema mora vsebovati vsaj sledeˇce tabele:

- Article,
- InternalArticle,
- Invoice in
- Company.

Vsaka tabela mora imeti stolpec za primarni kljuˇc, ki je tipa UUID (BINARY(16)).
Prav tako mora vsaka tabela imeti stolpec created in lastmodified (tipa DA-
TETIME).

## Vaja 4.2

V projekt dodajte nov paket za delo s podatkovno bazo (npr. si.um.feri.database).
V paket dodajte razed DBHelper, ki ima metodo za pridobitev povezave do po-
datkovne baze. Za upravljanje povezav izberite poljubno knjiˇznico (BoneCP,
DBCP, C3P0, HikariCP...), ki omogoˇca database connection pooling (DBCP).
Primer za Apache Commons DBCP. Nastavitve podatkovne baze kot so URL,
user, password itd. preberite iz json ali java properties datoteke. Datoteko z
nastavitvami ne pozabite dodati na seznam gitignore. Testirajte povezavo, tako
da v kodi izvedete poljuben SELECT stavek nad testno podatkovne bazo Sakila.

## Vaja 5.1

Dopolnite vaˇs ER diagram, tako da bo vseboval tabele in stolpce prikazane na
sliki 1.

Pripravite sql skripto (dbChanges1.sql), ki bo ustvarila podatkovno bazo
(InvoiceManagerdev) po izgledu vaˇsega ER diagrama. Pri izdelavi skripte si
lahko pomagate z orodjem MySql Workbench. Skripta naj vsebuje:

- nastavitev za character set na utf8mb4 in za collate na utf8mb4unicodeci,
- ukaze za kreiranje vseh tabel in njihovih povezav,
- za tabele s tujimi kljuˇci uporabite engine InnoDB,
- omejitve za tuje kljuˇce (onemogoˇcitebrisanje in posodabljanje),
- privzeto vrednost za deleted (false),
- TRIGGER za dogodek before update, ki posodobi stolpec modified na
    trenuten ˇcas (za vse tabele, ki imajo ta stolpec),
- na zaˇcetku dodajte spremenljivke za vsak stolpec v tabeli SchemaVersion
    in jih ustrezno inicializirajte (npr. SET @changenumber = 1;),
- na koncu vstavite spremenljivke v tabelo SchemaVersion.


Skripto zaˇzenite v MySql Shell in preverite, ˇce se je uspeˇsno izvedla. Skripto
in sliko ER diagrama (lahko tudi .mwb datoteko) dodajte na vaˇs repozitorij. Do-
polnite connection string, da bo vseboval useUnicode=true in characterEncoding=utf-
8.

## Vaja 5.2

V Javi pripravite funkcijo, ki bo napolnila tabelo Article z artikli iz datoteke
GroceryUPCDatabase.xlsx in en.openfoodfacts.org.products.csv. Za vstavlja-
nje artiklov uporabite:

- PreparedStatement,
- Batching in
- Transactions

Commit izvedite za vsakih 1000 artiklov. Vsakem artiklu nastavite nakljuˇcno
generirano ceno in zalogo (stock) na 1000. Vstavite vse artikle, ki imajo ˇcrtno
kodo dolgo najveˇc 14 znakov. Ce je ˇcrtna koda krajˇsa, dodajte na zaˇcetkuˇ
ustrezno ˇstevilo niˇcel. Za vse artikle preverite ali imajo veljavno ˇcrtno kodo.Ceˇ
ni veljava artikel zavrˇzemo in o tem tudi obvestimo uporabnika. Upoˇstevajte,
da se nekaterim artiklom ˇcrtna koda priˇcne z 2 in 99.

## Vaja 5.3

V projekt dodajte paket za razrede in vmesnike za delo s podatkovno bazo
(DAO - Data Access Object). V paket dodajte generiˇcni vmesnik DaoCrud, ki
ima sledeˇce abstraktne metode:

- T getById(UUID id);
- List<T>getAll();
- boolean insert(T m);
- boolean update(T m);
- boolean delete(T m);
- T extractFromResultSet(ResultSet rs) throws SQLException;

Za vsak model dodajte vmesnik, ki deduje iz DaoCrud. Vmesniku lahko po
potrebi dodate metode, ki se navezujejo na izbrani model. Primer za model
Article:

public interface ArticleDao extends DaoCrud<Article> {
Article getByBarcode(String code);
}

Nato implementirajte vse vmesnike za delo z MySql podatkovno bazo. 

Napolnite tabelo Company z vsaj petimi podjetji in tabelo InternalArticle
z vsaj petimi artikli. Pripravite proceduro createinvoice, ki prejme podatke o
raˇcunu (vkljuˇcno s seznamom artiklov in njihovo koliˇcino). Procedura ustvari
raˇcun in ustrezno zmanjˇsa zalogo (stock). Ustvarite vsaj dva raˇcuna s klicem
procedure createinvoice.


