
  Feature: US1005 Parametre Kullanma

    Scenario: TC08 Kullanici parametre ile verilen kelimeyi amazon'da aratabilmeli

      Given Kullanici amazon anasayfaya gider
      Then Arama cubuguna "TV" yazip aratir
      And Arama sonuclarinin "TV" icerdigini test eder
      And Sayfayi kapatir
