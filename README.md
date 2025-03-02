# Application de Liste de Pays

Cette application Android démontre l'utilisation des Activités et des Fragments à travers une liste de pays et leurs détails.

## Configuration du Projet

### Avec Android Studio

1. Clonez le dépôt
2. Ouvrez Android Studio
3. Sélectionnez "Open an existing project"
4. Naviguez jusqu'au dossier du projet et sélectionnez-le
5. Attendez la synchronisation Gradle
6. Lancez l'application sur un émulateur ou un appareil physique

### Sans Android Studio

1. Clonez le dépôt
2. Assurez-vous d'avoir le JDK installé
3. Ajoutez le SDK Android à votre PATH
4. Dans le terminal, à la racine du projet :
```bash
# Sur Linux/macOS
./gradlew assembleDebug

# Sur Windows
gradlew.bat assembleDebug
```
5. L'APK sera généré dans `app/build/outputs/apk/debug/`

## Présentation de l'Application

L'application présente une liste de pays et leurs détails en utilisant à la fois des Activités et des Fragments. Elle se compose de :

- Une liste principale de pays
- Une vue détaillée pour chaque pays
- L'affichage des drapeaux via l'API FlagCDN

## Activités vs Fragments dans l'Application

### Activités
- `CountryListActivity` : Gère la vue principale de la liste
- `CountryDetailActivity` : Affiche les détails d'un pays spécifique
- Avantage : Navigation claire entre les écrans principaux

### Fragments
- `CountryListFragment` : Contenu réutilisable de la liste
- `CountryDetailFragment` : Vue détaillée modulaire
- Avantage : Réutilisation des composants UI et meilleure flexibilité pour différentes tailles d'écran

## API FlagCDN

L'application utilise l'API FlagCDN pour afficher les drapeaux des pays. Les URLs sont construites sous la forme :
```
https://flagcdn.com/[size]/[country-code].png
```

Cette API offre un accès simple aux drapeaux de haute qualité pour tous les pays, avec différentes tailles disponibles.

## Screen application

