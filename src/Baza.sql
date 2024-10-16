CREATE DATABASE if not exists Wiki;
use Wiki
CREATE TABLE if not exists dane (
    id int PRIMARY KEY AUTO_INCREMENT,
    haslo text not null,
    zd1 text not null,
    podpis1 text not null,
    zd2 text,
    podpis2 text,
    tresc text
);
INSERT INTO dane(haslo, zd1, podpis1, zd2, podpis2, tresc) VALUES("Polska","src/images/pl_flag.jpeg","Flaga Polski","src/images/pl_map.jpeg","Mapa Polski","Polska to państwo unitarne w Europie Środkowej, położone między Morzem Bałtyckim na północy a Sudetami i Karpatami na południu, w przeważającej części w dorzeczu Wisły i Odry."),
("Portugalia","src/images/pt_flag.jpeg","Flaga Portugalii","src/images/pt_map","Mapa Portugalii","Portugalia to państwo europejskie położone w zachodniej części Europy Południowej na południowym zachodzie Półwyspu Iberyjskiego. Jest najdalej wysuniętym na zachód państwem Europy, od północy i wschodu graniczy z Hiszpanią, a od zachodu i południa Portugalię oblewają wody Oceanu Atlantyckiego."),
("Kangur","src/images/kangur1.jpeg","Zdjęcie Kangura","src/images/kangur.jpeg","Zdjęcie Kangura 2","Kangur to rodzaj ssaka z podrodziny kangurów w obrębie rodziny kangurowatych."),
("Papuga","src/images/papuga1.jpg","Zdjęcie papug","src/images/papuga2.jpeg","Zdjęcie papug 2","Papugowe, potocznie jako papugi to rząd ptaków z podgromady Neornithes. Najliczniejsze w Ameryce Południowej i Australii."),
("Jan Kochanowski","src/images/kochanowski1.jpeg","Rysunek Jana Kochanowskiego","src/images/kochanowski2.jpg","Rysunek Jana Kochanowskiego 2","Jan Kochanowski to polski poeta epoki renesansu, tłumacz, prepozyt kapituły katedralnej poznańskiej w latach 1564–1574, poeta nadworny Stefana Batorego w 1579 roku, sekretarz królewski Zygmunta Augusta i Stefana Batorego, wojski sandomierski w latach 1579–1584."),
("Konstytucja 3 Maja","src/images/konstytucja1.jpg","Zdjęcie oryginału ustawy","src/images/konstytucja2.jpeg","Obraz Jana Matejki pt. \"Konstytucja 3 maja\"","Konstytucja 3 maja, właśc. Ustawa Rządowa z dnia 3 maja to uchwalona 3 maja 1791 roku ustawa regulująca ustrój prawny Rzeczypospolitej Obojga Narodów. Powszechnie przyjmuje się, że Konstytucja 3 maja była pierwszą w Europie i drugą na świecie spisaną konstytucją."),
("Konferencja w Teheranie","src/images/teheran1.jpg","Zdjęcie z konferencji teherańskiej","src/images/teheran.jpg","Zdjęcie z konferencji teherańskiej","Konferencja teherańska to spotkanie przywódców koalicji antyhitlerowskiej: prezydenta USA Franklina Delano Roosevelta, premiera Wielkiej Brytanii Winstona Churchilla i przywódcy ZSRR Józefa Stalina w Teheranie w dniach 28 listopada – 1 grudnia 1943 roku.");