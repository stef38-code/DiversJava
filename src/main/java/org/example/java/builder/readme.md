#Builder

3 façons de réaliser des Builder

1. Le Builder le plus simple : 

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
        NomEntiteBuilder nomEntiteBuilder = new NomEntiteBuilder();
       /** setter des proprietes **/
        nomEntiteBuilder.setId(this.id);
        return nomEntiteBuilder;
    }
    /** les Methodes d'affection des proprietes **/
    public NomEntiteBuilder id(String id) {
        this.id = id;
        return this;
    }
}
````

|               Source                |                                        Test Unitaire                                        |
|:-----------------------------------:|:-------------------------------------------------------------------------------------------:|
| [Personne](./PersonneBuilder.java)  |    [Test](../../../../../../test/java/org/example/java/builder/PersonneBuilderTest.java)    |
|  [Adresse](./AdresseBuilder.java)   |    [Test](../../../../../../test/java/org/example/java/builder/AdresseBuilderTest.java)     |

2. Le Buidler de type Consumer : [Personne](./PersonneBuilderWithConsumer.java)

````java
public class NomEntiteBuilderWithConsumer {
    /** Les propriétés **/
    public String id;

    /** le Consumer **/
    public NomEntiteBuilderWithConsumer with(
            Consumer<NomEntiteBuilderWithConsumer> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    /** Le builder **/
    public Personne createPersonne() {
        NomEntite nomEntiteBuilder = new NomEntite();
        /** setter des proprietes **/
        nomEntiteBuilder.setId(this.id);
        return nomEntiteBuilder;
    }
}
````

|               Source                |                                        Test Unitaire                                        |
|:-----------------------------------:|:-------------------------------------------------------------------------------------------:|
| [Personne](./PersonneBuilderWithConsumer.java)  |    [Test](../../../../../../test/java/org/example/java/builder/PersonneBuilderWithConsumerTest.java)    |
|  [Adresse](./AdresseBuilderWithConsumer.java)   |    [Test](../../../../../../test/java/org/example/java/builder/AdresseBuilderWithConsumerTest.java)     |


3. Le Buidler Generic
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
|                    Source                    |                                        Test Unitaire                                        |
|:--------------------------------------------:|:-------------------------------------------------------------------------------------------:|
|                [Builder](./GenericBuilder.java)                 |    [Test](../../../../../../test/java/org/example/java/builder/GenericBuilderTest.java)    |
