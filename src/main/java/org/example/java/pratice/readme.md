# Gérer Null efficacement
Le renvoi d'un objet éventuellement **_null_** à partir d'une méthode n'est généralement pas souhaitable
Le null peut être le résultat de divers actions :
* un object null
* un retour d'une valeur null

## String

|        Mauvaise solution         |          1ième Bonne solution           |       2iéme Bonne solution        |
|:--------------------------------:|:---------------------------------------:|:---------------------------------:|
| [Return Null](./StringNull.java) | [StringUtils.EMPTY](./StringEmpty.java) | [Optional](./StringOptional.java) |



## Collection


|          Mauvaise solution           |          1ième Bonne solution           |         2iéme Bonne solution          |
|:------------------------------------:|:---------------------------------------:|:-------------------------------------:|
| [Return Null](./CollectionNull.java) | [StringUtils.EMPTY](./StringEmpty.java) | [Optional](./CollectionOptional.java) |


## Classe

|        Mauvaise solution         | --  |       2iéme Bonne solution        |
|:--------------------------------:|:---:|:---------------------------------:|
| [Return Null](./ClasseNull.java) | --  | [Optional](./ClasseOptional.java) |
