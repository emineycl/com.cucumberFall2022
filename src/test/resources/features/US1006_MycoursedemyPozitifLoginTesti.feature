@myCourse
Feature: US1006 Dogru kullanici adi ve password ile pozitif login testi
  @smokeTest  @pt2
  Scenario: TC12 Kullanici mycoursedemy sitesine giris yapabilmeli

    Given Kullanici "myUrl" anasayfaya gider
    Then accept butonuna basar
    Then myCourse anasayfa login linkine tiklar
    And myCourse kullanici adi olarak "myGecerliEmail" girer
    And myCourse password olarak "myGecerliPassword" girer
    And myCourse login butonuna basar
    Then myCourse giris yapabildigini test eder
    And Sayfayi kapatir