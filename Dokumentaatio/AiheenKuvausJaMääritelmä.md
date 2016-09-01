##Aihemäärittely:    
#Miinaharava    
Toteutetaan yksinpeli, jossa pelaajan ruudukon koon valitsemalle pelilaudalle luodaan miinoja, joiden paikat pelaajan on tarkoitus päätellä. Pelilaudalla sijaitsee miinoja satunnaisesti. Miinojen sisältämien ruutujen ympäröivissä on ruuduissa on numerot sen mukaisesti, kuinka montaa miinaa kyseinen ruutu sivuaa.      
##Käyttäjä: Pelaaja   
Pelaaja valitsee pelin vaikeustason pelilaudan koon mukaisesti.
Tämä onnistuu mikäli ruudukon koko on annetuissa rajoissa. (Vähintään seitsemän ruudun kokoinen)
Pelaaja antaa syötteenä pelilaudan koordinaatit ja ruudun arvellun sisällön. Sisältöjä ovat joko miina tai tyhjä ruutu. Peli päättyy, kun pelaaja on antanut miinojen oikeat koordinaatit. Kuitenkin mikäli pelaaja antaa sisällöksi tyhjän ruutuun, jonka sisältönä onkin miina peli päättyy. Väärästä miinan arvelusta ei tapahdu mitään.

 [Pelin käyttöohje](kaytto_ohje.md)
###Sekvenssikaaviot
- [PelinKulku_p=new_PelinKulku(3,3)](PelinKulku_p=new_PelinKulku(2)(1).png)
- [p.pelaa()](p.pelaa.png)
- [arvoMiinatLaudalle()](arvoMiinatLaudalle().png)
- [merkitseVierustat()](merkitseVierustat.png)
- [avaaNolla()](avaaNolla.png)
