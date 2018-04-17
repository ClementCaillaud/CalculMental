
# TP Calcul Mental


### Recommandation :


Vous devez installer une version de Eclipse supérieure ou égale à 4.7.3 ou une version de Intellij supérieur ou égale à 2018.1.1.
Vous devez aussi télécharger le dossier Zip, puis ajouter le dossier lié au jeu sur votre ordinateur.
Une fois Eclipse ou Intellij ouvert, vous devez importer le projet en tant que projet Gradle. Vous pouvez ensuite lancer l’application à partir de la class Application située dans la package fr.CalculMental.


### Fonctionnement du jeu 

Le but du jeu est de vous entraîner au calcul mental en résolvant correctement les opérations qui vous sont proposées. Chaque bonne réponse vous rapporte des points et votre meilleur score sera sauvegardé et associé à votre pseudo.
Une liste des cinq meilleurs scores sera affichée à la fin de votre partie.

Durant la partie vous allez rencontrer des calculs qui pourront comporter jusqu’à cinq nombres, compris entre 0 et 99,  et donc quatre opérations possibles. Ceux-ci sont entièrement générés de façon aléatoire. 

### Pour jouer au jeu

Vous devez résoudre les calculs posés en entrant un nombre avec votre clavier puis en validant avec Entrée. Les nombres peuvent être des entiers ou des nombres décimaux, positifs ou négatifs. Vous verrez alors si votre réponse était correcte, et sinon la solution vous sera donnée.

L’opérateur décimal utilisé est la virgule “,” et non le point “.”. De plus, les réponse ne comportent au maximum que 2 chiffres après la virgules.
Toutes les opérations, et sous-opérations, effectuées durant le calcul sont arrondies à deux chiffres après la virgule. Prenez ça en compte car cela peut jouer sur l’exactitude du résultat final.
