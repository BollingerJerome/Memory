# MEMORY GAME
Gruppenarbeit Mechatronik Trinational, Promotion Eiffel, Herbstsemester 2020

### TEAM
`Burtschy Alexis` Programmierer / GUI-Design\
`Bollinger Jérôme` Programmierer / Software Architekt\
`Kissling Mischa` Programmierer / SCRUM Master\
`Pröbsting Jonas` Programmierer / GUI-Design\
`Wyser Jennifer` Programmiererin / Product Owner

## Inhaltsverzeichnis

1. [Einleitung](#Einleitung)
2. [Ziel](#Ziel)
3. [Randbedingungen](#Randbedingungen)
4. [Definition of Ready DoR](#Definition-of-Ready-DoR)
5. [Definition of Done DoD](#Definition-of-Done-DoD)
6. [Build-Anleitung](#Build-Anleitung)
7. [Bedienungsanleitung](#Bedienungsanleitung)
8. [User Stories](#User-Stories)
9. [Releaseplan](#Releaseplan)
10. [Dokumentation Sprint 1](#Dokumentation-Sprint-1)
    + [Taskliste für die Umsetzung der Userstories](#Taskliste-für-die-Umsetzung-der-User-Stories)
    + [Anreicherung der User Stories für die Umsetzung](#Anreicherung-der-User-Stories-für-die-Umsetzung)
    + [Dokumentation wichtiger Code Snippets](#Dokumentation-wichtiger-Code-Snippets)
    + [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories](#Herleitung-der-Testfälle-aus-den-Akzeptanzkriterien-der-User-Stories)
11. [Dokumentation Sprint 2](#Dokumentation-Sprint-2)
    + [Taskliste für die Umsetzung der Userstories](#Taskliste-für-die-Umsetzung-der-User-Stories)
    + [Anreicherung der User Stories für die Umsetzung](#Anreicherung-der-User-Stories-für-die-Umsetzung)
    + [Dokumentation wichtiger Code Snippets](#Dokumentation-wichtiger-Code-Snippets)
    + [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories](#Herleitung-der-Testfälle-aus-den-Akzeptanzkriterien-der-User-Stories)

## Einleitung

Dieses Git-Repository ist im Rahmen der Gruppenarbeit in den Kursen Software Engineering und Informatik II entstanden.
Die Aufgabenstellung besteht darin, eine Java respektive JavaFX Programm zu erstellen, welches auf dem Desktop eines Computers laufen kann. Wir haben uns dazu entschieden, Memory, ein in der Praxis sehr einfaches Spiel zu digitalisieren.

## Ziel

Im Rahmen des Modules Software Engineering und Informatik II entwickeln wir Studierenden eine etwas komplexere Software, um den gelernten Stoff durch die Implemetierung einer lauffähigen Applikation zu vertiefen. Dabei wird die Komplexität der Apllikation auf die individuellen Vorkenntnisse der Stidierenden abgestimmt.

## Randbedingungen

`Programmiersprache`    JAVA\
`Test Coverage` Mit Unit Tests mindestens 50%\
`Blackbox Testing` Manuell mit Testfällen und Protokoll\
`Source Code Management` GitHub\
`Git-Workflow` Vincent Driessen\
`Build Automation` Maven\
`Vorgehensmodell` SCRUM\
`Anforderungen` Epic und User Stories mit Akzeptanzkriterien\
`Aufwandschätzung` Story Points für User Stories und Stundenschätzungpro Sprint und Task\
`Langfristige Planung` Releaseplan\
`Kurzfristige Planung` Pro Sprint\
`Design Artefakte` UML - Unified Modelling Language

## Definition of Ready DoR

- Backlog Items sind für jeden Beteiligten klar verständlich
- Jedes Backlog Item ist geschätzt.
- Jedes Backlog Item hat Akzeptanzkriterien
- Jedes Backlog Item hat eine Priorisierung

## Definition of Done DoD

- Alle Akzeptanzkriterien wurden erfüllt
- Dokumentation wurde durchgeführt

## Build-Anleitung
**Muss noch angepasst werden**

1. Laden Sie die .jar-Datei von unserem GitHub Repository herunter
2. Entpacken Sie diese in den gewünschten Ordner
3. Stellen Sie sicher, dass Sie ein Java Runtime Environment auf Ihrem Computer installiert haben
4. Kopieren Sie den Pfad der gewünschten Versionsdatei (.jar) in die Zwischenablage
5. Öffnen Sie die Konsole Ihres Rechners
6. Geben Sie dort java -jar gefolgt von dem kopierten Pfad ein

Beispiel: java -jar C:\Users\Max Mustermann\Downloads\trinat\memory.jar

7. Bestätigen Sie ihre Eingabe mit Enter

## Bedienungsanleitung



## User Stories

| **User Story Nr.** |   **User Story** | **Akzeptanzkriterien**  | **Storypoints**  |  **Priorität** |
|:-:|---|--------|:-:|:-:|
| 1 | Als Spieler möchte ich das Solospiel auswählen um die Spielgrösse festzulegen | 1 Button um Spielmodus auszuwählen <br/><br/> Weiterleitung zum Fenster der Spielfeldgrösse | 2 | 2 |
| 2 | Als Spieler möchte ich die Spielgrösse auswählen um das Spiel zu starten | min. 3 Buttons zur Spielfeldgrösse (4x4, 6x6, 8x8) <br/> Spiel startet mit entsprechender Grösse | 5 | 2 |
| 3 | Als Spieler möchte ich meine Spielzeiten sehen um im Solospiel meine Zeiten mit vorangegangenen zu vergleichen | Zeit wird fortlaufend im Spiel angezeigt <br/> Zeit ist korrekt | 13 | 4 |
| 4 | Als Spieler möchte ich den Multiplayer-Modus auswählen um die Spielart festzulegen | 1 Button für Multiplayermodus <br/> Weiterleitung zum Fenster der Spielfeldgrösse | 2 | 3 |
| 5 | Als Spieler möchte ich die Spieleranzahl auswählen um die Spielgrösse festzulegen | 3 Buttons zur Wahl der Spieleranzahl (2, 3, 4 Spieler) <br/> Startet Spiel mit der gewählten Anzahl an Spielern | 5 | 3 |
| 6 | Als Spieler möchte ich die Spielgrösse auswählen um das Spiel zu starten | min. 3 Buttons zur Spielfeldgrösse (6x6, 8x8, 10x10) <br/> Spiel startet mit entsprechender Grösse | 5 | 3 |
| 7 | Als Spieler möchte ich meinen Namen eingeben um im Multiplayermodus zu sehen, wer am Zug ist | Entsprechende Anzahl an TextFields gemäss der Spieleranzahl <br/> Anzeige des Spielernamens während des Spieles | 8 | 2 |
| 8 | Als Spieler möchte ich die Rangliste sehen um im Multiplayermodus meine Platzierung zu sehen | Anzeige der besten 10 Resultate am Spielende | 21 | 4 |
| 9 |Als Spieler möchte ich zu jedem Zeitpunkt ins Hauptmenü zurück um die Spieleinstellungen zu ändern | 1 Button welcher auf jedem Interface zu sehen ist <br\> Hauptmenü wird angezeigt | 3 | 2 |
| 10 | Als Spieler möchte ich Memory mit Bildern spielen um eine schönere Oberfläche zu haben | Min 50 Bilder für Spielgrösse 10x10  <br\> Jede Karte ist wenn sie aufgedeckt wird ein Bild <br\> Spielbrett verhält sich wie Memory | 8 | 2 |
| 11 | Als Spieler möchte ich mein Spiel pausieren um die Spielzeit gering zu halten, wenn ich vom Spiel weg muss | 1 Button um Spiel zu pausieren <br\> Pausebildschirm erscheint wenn Spiel pausiert | 8 | 4 |
| 12 | Als Spieler möchte ich eine Karte umdrehen um zu sehen was sich auf der Karte befindet | Ansicht der zugedeckten Karten <br\> Memoryverhalten | 21 | 1 |
| 13 | Als Spieler möchte ich ein Fenster um die Spielstatistiken zu sehen | Anzeige der Spielzeit, der gefundenen Paare… | 21 | 3 |
| 14 | Als Spieler möchte ich das Spiel jederzeit verlasssen können um das Spiel zu beenden | 1 Button um Spiel zu verlassen <br\> Spiel wird verlassen | 5 | 1 |

## Releaseplan

| **Release 1** |   **Release 2** | **Release 3**  |
|:-:|:-:|:-:|
|User Story X|-|-|
|-|User Story Y|-|
|-|-|:User Story Z|
|-|User Story A|-|
|User Story B|-|-|

## Dokumentation Sprint 1

#### Taskliste für die Umsetzung der User Stories
#### Anreicherung der User Stories für die Umsetzung
#### Dokumentation wichtiger Code Snippets
#### Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories

## Dokumentation Sprint 2

#### Taskliste für die Umsetzung der User Stories
#### Anreicherung der User Stories für die Umsetzung
#### Dokumentation wichtiger Code Snippets
#### Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories

