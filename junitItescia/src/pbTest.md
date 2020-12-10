# Exercice 2 question 1

## Ambiguités soulevées par l'énoncé

Il n'est pas spécifié ques les arguments de la méthode static **unionSet** de la classe **VectorObj**
ne doivent pas être null.

Il y un "malentendu" au  niveau du typage des objects contenu dans le/les vecteur(s)

Ainsi le parti pris reviens au developpeur, nous décidons d'accepter un vecteur avec différent types d'objects

De plus nous décidons de garder l'ordre des données ajoutées. ( Chose qui est également pas spécifié dans l'énoncé)

le vecteur résultant de la fusion des deux vecteurs doit garder l'ordre des données des données des 2 vecteurs utilisés en arguments dans la méthode
**unionSet**