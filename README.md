1.3 Vaja 2.1
Za vajo imate ˇcas dva tedna. Ce vajo zagovorite prvi teden (18.3.2019 - 22.3.2019), ˇ
lahko dobit vse pike. Ce zagovarjate po 22.3.2019 se vaji odbije ena pika. Enako ˇ
velja za neobvezne naloge.
Objavite vso vaˇso kodo na poljuben repozitorij (primer za GitHub). Po
potrebi dopolnite razred Raˇcun, da bo vseboval:
• izdajatelj,
• datum,
• (unikatna) ˇstevilka raˇcuna in
• davˇcna ˇstevilka podjetja (ID ˇstevilka za DDV).
Po zgledu pripravite razred Podjetje, ki ima vsaj:
• ime,
• davˇcna ˇstevilka,
• matiˇcna ˇstevilka in
• je davˇcni zavezanec.
Ustvarite vmesnik (interface) Searchable, ki ima metodo search. Metoda
prejme String in vrne boolean. Razredi Artikel, Podjetje in Raˇcun naj implementirajo vmesnik Searchable. Metoda search vrne true, ˇce objekt vsebuje
podan String v katerikoli instanˇcni spremenljivki.
Ustvarite objekte po zgledu vaˇsih izbranih raˇcunov in treh poljubnih podjetij.
Vsi objekti se naj kreirajo ob zagonu aplikacije (hard-coded). Ustvarite vsaj
en original raˇcun (ima davˇcno ˇstevilko podjetja). Na raˇcunu preverite ali je
podjetje davˇcni zavezanec.
1.4 Vaja 2.2
Razredu Artikel dodajte statiˇcno metodo checkDigit, ki prejme ˇcrtno kodo
vkljuˇcno s kontrolna ˇstevilko (check digit) in vrne boolean. Metoda naj preveri ali je ˇcrtna koda veljavna (izraˇcun). Pri testiranju si lahko pomagate s
kalkulatorjem. Povozite metodo toString(), tako da bo izpis ˇcim bolj podoben
vaˇsem izbranem raˇcunu.
1.5 Vaja 2.3 (neobvezna)
Razredu Artikel dodajte ˇse drˇzavo. Pri dodajanju artikla “izluˇsˇcite” drˇzavo iz
ˇcrtne kode. Ali imajo vse ˇcrtne kode drˇzavo?