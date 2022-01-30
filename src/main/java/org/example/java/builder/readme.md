#Builder

3 façons de réaliser des Builder

1. Le Builder le plus simple : 

**_Exemple:_**
````java
public class NomEntiteBuilder {
    /** Les propriétés **/
    private String id;
    
    private NomEntiteBuilder() {
    }
    /** le builder **/
    public static NomEntiteBuilder builder() {
        return new NomEntiteBuilder();
    }
    /** Le builder **/
    public NomEntite build() {
        NomEntite nomEntite = new NomEntite();
       /** setter des proprietes **/
        nomEntite.setId(this.id);
        return nomEntite;
    }
    /** les Methodes d'affection des proprietes **/
    public NomEntiteBuilder id(String id) {
        this.id = id;
        return this;
    }
}
````
**_Utilisation_**
````java
NomEntite nomEntiteBuilder = NomEntiteBuilder.builder()
        .id("1234")
        .build();
````
|               Source                |                                        Test Unitaire                                        |
|:-----------------------------------:|:-------------------------------------------------------------------------------------------:|
| [Personne](./PersonneBuilder.java)  |    [Test](../../../../../../test/java/org/example/java/builder/PersonneBuilderTest.java)    |
|  [Adresse](./AdresseBuilder.java)   |    [Test](../../../../../../test/java/org/example/java/builder/AdresseBuilderTest.java)     |

2. Le Buidler de type Consumer : [Personne](./PersonneBuilderWithConsumer.java)

**_Exemple_**
````java
public class NomEntiteBuilder {
    /** Les propriétés **/
    public String id;

    /** le Consumer **/
    public NomEntiteBuilder with(
            Consumer<NomEntiteBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    /** Le builder **/
    public NomEntite createNomEntite() {
        NomEntite nomEntit = new NomEntite();
        /** setter des proprietes **/
        nomEntite.setId(this.id);
        return nomEntite;
    }
}
````
**_Utilisation_**
````java
NomEntite nomEntit = new NomEntiteBuilder()
                .with($ -> {
                    $.id=UUIDFAKE;
                })
                .createNomEntite();
````
|               Source                |                                        Test Unitaire                                        |
|:-----------------------------------:|:-------------------------------------------------------------------------------------------:|
| [Personne](./PersonneBuilderWithConsumer.java)  |    [Test](../../../../../../test/java/org/example/java/builder/PersonneBuilderWithConsumerTest.java)    |
|  [Adresse](./AdresseBuilderWithConsumer.java)   |    [Test](../../../../../../test/java/org/example/java/builder/AdresseBuilderWithConsumerTest.java)     |


3. Le Buidler Generic

**_Exemple:_**
````java
public class GenericBuilder <T> {

    private final Supplier<T> instantiator;

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }
    /** creation de l'instance : NomEntite::new **/
    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<T>(instantiator);
    }
    /** Affectation des propriétés .with(NomEntite::setId, "123-345-678") **/
    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }
    /** Build **/
    public T build() {
        T value = instantiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }
}
````
**_Utilisation:_**
````java
Personne personne = GenericBuilder.of(Personne::new)
                .with(Personne::setNom, nom)
                .with(Personne::setPrenom, prenom)
                .with(Personne::setId, UUIDFAKE)
                .with(Personne::setDateNaissance, dateNaissance)
                .with(Personne::setAdresses,
                        List.of(
                                GenericBuilder.of(Adresse::new)
                                        .with(Adresse::setId, UUIDFAKEAdresse)
                                        .with(Adresse::setBatimentResidence, batimentResidence)
                                        .with(Adresse::setAppartementEscalierEtage, appEscalEtage)
                                        .with(Adresse::setNumeroNomVoie, numVoie)
                                        .with(Adresse::setComplementAdresse, compAdre)
                                        .with(Adresse::setCodePostal, codePostal)
                                        .with(Adresse::setVille, ville)
                                        .with(Adresse::setPays, pays)
                                        .build()
                        ))
                .build();
````
|                    Source                    |                                        Test Unitaire                                        |
|:--------------------------------------------:|:-------------------------------------------------------------------------------------------:|
|                [Builder](./GenericBuilder.java)                 |    [Test](../../../../../../test/java/org/example/java/builder/GenericBuilderTest.java)    |
