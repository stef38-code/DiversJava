Feature: Savoir le nombre de villageois

  Scenario: Nombre de personne par defaut dans le village
    Given J'ai pas de criteres sur mon village
    When Je consulte la poupulation
    Then Je devrais avoir 10 personne

  Scenario: 100 personnes dans le village
    Given J'ai spécifié le nombre 100 personne dans mon village
    When Je consulte la poupulation
    Then Je devrais avoir 100 personne
