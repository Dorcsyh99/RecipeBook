Projekt Features:
Asztali verzió (RecipeBookDesktop modul):
- Alapanyagok tárolása / hozzáadása.
- Készlet tárolása /módosítása.
- Bevásárlás támogatása: megadott alapanyagot és mennyiséget hozááad a készlethez.
- Receptek hozzáadása és listázása.
Sajnos nem firssít automatikusan a módosításoknál / hozzáadásoknál, így ezeket manuálisan tudjátok megtenni a frissítés gombokkal.
Webes verzió (RecipeBookWeb modul):
- Receptek listázása
(Nem igazán boldogultam a servletekkel :( )

Beüzemelés:
Én csak intellij-ből indítottam eddig, az asztali verziónak egyszerűen futnia kell egy javafx:compile, majd javafx:run után. Az adatbázissal azonban lehetnek gondok. Én abszolút útvonalat használtam, hogy a szerver és az asztali verzót is ugyanazt az adatbázist tudja használni. Ezért, amikor megnyitjátok írjátok át a DB_STRING-eket az összes DaoImpl-ben. Javaslom az abszolút útvonalat Nektek is, abba a mappába, ahol a tomcat szerver van, így a webes cuccal biztos nem lesz gond. Csatolok egy adatbázist is, így lesznek már benne basic adatok, hogy jobban lássátok az elején, hogy milyen az alkalmazás. 
A webes modul én úgy indítottam, ahogy az alkfejl-es videókban láttam. Itt is egyedül az adatbázissal lehetnek majd gondok, de ha követitek, amit a videóban mond, akkor szerintem ezzel sem lesz gond.

Használat:
A webes verzió elég kezdetleges, nem sikerült túl dinamikussá tenni. Így, amikor új receptet adtok hozzá, sajnos a kódban kell egy új "recipe-card"-os divet másolni és átírni a .get(0)-ekben a számot.
Az asztali modulban elvileg minden jól működik, annyi, hogy amikor receptet adtok hozzá a hozzávalókat abban a formátumban írjátok bele, légyszi, ahogy a Prompt textben van - vesszővel elválasztva (így tudja majd a listázásnál split-tel szétszedni a program). Nem működnek az átvlátások az alapnyagok mennyiségénél (igazából a mennyiség csak "látszat", hibát sem dob, ha más mennyiséget írnátok be, mint ahogyan hozzá lett adva).
Amikor bevásárlásnál arra mentek, hogy "Új alapanyagot vettem" és hozzá is adtok egy hozzávalót, akkor be kell zárni a bevásárlás ablakot majd újra megnyitni, így lesz kiválasztható az új alapanyag. Ha bevásárlásnál, olyan alapanyagot adtok meg, ami nincs a készleteknél, akkor is hibát dob a program. Csak olyannal próbáljátok, amiből mrá van készlet is. Recepteknél is újra meg kell nyitni az balakot, amikor újat adtok hozzá.