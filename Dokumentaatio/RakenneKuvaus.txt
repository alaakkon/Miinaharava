## Rakennekuvaus

Ohjelma koostuu kolmesta pakettikokonaisuudesta; Käyttöliittymästä,l ogiikasta ja Main:ista
Logiikka sisältää nimensä mukaisesti pelin toiminnan ja kayttoliittyman vastuulla on pelin pyörittäminen.


Peli alkaa, kun KayttoLiittyma luokkaa kutsutaan. 

KayttoLiittyma ajaa konsuktorissa  metodin luoAlkupaneeli() . Tämä luo Alkupaneeli olion ,joka käskyllä käynnistää Alkupaneeli luokassa tapahtuvan alkuvalikon luomisen toiminnallisuuksineen. 
AlkuPaneeli käyttää luomiseen AlkuPaneelinKuuntelijaa , joka kutsuu KayttoLiittyman metodia luoPeliPaneeli().

KayttoLiittyman metodi luoPeliPaneeli() luo luokkien PeliPaneeli ja Piirtoalusta oliot. Piirtoalusta olion parametreinä luodaan PelinKulku olio, sekä juuri luotu Pelipaneeli olio.
PeliPaneeli luokka lisää luomalleen Piirtoalusta oliolle pelialustan toiminnallisuudesta huolehtivan MouseListener luokan, sekä luomalleen pelialustalle KellonKuuntelija luokan, joka tuntee PelinKulku olion.

Piirtoalusta toteuttaa rajapinnan MouseListener. Konsuktorissa luodaan TiedostonKasittelija olio.
MouseListenerin metodi mousePressed() käyttää PelinKulku luokan metodia pelaa() ja huolehtii Piirtoalusta luokan sisältämien metodien käytöstä. 

Luotaessa PelinKulku luokan olio, luodaan Lauta luokan olio ja alustetaan pelilauta tämä metodilla .alustaLauta(). Pelilauta muodostetaan Lauta luokassa luomalla kaksiuloitteinen taulukko-olio, jonka jokainen alkio on Ruutu luokan olio.



