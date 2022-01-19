Feature: Le nombre de villageois

  Scenario: Nombre de personne par defaut dans le village
    Given Je suis le maire
    When Je consulte la poupulation
    Then Je devrais avoir 10 personne

  Scenario: 100 personnes dans le village
    Given Je suis le maire de 100 villageois
    When Je consulte la poupulation
    Then Je devrais avoir 100 personne
