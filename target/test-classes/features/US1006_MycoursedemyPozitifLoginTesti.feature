@myCourse
  Feature: US1006 Dogru kullanici adi ve password ile pozitif login testi

    Scenario: TC12 Kullanici mycoursedemy sitesine giris yapabilmeli

      Given Kullanici "myUrl" anasayfaya gider
      Then myCourse anasayfa login linkine tiklar
      And myCourse kullanici adi olarak "myGecerliEmail" girer
      And  myCourse password olarak "myGecerliPassword" girer
      And accept butonuna basar
      And  myCourse login butonuna basar
      And  myCourse giris yapabildigini test eder
      And Sayfayi kapatir