package org.example.java.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.java.core.entities.Village;

import static org.assertj.core.api.BDDAssertions.then;

public class PopulationTest {
    private Village village;

    private int nombreVillageois;


    @Given("Je suis le maire")
    public void je_suis_le_maire() {
        village = new Village();
    }


    @Given("Je suis le maire de {int} villageois")
    public void je_suis_le_maire_de_villageois(Integer int1) {
        village = new Village(int1);
    }

    @Then("Je devrais avoir {int} personne")
    public void je_devrais_avoir_personne(Integer int1) {
        then(nombreVillageois).isEqualTo(int1);
    }

    @When("Je consulte la poupulation")
    public void je_consulte_la_poupulation() {
        nombreVillageois = village.getVillageois().size();
    }

}
