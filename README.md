#BeYourHero


## Overview

This project implements a game where players make decisions that affect the outcome of the story. The game simulated the highly anticipated olympic games set to take place in Paris.

#Structure:
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── Duel
│   │   │   │   │   ├── Game.java
│   │   │   │   │   ├──Main.java
│   │   │   │   │   ├──Scan.java
│   │   │   │   │   ├── InputException.java
│   │   │   │   │   ├──CharacterSelectionListener.java
│   │   │   ├── Representation 
│   │   │   │   ├── SoundNode.java
│   │   │   │   ├── ImageNode.java
│   │   │   │   ├── Node.java
│   │   │   │   ├── InnerNode.java
│   │   │   │   ├── DecisionNode.java
│   │   │   │   ├── TerminalNode.java
│   │   │   │   ├── ChanceNode.java
│   │   │   │   ├── DecisionNodeTest.java
│   │   │   │   ├── InvalidNodeArgument.java
│   │   │   │   ├── Event.java
│   │   │   │   ├── DecorateurEvent.java
│   │   │   ├── Univers
│   │   │   │   ├── Coach.java
│   │   │   │   ├── Player.java
│   │   │   │   ├──Juge.java
│   │   │   │   ├── PersonnageDeBase.java
│   │   │   │   ├── Sportif.java
│   │   │   │   ├── Sport.java
│   │   │   │   ├── PlayerTest.java
│   │   │   │   ├── Map1.java
│   │   │   │   ├── ArrayListString.java
│   │   │   │   ├──ArrayListStringTest.java
│   │   │   │   ├── Supporteur.java
├── resources
│   ├── images
│       ├── coach.jpeg
│       ├── sportif.jpeg
│       ├── closing1.jpeg
│       ├── supporteur.jpeg
│       ├──judge.jpeg
│       ├── arc.png
│       ├── tour.jpeg
│       ├── bienvenue.png
│       ├── essai.wav
├── README.md




## Instructions

### Compilation

To compile the project, ensure you have Java installed on your system. Use the following command in the terminal:

cd file location on your computer
javac -d bin src/duel/*.java src/Univers/*.java src/representation/*.java

###Execution
java -cp bin Duel.Main


###Use
 
Enter the corrects inputs that are asked on the screen to play.
