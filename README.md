# 📘 VaultBorn

Un jeu d'action-aventure 2D développé avec LibGDX, proposant exploration de mondes interconnectés, combat et progression de personnage.

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=java)
![LibGDX](https://img.shields.io/badge/LibGDX-1.12+-red?style=flat-square)
![License](https://img.shields.io/badge/License-Educational-blue?style=flat-square)

---

## 🎮 Présentation du projet

**VaultBorn** est un jeu 2D d'action-RPG où le joueur évolue à travers différents mondes interconnectés (Forêt, Enfer...). Le jeu propose une expérience complète avec système de classes, progression de personnage et sauvegarde automatique.

### ✨ Fonctionnalités principales

- 🎭 **7 classes de personnages jouables** avec statistiques uniques
- 🗺️ **Mondes interconnectés** (ForestWorld, HellWorld) via des portes spéciales
- 💾 **Système de sauvegarde complet** (position, stats, progression)
- 🎒 **Système d'inventaire** du joueur
- 🎵 **Musique d'ambiance dynamique**
- 🏗️ **Architecture modulaire** (Factory Pattern, World System, Screen System)

---

## 📦 Contenu du jeu

### 🧙‍♂️ Classes de personnages

| Classe | Type | Description |
|--------|------|-------------|
| **Lancelot** | Guerrier | Chevalier noble avec haute défense |
| **Juzo** | Guerrier Sombre | Force brute et agilité |
| **Perceval** | Archer | Attaques à distance précises |
| **Mordred** | Mage Obscur | Magie destructrice |
| **Lisa** | Mage Lumière | Sorts de soutien |
| **Merline** | Satyre | Équilibre nature/magie |
| **Monet** | Mage Solaire | Magie de feu |

Chaque classe possède :
- ❤️ Points de vie (HP)
- ⚔️ Attaque et défense
- 🏃 Agilité
- 📊 Système de niveau
- 🎒 Inventaire personnel

### 🌍 Mondes

#### ForestWorld
- Environnement forestier
- Monstres de niveau intermédiaire
- Porte vers HellWorld

#### HellWorld
- Environnement infernal
- Boss Gorgon
- Difficulté accrue
- Porte de retour vers ForestWorld

### 💾 Système de sauvegarde

Le jeu sauvegarde automatiquement :
- 🗺️ Monde actuel
- 🎭 Classe du personnage
- ❤️ HP et statistiques complètes
- 📍 Position exacte (X, Y)
- 📊 Niveau et expérience
- 🎒 Inventaire (extensible)

**Sauvegarde automatique** lors du changement de monde  
**Chargement** via le bouton "Poursuivre la partie" du menu

---

## 🛠️ Technologies utilisées

| Technologie | Usage |
|-------------|-------|
| **Java 17+** | Langage principal |
| **LibGDX** | Framework de jeu multiplateforme |
| **Gradle** | Système de build |
| **Scene2D** | Interface utilisateur |
| **JSON** | Système de sauvegarde |
| **LWJGL3** | Backend desktop |
| **Tiled** | Éditeur de maps |

---

## ⚙️ Prérequis

Avant d'installer le projet, assurez-vous d'avoir :

- ☕ **Java JDK 17+** ([Télécharger](https://adoptium.net/))
- 🔧 **Gradle** (fourni via wrapper)
- 📦 **Git**
- 💻 Machine compatible **LWJGL3** (Windows/Linux/Mac)

---

## 🧩 Installation

### 1️⃣ Cloner le projet

```bash
git clone https://github.com/username/VaultBorn.git
cd VaultBorn
```

### 2️⃣ Lancer le jeu

**Sur Linux/Mac :**
```bash
./gradlew lwjgl3:run
```

**Sur Windows :**
```bash
gradlew.bat lwjgl3:run
```

### 3️⃣ Build pour distribution

```bash
./gradlew lwjgl3:dist
```

Le JAR exécutable se trouvera dans :
```
/lwjgl3/build/lib/VaultBorn.jar
```

---

## 📂 Structure du projet

```
VaultBorn/
├── core/                          # Code principal du jeu
│   └── src/main/java/com/vaultborn/
│       ├── MainGame.java          # Classe principale
│       ├── entities/              # Personnages, mobs, projectiles
│       │   ├── characters/
│       │   │   ├── players/       # 7 classes de joueurs
│       │   │   └── mobs/          # Ennemis
│       │   ├── projectiles/       # Projectiles
│       │   └── stuff/             # Objets et items
│       ├── screens/               # Écrans du jeu
│       │   ├── MainScreen.java
│       │   ├── MenuScreen.java
│       │   ├── SelectPlayerScreen.java
│       │   ├── GameScreen.java
│       │   └── InventoryPlayer.java
│       ├── world/                 # Gestion des mondes
│       │   ├── BaseWorld.java
│       │   ├── ForestWorld.java
│       │   └── HellWorld.java
│       ├── save/                  # Système de sauvegarde
│       │   ├── SaveData.java
│       │   └── SaveManager.java
│       ├── factories/             # Factory Pattern
│       │   └── Factory.java
│       └── managers/              # Gestionnaires (assets, audio...)
│
├── lwjgl3/                        # Launcher desktop
│   └── src/main/java/
│       └── Lwjgl3Launcher.java
│
├── assets/                        # Ressources du jeu
│   ├── menu/                      # Images de menu
│   ├── sounds/                    # Musiques et sons
│   ├── skin/                      # UI Skin (Neon)
│   ├── maps/                      # Maps Tiled (.tmx)
│   ├── backgrounds/               # Fonds d'écran
│   └── [character_folders]/       # Sprites des personnages
│
└── README.md                      # Ce fichier
```

---

## 🎮 Guide d'utilisation

### Menu principal

- **🎮 Jouer** → Sélection de classe → Nouvelle partie
- **▶️ Poursuivre la partie** → Charge la dernière sauvegarde (grisé si aucune sauvegarde)
- **⚙️ Paramètres** → Réglages audio
- **❌ Quitter** → Ferme le jeu

### En jeu

| Commande | Action |
|----------|--------|
| **← →** | Déplacement |
| **Espace** | Saut |
| **A** | Attaque 1 |
| **D** | Attaque 2 |
| **Q** | Attaque 3 |
| **Shift** | Protection |
| **F5** | Sauvegarde manuelle (optionnel) |
| **I** | Inventaire |

### Progression

1. Choisissez votre classe de personnage
2. Explorez ForestWorld
3. Combattez les ennemis pour gagner de l'expérience
4. Trouvez et éliminez les boss pour débloquer les portes
5. Traversez les portes pour changer de monde
6. La progression est sauvegardée automatiquement

---

## 💾 Système de sauvegarde

### Emplacement des fichiers

**Windows :**
```
%USERPROFILE%/.prefs/vaultborn_save
```

**Linux :**
```
~/.prefs/vaultborn_save
```

**Mac :**
```
~/Library/Preferences/vaultborn_save
```

### Utilisation programmatique

**Sauvegarder :**
```java
game.saveGame();
```

**Charger :**
```java
game.loadGame();
```

**Vérifier si une sauvegarde existe :**
```java
boolean hasSave = SaveManager.hasSave();
```

**Supprimer une sauvegarde :**
```java
SaveManager.deleteSave();
```

---

## 🧪 État actuel du projet

### ✅ Fonctionnalités implémentées

- [x] Menu principal interactif
- [x] Sélection de 7 classes de personnages
- [x] 2 mondes complets (Forêt, Enfer)
- [x] Système de combat
- [x] Système de progression (niveau, XP)
- [x] Ennemis avec IA
- [x] Boss avec mécaniques spéciales
- [x] Portes inter-mondes
- [x] Système de sauvegarde/chargement complet
- [x] Musique de fond
- [x] Interface utilisateur (Neon UI)
- [x] Inventaire du joueur

### 🚧 En développement / À venir

- [ ] Support mobile (Android)
- [ ] Nouveaux mondes à explorer
- [ ] Plus d'ennemis et de boss
- [ ] Effets sonores complets
- [ ] Système de quêtes
- [ ] Multijoueur local
- [ ] Options graphiques avancées
- [ ] Achievements/Succès

---

## 🐛 Dépannage

### Le jeu ne se lance pas
```bash
# Vérifier la version de Java
java -version

# Nettoyer et rebuilder
./gradlew clean
./gradlew lwjgl3:run
```

### Problème de sauvegarde
```bash
# Supprimer la sauvegarde corrompue
# Windows: Supprimer %USERPROFILE%/.prefs/vaultborn_save
# Linux/Mac: rm ~/.prefs/vaultborn_save
```

### Erreur de texture/assets
```bash
# Vérifier que le dossier assets/ existe
# Rebuilder le projet
./gradlew lwjgl3:dist
```

---

## 👥 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Forkez le projet
2. Créez une branche (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add AmazingFeature'`)
4. Pushez vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

---

## 👤 Auteur

**Projet VaultBorn**

Développé dans le cadre d'un projet académique  
Étudiant en développement de jeux vidéo


---

## 📜 Licence

Ce projet est sous licence **Educational Use** - Utilisation libre à des fins éducatives et non commerciales.

```
Copyright (c) 2025 VaultBorn Team
Tous droits réservés pour un usage éducatif.
```

---

## 🙏 Remerciements

- **LibGDX** pour le framework
- **Tiled** pour l'éditeur de maps
- **OpenGameArt** pour certaines ressources
- La communauté LibGDX pour le support

---

<div align="center">

**⭐ Si vous aimez ce projet, n'hésitez pas à lui donner une étoile !**

Made with ❤️ and ☕

</div>
