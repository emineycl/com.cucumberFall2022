
Feature: US1004 Parametre Kullanma

   @pt1
  Scenario: TC08 Kullanici parametre ile verilen kelimeyi amazonda aratabilmeli

    Given Kullanici amazon anasayfaya gider
    Then Arama cubuguna "Nutella" yazip aratir
    And Arama sonuclarinin "Nutella" icerdigini test eder
    And Sayfayi kapatir