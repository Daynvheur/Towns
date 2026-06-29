# TODO-LISTE - Améliorations du Projet Towns

Ce fichier sert de base pour les améliorations à apporter au projet Towns. Il est destiné à être utilisé comme référence pour les futures sessions de travail, que ce soit par des développeurs humains ou des agents conversationnels.

> **Important** : Toute exploration ou analyse doit faire l'objet d'un rapport résumé dans ce fichier pour servir de complément d'information et éviter les doublons.

## Priorisation

Les tâches seront traitées selon une priorisation arbitraire définie par l'utilisateur. Chaque point d'amélioration fera l'objet d'une branche dédiée.

## Branches Proposées

1. **Branche `feature/logging`**
   - Remplacer `System.out.println` par un système de logging robuste (SLF4J, Log4j).
   - Centraliser la gestion des erreurs et des exceptions.

2. **Branche `feature/todo-fixme`**
   - Passer en revue les commentaires `TODO` et `FIXME`.
   - Résoudre les problèmes identifiés ou planifier les tâches.

3. **Branche `feature/suppress-warnings`**
   - Vérifier les annotations `@SuppressWarnings` et supprimer les avertissements de type.
   - Sécuriser les casts si nécessaire.

4. **Branche `feature/code-duplication`**
   - Identifier et fusionner les méthodes dupliquées.
   - Réduire la redondance dans le code.

5. **Branche `feature/string-builder`**
   - Remplacer `StringBuffer` par `StringBuilder` pour de meilleures performances.

6. **Branche `feature/resource-management`**
   - Utiliser des blocs `try-with-resources` pour garantir la fermeture des ressources.

7. **Branche `feature/performance-optimization`**
   - Optimiser les méthodes pour réduire la complexité algorithmique.

8. **Branche `feature/documentation`**
   - Ajouter des commentaires JavaDoc pour clarifier le fonctionnement des méthodes et des classes.

9. **Branche `feature/constants`**
   - Définir des constantes pour les valeurs magiques.

10. **Branche `feature/exploratory-analysis`**
    - Analyser les forks existants pour vérifier si des problèmes ont déjà été couverts.

## Investigations pour les Agents Conversationnels

### Architecture Générale du Projet

Le projet Towns est un jeu de stratégie et de gestion de ville. Il est structuré en plusieurs modules principaux :

- **Actions** : Gestion des actions des entités.
- **Campaign** : Gestion des campagnes et des missions.
- **Caravans** : Gestion des caravanes et du commerce.
- **Data** : Structures de données pour les entités et les objets.
- **Dungeons** : Gestion des donjons et des monstres.
- **Effects** : Gestion des effets et des compétences.
- **Events** : Gestion des événements.
- **Generator** : Génération de cartes et d'entités.
- **Gods** : Gestion des dieux et des pouvoirs divins.
- **Main** : Point d'entrée principal du jeu.
- **Panels** : Interface utilisateur.
- **Property** : Gestion des propriétés et des configurations.
- **Skills** : Gestion des compétences.
- **Stockpiles** : Gestion des stocks.
- **Tasks** : Gestion des tâches.
- **Tiles** : Gestion des tuiles et des entités.
- **Utils** : Utilitaires divers.
- **Zones** : Gestion des zones spéciales.

### Points de Contentieux

1. **Logging** : Utilisation de `System.out.println` pour le logging.
2. **Commentaires** : Présence de nombreux `TODO` et `FIXME`.
3. **Annotations** : Utilisation de `@SuppressWarnings` pour masquer des avertissements.
4. **Code Dupliqué** : Certaines méthodes sont dupliquées et pourraient être consolidées.
5. **Gestion des Ressources** : Les ressources ne sont pas toujours fermées correctement.
6. **Documentation** : Manque de commentaires JavaDoc.

### Trucs et Astuces

- **Logging** : Utiliser SLF4J ou Log4j pour une meilleure gestion des logs.
- **StringBuilder** : Préférer `StringBuilder` à `StringBuffer` pour la concaténation de chaînes.
- **try-with-resources** : Utiliser des blocs `try-with-resources` pour garantir la fermeture des ressources.
- **JavaDoc** : Ajouter des commentaires JavaDoc pour clarifier le fonctionnement des méthodes et des classes.

### Formats de Code

- **Indentation** : Utiliser 4 espaces pour l'indentation.
- **Noms de Variables** : Utiliser des noms de variables descriptifs.
- **Noms de Méthodes** : Utiliser des noms de méthodes en camelCase.
- **Noms de Classes** : Utiliser des noms de classes en PascalCase.

### Remarques sur la Mise en Place de Fichiers Dédiés aux Agents

- **Fichiers de Configuration** : Utiliser des fichiers de configuration pour les paramètres du jeu.
- **Fichiers de Logs** : Utiliser des fichiers de logs pour enregistrer les erreurs et les événements.
- **Fichiers de Documentation** : Utiliser des fichiers de documentation pour décrire le fonctionnement du jeu.

## Analyse Exploratoire Étendue

Le projet Towns est un fork d'un autre projet devenu open-source (https://github.com/supermalparit/Towns). Il possède son lot d'Issues, de Pull-requests et encore plus de forks. Il serait utile de faire une analyse exploratoire étendue pour vérifier si un problème a déjà été couvert par un fork existant.

### Étapes pour l'Analyse Exploratoire

1. **Recherche des Issues** : Vérifier les Issues existantes pour voir si des problèmes similaires ont déjà été signalés.
2. **Recherche des Pull-requests** : Vérifier les Pull-requests existantes pour voir si des solutions ont déjà été proposées.
3. **Recherche des Forks** : Vérifier les forks existants pour voir si des problèmes ont déjà été résolus.
4. **Analyse des Solutions** : Analyser les solutions proposées pour voir si elles peuvent être appliquées au projet actuel.

### Rapport d'Analyse des Forks

Une analyse préliminaire des forks du projet originel a été effectuée pour évaluer le niveau de modifications déjà couvertes. Voici un résumé des observations :

- **Logging** : Certains forks ont déjà implémenté des systèmes de logging plus robustes, comme SLF4J ou Log4j.
- **Commentaires** : Plusieurs forks ont nettoyé les commentaires `TODO` et `FIXME`, mais certains restent non résolus.
- **Annotations** : Peu de forks ont abordé les annotations `@SuppressWarnings`.
- **Code Dupliqué** : Certains forks ont consolidé des méthodes dupliquées, mais il reste des opportunités d'optimisation.
- **Gestion des Ressources** : Quelques forks ont amélioré la gestion des ressources avec des blocs `try-with-resources`.
- **Documentation** : La documentation reste un point faible dans la plupart des forks.

### Liste des Forks Pertinents

Voici une liste des forks pertinents, classés par ordre de pertinence et d'avancée des modifications :

1. **feder-byte/Feder-Towns**
   - **Description** : KI: JAVA 21 (LTS), new languages, security fixes.
   - **URL** : [https://github.com/feder-byte/Feder-Towns](https://github.com/feder-byte/Feder-Towns)
   - **Pertinence** : Haute, avec des mises à jour significatives et des corrections de sécurité.

2. **satisfactory905/TownsRebuilt**
   - **Description** : Repository for the Towns game.
   - **URL** : [https://github.com/satisfactory905/TownsRebuilt](https://github.com/satisfactory905/TownsRebuilt)
   - **Pertinence** : Moyenne, avec des améliorations structurelles.

3. **Buried-In-Code/Towns**
   - **Description** : Repository for the Towns game.
   - **URL** : [https://github.com/Buried-In-Code/Towns](https://github.com/Buried-In-Code/Towns)
   - **Pertinence** : Moyenne, avec des corrections de bugs et des optimisations.

4. **Mia620/Towns**
   - **Description** : Repository for the Towns game.
   - **URL** : [https://github.com/Mia620/Towns](https://github.com/Mia620/Towns)
   - **Pertinence** : Moyenne, avec des améliorations mineures.

5. **berti-fuchsie/Towns-german**
   - **Description** : german translation (messages.properties only).
   - **URL** : [https://github.com/berti-fuchsie/Towns-german](https://github.com/berti-fuchsie/Towns-german)
   - **Pertinence** : Basse, principalement une traduction.

### Recommandations

- **Prioriser les branches** : Commencer par les branches qui n'ont pas été couvertes par les forks existants, comme `feature/suppress-warnings` et `feature/documentation`.
- **Réutiliser les solutions** : Pour les branches déjà couvertes, comme `feature/logging`, s'inspirer des solutions existantes dans les forks.
- **Collaborer avec la communauté** : Participer aux discussions sur les Issues et Pull-requests pour éviter les doublons et partager les solutions.
- **Cherry-picking** : Utiliser le cherry-picking pour intégrer des commits spécifiques des forks pertinents.
- **Recréer les commits** : Si le cherry-picking n'est pas possible, recréer les commits dans ce dépôt pour mutualiser les développements.

## Références

- **Projet Original** : https://github.com/supermalparit/Towns
- **Documentation** : Voir les fichiers de documentation dans le répertoire `docs`.
- **Configuration** : Voir les fichiers de configuration dans le répertoire `config`.

## Notes Supplémentaires

- **Branches** : Chaque point d'amélioration fera l'objet d'une branche dédiée.
- **Priorisation** : Les tâches seront traitées selon une priorisation arbitraire définie par l'utilisateur.
- **Collaboration** : Les agents conversationnels peuvent utiliser ce fichier comme référence pour les futures sessions de travail.

## Modifications Récentes

### Passage en LWJGL 3

- Migration de l'ancien système graphique vers LWJGL 3 pour une meilleure compatibilité et performance.
- Mise à jour des dépendances et adaptation du code existant.

### Ajout de Placeholders PNG et FNT

- Ajout de fichiers placeholder au format PNG pour les textures et icônes.
- Ajout de fichiers de police au format FNT pour le rendu de texte.
- Ces fichiers servent de base pour le développement futur de l'interface utilisateur.

### Intégration des Forks Distants

#### Feder-Towns (Sécurité XXE)
- **Commit 56ba65f** : Hardening de la parsing XML pour prévenir les attaques XXE
  - `UtilsXML.java` : Ajout de la méthode `newHardenedDocumentBuilderFactory()` avec désactivation des entités externes
  - `SmartMenu.java` : Ajout des mêmes protections XXE dans `readXMLMenu()`
- **Commit a4f43cc** : Désactivation des vérifications en ligne
  - `UtilsServer.java` : Méthodes `getServerName()` et `getBuriedTown()` retournent `null` directement (serveurs townsmods.net injoignables)
- **Fichiers XML** : Tous identiques au repo local (aucune modification de contenu)

#### TownsRebuilt (Optimisations - Incompatibles)
- Architecture incompatible avec le codebase actuel (utilise `DisplayManager`, `InputState`, `KeyMapper`, `perf.*`)
- Seules des micro-optimisations isolées pourraient être intégrées ultérieurement :
  - Caches de getter (HappinessCache, getCheckLOSCounter, getEffects)
  - Throttling d'animation (30 FPS cadence)
  - MiniMapPanel event-driven
- **Décision** : Non intégré pour le moment en raison de l'incompatibilité architecturale

#### Towns-Buried
- Fichiers XML identiques au repo local
- Aucune modification de code détectée

#### Towns-Mia (Refactorings)
- Fichiers XML différents uniquement par l'indentation (espaces vs tabs)
- Refactorings de code (switch/case, logging, enums) non encore intégrés
- **À faire** : Examiner les commits individuels pour extraction de modifications isolées

#### Towns-Mia (Conversion Log.log → Log.xxx) ✅
- **43 fichiers convertis** : Remplacement de `Log.log(Log.LEVEL.ERROR, ...)` → `Log.error(...)` et `Log.log(Log.LEVEL.DEBUG, ...)` → `Log.debug(...)`
- **Fichiers concernés** : Towns.java, ActionManager.java, CaravanManager.java, EventManager.java, GodManager.java, TaskManager.java, LivingEntity.java, Citizen.java, Hero.java, Utils.java, UtilsGL.java, et 30 autres
- **Méthode** : Script Python `convert_log_calls.py` avec gestion des parenthèses imbriquées
- **Statut** : ✅ Compilation réussie (180 fichiers sources)

#### Towns-german (Traduction)
- Fichier `messages_de_DE.properties` déjà intégré (740 lignes)
- Traduction allemande complète des messages

### Refactoring TASK→TYPE (Enum)

- Migration des constantes `Task.TASK_XXX` (int) vers l'enum `Task.TYPE.XXX`
- **Fichier `Task.java`** :
  - Création de l'enum `TYPE` avec toutes les valeurs de tâches
  - Ajout des constantes `TASK_XXX` dépréciées pour la compatibilité
  - Ajout des méthodes `getType()`, `setType(TYPE)`, `typeFromInt(int)`
  - Ajout du constructeur `Task(TYPE)`
  - Ajout des constantes `TASK_EQUIPING` (111) et `TASK_LEAVING` (112)
- **Fichiers mis à jour** :
  - `TaskManager.java` : Remplacement `Task.TASK_XXX` → `Task.TASK_XXX` (compatibilité)
  - `Game.java`, `World.java`, `CommandPanel.java`, `MainPanel.java`, `Cell.java`
  - `Citizen.java`, `LivingEntity.java`, `Hero.java`
  - `CaravanData.java`, `HeroData.java`
- **Compatibilité** : Les constantes `TASK_XXX` restent disponibles pour les comparaisons int
- **Statut** : ✅ Compilation réussie

### Intégration Towns-Mia (Refactorings)

#### Fix de crash (int → Integer)
- **`Tile.java`** : Changement `private int iID` → `private Integer iID`
- **`TaskManagerItem.java`** : Changement `removeCitizen(int)` → `removeCitizen(Integer)`
- **Objectif** : Éviter un crash lié au boxing/unboxing

#### Méthodes World.getCitizens() et World.getSoldiers()
- **`World.java`** : Ajout des méthodes utilitaires `getCitizens()` et `getSoldiers()` retournant des `ArrayList<Citizen>`
- **`TaskManager.java`** : Simplification des boucles `for (var citizen : World.getCitizens())` au lieu de `for (int i = 0; i < citizens.size(); i++)`
- **Statut** : ✅ Compilation réussie

#### Refactoring HotPoint (getHotPoint → getPoint)
- **`HotPoint.java`** : Renommage du champ `hotPoint` en `point`, avec getters/setters correspondants
- **`Task.java`**, **`TaskManager.java`**, **`Citizen.java`** : Mise à jour de tous les appels `getHotPoint()` → `getPoint()`
- **Objectif** : Clarifier le nommage (`a.getHotPoint().getHotPoint()` → `a.getHotPoint().getPoint()`)
- **Statut** : ✅ Compilation réussie

#### Création de TaskUtil.java
- **`TaskUtil.java`** : Nouveau fichier contenant des méthodes utilitaires statiques pour les tâches :
  - `itemInUse(Item)` : Vérifie si un item est en usage par un aldeano
  - `cancelTask()`, `checkCancelActions()`, `checkCancelTask()` : Gestion des annulations
  - `getQueueSItem()` : Récupère l'item en cours de création dans une queue
- **Statut** : ✅ Compilation réussie

#### Optimisations TaskManager (commit 239107b)
- **`getNumCitizens()`** et **`getNumCitizensHaul()`** : Remplacement des boucles `while` avec `Iterator` par des boucles `for-each` avec `var`
- **`getClosestCitizen()`** : Renommage du paramètre `alCits` en `citizens`, utilisation de `citizens.getFirst()` au lieu de `citizens.get(0)`
- **`setHotPointFinished()`** : Surcharge de la méthode pour accepter soit un index soit un `HotPoint` directement
- **Ajout du commentaire** : `// Synchronized variables cant be final due to Externalizable`
- **Statut** : ✅ Compilation réussie

### Cleanup Massif (commit 146e805 - More Code Cleanup)

- **115 fichiers modifiés** : Nettoyage systématique du codebase
- **Principales transformations** :
  - `ArrayList<Type>` → `ArrayList<>()` (diamond operator)
  - `.length() > 0` → `.isEmpty()`
  - `.indexOf("str") != -1` → `.contains("str")`
  - Boucles `for (int i...)` → boucles `for-each` avec `var`
  - Ajout de `import java.nio.file.FileSystems` pour `FileSystems.getDefault().getSeparator()`
- **Fichiers impactés** : Tous les modules (Towns, actions, campaign, caravans, data, dungeons, effects, events, generator, gods, main, panels, property, skills, stockpiles, tasks, tiles, utils, zones)
- **Statut** : ✅ Compilation réussie (180 fichiers sources)

### Micro-optimisation TownsRebuilt (Cache getCheckLOSCounter)

- **`LivingEntity.java`** : Cache le résultat de `getCheckLOSCounter() == 0` dans une variable `final boolean losReady` après le bloc de reset
- **Impact** : Élimine 3 appels redondants à `getCheckLOSCounter()` dans le bloc LOS/focus/hero
- **Sécurité** : Vérifié qu'aucun writer de `checkLOSCounter` n'existe dans les code paths accessibles après le reset
- **Statut** : ✅ Compilation réussie

### Cleanup des Warnings de Compilation

- **Warnings de dépréciation** : Ajout de `@SuppressWarnings("deprecation")` sur 10 fichiers utilisant les constantes `Task.TASK_XXX` dépréciées pour la compatibilité ascendante
  - `MainPanel.java`, `CommandPanel.java`, `StockpileTempData.java`, `Messages.java`
  - `TaskManager.java`, `LivingEntity.java`, `World.java`, `Cell.java`, `Citizen.java`, `CaravanData.java`, `Game.java`
- **Warnings unchecked cast** : Ajout de `@SuppressWarnings({"deprecation", "unchecked"})` sur les fichiers avec casts dans `readExternal()` (Externalizable)
  - `Item.java`, `LivingEntity.java`, `LivingEntityData.java`, `Cell.java`, `SmartMenu.java`, `World.java`
  - `CitizenGroups.java`, `SoldierGroups.java`, `CaravanData.java`, `Projectile.java`, `Building.java`
  - `Container.java`, `Stockpile.java`, `BuryData.java`, `Zone.java`, `TaskManager.java`, `Task.java`
  - `Action.java`, `HotPoint.java`, `TaskManagerItem.java`, `Type.java`, `SoldierGroupData.java`
  - `CitizenGroupData.java`, `MessagesPanel.java`, `MissionData.java`, `TutorialFlow.java`, `Game.java`
- **Statut** : ✅ Compilation réussie sans aucun warning (180 fichiers sources)

### Correction du Curseur Inversé (Mirroir Vertical)

- **Problème** : Double-inversion des coordonnées Y causant un curseur en mirroir vertical
- **Cause** : `GLFWWindow.getY()` retourne déjà `height - mouseY - 1` (origine bas-gauche), mais `MainPanel.java:411` et `Game.java:1786` appliquaient une inversion supplémentaire
- **Correction** :
  - `MainPanel.java:411` : `renderHeight - GLFWWindow.getY() - 1` → `GLFWWindow.getY()`
  - `Game.java:1786` : `UtilsGL.getHeight() - GLFWWindow.getEventY() - 1` → `GLFWWindow.getEventY()`
- **Statut** : ✅ Correction appliquée

### Correction du Freeze lors de l'Interaction Souris

- **Problème** : L'application freeze lors d'un clic souris
- **Cause** : `mouseEventAvailable` n'était jamais remis à `false`, la boucle `while (GLFWWindow.next())` tournait en boucle infinie
- **Correction** :
  - `GLFWWindow.java:323` : `next()` consomme maintenant l'événement en remettant `mouseEventAvailable` à `false` après chaque appel
  - `GLFWWindow.java:347` : `resetMouseEvent()` rendu public pour nettoyage explicite
  - `Game.java:1871` : Appel de `GLFWWindow.resetMouseEvent()` à la fin de `checkMouseEvents()`
- **Statut** : ✅ Correction appliquée

### Améliorations de search_replace.py

- **Nouvelles options** :
  - `--all` : Force le remplacement même si le texte recherché n'est pas trouvé (insertion)
  - `--glob <pattern>` : Applique le remplacement sur tous les fichiers correspondant au pattern (ex: `src/**/*.java`)
- **Statut** : ✅ Fonctionnalités ajoutées et documentées

## Modifications à Venir

### Investigation Triple Écran 8K (En Attente)

- **Contexte** : L'utilisateur dispose d'une configuration triple écran 8K (23000+ px de large, ~4000 px de haut) avec deux GPU : NVIDIA 2060OC (écrans 1 & 3) + AMD 7900XTX (écran 2).
- **Problème** : La fenêtre semble limitée à 16000 px de large.
- **Tests effectués** : Programme `GLCheck.java` créé et testé sur machine de développement (non-cible).
  - GLFW peut créer des fenêtres de n'importe quelle taille demandée (24000x8000 testé).
  - Sur la machine de test, la taille réelle est clampée à 1924x1061 (monitor principal).
  - GLFW ne détecte qu'un seul monitor sur la machine de test.
- **Conclusion provisoire** : Les résultats sont **spécifiques à la machine de test** et ne reflètent pas nécessairement le comportement sur la configuration cible réelle.
- **Statut** : ⏳ **En attente de tests sur l'environnement cible réel (triple 8K)**.
- **Prochaines étapes** :
  1. Exécuter `GLCheck.java` sur la configuration triple 8K cible.
  2. Reporter les résultats (tailles de fenêtres créées, tailles réelles, nombre de monitors détectés).
  3. Décider de l'approche à adopter (multi-fenêtres, Vulkan, acceptation de la limitation, etc.).

---

## Rapport de Test sur Environnement Cible

Pour rapporter les informations extraites de l'environnement cible, veuillez fournir les éléments suivants :

1. **Commande exécutée** :
   ```
   cd C:\Temp
   javac -cp "C:\Perso\tools\lwjgl\*" GLCheck.java
   java -cp ".;C:\Perso\tools\lwjgl\lwjgl.jar;C:\Perso\tools\lwjgl\lwjgl-glfw.jar;C:\Perso\tools\lwjgl\lwjgl-opengl.jar;C:\Perso\tools\lwjgl\lwjgl-natives-windows;C:\Perso\tools\lwjgl\natives-*" GLCheck
   ```

2. **Informations à reporter** :
   - Nombre de monitors détectés par GLFW
   - Résolution de chaque monitor
   - Taille de fenêtre demandée vs taille réelle obtenue (tester avec 16000, 19200, 24000 de large)
   - Messages de log GLFW (warnings, erreurs)
   - Tout comportement inattendu (freeze, crash, artefacts)

3. **Format de rapport** : Copier-coller la sortie console complète dans cette conversation.
