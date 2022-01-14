Feature: Savoir le nombre de villageois

  Scenario: Nombre de personne par defaut
    Given J'ai pas de criteres sur mon village
    When Je consulte la poupulation
    Then Je devrais avoir 10 personne
