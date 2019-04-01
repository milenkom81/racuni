Vaja 3.1
Po 5.4.2019 se vaja zagovarja za poloviˇcno ˇstevilo pik!
Dodajte razred (Invoices), ki ima seznam raˇcunov in Companies, ki ima
seznam podjetij. V projektu podprite shranjevanje in branje iz JSON datotek. Ustvarite vmesnik JsonSupport, ki ima metodi toJson (vrne JSON string)
in fromJson (prejme JSON string). Razredi Invoices, Companies in Articles
(Artikli) naj implementirajo vmesnik JsonSupport. Za parsanje in generiranje
JSON stringov lahko uporabite knjiˇznico Gson. Dodajte razred Helper, ki vsebuje samo statiˇcne metode. Dodajte metodi za branje in pisanje datotek in ju
uporabite za pisanje/branje JSON stringov v datoteke.
Vaja 3.2
Prodajalci lahko doloˇcijo interno ˇcrtno kodo za sveˇzo hrano (zelenjava, meso,
sadje, pekarski izdelki...). Za interno vodenje artiklov je po standardu v ˇcrtni
kodi rezerviranih zaˇcetnih nekaj ˇstevil (200 - 299). Cena teh artiklov je odvisna
od njihove teˇze. V aplikaciji podprite interno vodenje ˇcrtnih kod. V ˇcrtno kodo
lahko zapiˇsete teˇzo ali konˇcno ceno. Primer ˇcrtne kode s teˇzo: 211678902002.
Kjer je 211 oddelek sadja, 6789 id za banane, 0200 teˇza (200 gramov) in 2
check digit. Torej iz ˇcrtne kode morate razbrati vse naˇstete lastnosti. Prav
tako morate popraviti ˇcrtno kodo, ˇce se spremeni teˇza ali cena artikla (odvisno
od implementacije). Ustvarite vsaj tri artikle iz razliˇcnih oddelkov. Na raˇcunu
mora biti vidna teˇza teh artiklov.
Vaja 3.3 (neobvezna)
V aplikaciji podprite kupone za popust (npr. 10% na celotni nakup). Kupon
prepoznamo na podlagi ˇcrtne kode, ki se priˇcne z 99. Razmislite kaj vse bi
lahko ˇse bilo zapisano v ˇcrtni kodi kupona (tip, veljavnost...). Ustvarite vsaj
tri razliˇcne kupone in demonstrirajte delovanje. Ne pozabite popraviti izpis na
raˇcunu.