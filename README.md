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
    + [Taskliste für die Umsetzung der Userstories Sprint 1](#Taskliste-für-die-Umsetzung-der-User-Stories-Sprint-1)
    + [Dokumentation wichtiger Code Snippets Sprint 1](#Dokumentation-wichtiger-Code-Snippets-Sprint-1)
    + [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories Sprint 1](#Herleitung-der-Testfälle-aus-den-Akzeptanzkriterien-der-User-Stories-Sprint-1)
11. [Dokumentation Sprint 2](#Dokumentation-Sprint-2)
    + [Taskliste für die Umsetzung der Userstories Sprint 2](#Taskliste-für-die-Umsetzung-der-User-Stories-Sprint-2)
    + [Dokumentation wichtiger Code Snippets Sprint 2](#Dokumentation-wichtiger-Code-Snippets-Sprint-2)
    + [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories Sprint 2](#Herleitung-der-Testfälle-aus-den-Akzeptanzkriterien-der-User-Stories-Sprint-2)
12. [Dokumentation Sprint 3](#Dokumentation-Sprint-3)
    + [Taskliste für die Umsetzung der Userstories Sprint 3](#Taskliste-für-die-Umsetzung-der-User-Stories-Sprint-3)
    + [Dokumentation wichtiger Code Snippets Sprint 3](#Dokumentation-wichtiger-Code-Snippets-Sprint-3)
    + [Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories Sprint 3](#Herleitung-der-Testfälle-aus-den-Akzeptanzkriterien-der-User-Stories-Sprint-3)

## Einleitung

Dieses Git-Repository ist im Rahmen der Gruppenarbeit in den Kursen Software Engineering und Informatik II entstanden.
Die Aufgabenstellung besteht darin, ein Java- beziehungsweise ein JavaFX Programm zu erstellen. Man soll es über GitHub herunterladden können, um es auf dem Desktop eines Computers zu spielen.
Wir haben uns dazu entschieden, Memory, ein in der Praxis sehr einfaches Spiel zu digitalisieren.

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

- Jedes Backlog Item ist für jeden Beteiligten klar verständlich
- Jedes Backlog Item ist geschätzt
- Jedes Backlog Item hat eine Priorisierung
- Jedes Backlog Item hat Akzeptanzkriterien

## Definition of Done DoD

- Alle Akzeptanzkriterien wurden erfüllt
- Dokumentation wurde durchgeführt

## Build-Anleitung

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
| 2 | Als Spieler möchte ich die Spielgrösse auswählen um das Spiel zu starten | min. 3 Buttons zur Spielfeldgrösse (4x4, 6x6, 8x8) <br/><br/> Spiel startet mit entsprechender Grösse | 5 | 2 |
| 3 | Als Spieler möchte ich meine Spielzeiten sehen um im Solospiel meine Zeiten mit vorangegangenen zu vergleichen | Zeit wird fortlaufend im Spiel angezeigt <br/><br/> Zeit ist korrekt | 13 | 4 |
| 4 | Als Spieler möchte ich den Multiplayer-Modus auswählen um die Spielart festzulegen | 1 Button für Multiplayermodus <br/><br/> Weiterleitung zum Fenster der Spielfeldgrösse | 2 | 3 |
| 5 | Als Spieler möchte ich die Spieleranzahl auswählen um die Spielgrösse festzulegen | 3 Buttons zur Wahl der Spieleranzahl (2, 3, 4 Spieler) <br/><br/> Startet Spiel mit der gewählten Anzahl an Spielern | 5 | 3 |
| 6 | Als Spieler möchte ich die Spielgrösse auswählen um das Spiel zu starten | min. 3 Buttons zur Spielfeldgrösse (6x6, 8x8, 10x10) <br/><br/> Spiel startet mit entsprechender Grösse | 5 | 3 |
| 7 | Als Spieler möchte ich meinen Namen eingeben um im Multiplayermodus zu sehen, wer am Zug ist | Entsprechende Anzahl an TextFields gemäss der Spieleranzahl <br/><br/> Anzeige des Spielernamens während des Spieles | 8 | 2 |
| 8 | Als Spieler möchte ich die Rangliste sehen um im Multiplayermodus meine Platzierung zu sehen | Anzeige der besten 10 Resultate am Spielende | 21 | 4 |
| 9 |Als Spieler möchte ich zu jedem Zeitpunkt ins Hauptmenü zurück um die Spieleinstellungen zu ändern | 1 Button welcher auf jedem Interface zu sehen ist <br/><br/> Hauptmenü wird angezeigt | 3 | 2 |
| 10 | Als Spieler möchte ich Memory mit Bildern spielen um eine schönere Oberfläche zu haben | Min 50 Bilder für Spielgrösse 10x10  <br/><br/> Jede Karte ist wenn sie aufgedeckt wird ein Bild <br/><br/> Spielbrett verhält sich wie Memory | 8 | 2 |
| 11 | Als Spieler möchte ich mein Spiel pausieren um die Spielzeit gering zu halten, wenn ich vom Spiel weg muss | 1 Button um Spiel zu pausieren <br/><br/> Pausebildschirm erscheint wenn Spiel pausiert | 8 | 4 |
| 12 | Als Spieler möchte ich eine Karte umdrehen um zu sehen was sich auf der Karte befindet | Ansicht der zugedeckten Karten <br/><br/> Memoryverhalten | 21 | 1 |
| 13 | Als Spieler möchte ich ein Fenster um die Spielstatistiken zu sehen | Anzeige der Spielzeit, der gefundenen Paare, etc. | 21 | 3 |
| 14 | Als Spieler möchte ich das Spiel jederzeit verlasssen können um das Spiel zu beenden | 1 Button um Spiel zu verlassen <br/><br/> Spiel wird verlassen | 5 | 1 |

## Releaseplan

Velocity: 40 StoryPoints pro Iteration

| **Release 1** |   **Release 2** | **Release 3**  |
| :-: | :-: | :-: |
| User Story 1 | User Story 6 | User Story 3 |
| User Story 2 | User Story 7 | User Story 8 |
| User Story 4 | User Story 9 | User Story 11 |
| User Story 5 | User Story 10 | |
| User Story 12 | User Story 13 | |
| User Story 14 | | |
| | | |
| **39 Story Points** | **45 Story Points** | **42 Story Points** |

## Dokumentation Sprint 1

### Taskliste für die Umsetzung der User Stories Sprint 1

#### User Story 1
Als Spieler möchte ich das Solospiel auswählen um die Spielgrösse festzulegen

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 1.1 | GUI-Design, 1 Button für Spielmodus | 0.5 |
| 1.2 | Kontrollstruktur | 1 |

#### User Story 2
Als Spieler möchte ich die Spielgrösse auswählen um das Spiel zu starten

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 2.1 | GUI-Design, min. 3 Buttons für Spielgrösse | 0.75 |
| 2.2 | Kontrollstruktur | 1.5 |

#### User Story 4
Als Spieler möchte ich den Multiplayer-Modus auswählen um die Spielart festzulegen

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 4.1 | GUI-Design, 1 Button für Spielmodus | 0.75 |
| 4.2 | Kontrollstruktur | 2 |

#### User Story 5
Als Spieler möchte ich die Spieleranzahl auswählen um die Spielgrösse festzulegen

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 5.1 | GUI-Design, 3 Buttons für Spieleranzahl | 0.5 |
| 5.2 | Kontrollstruktur | 3 |

#### User Story 12
Als Spieler möchte ich eine Karte umdrehen um zu sehen was sich auf der Karte befindet

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 12.1 | Kartenrücken programmieren | 4 |
| 12.2 | Logik einbinden | 6 |
| 12.3 | Gleiche Paare bleiben offen liegen | 2 |
| 12.4 | Karten werden bei Klick wieder zugedeckt | 3 |

#### User Story 14
Als Spieler möchte ich das Spiel jederzeit verlasssen können um das Spiel zu beenden

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 14.1 | GUI-Design, 1 Button für Spiel verlassen | 0.5 |
| 14.2 | Kontrollstruktur | 0.5 |

### Dokumentation wichtiger Code Snippets Sprint 1

#### Im Sprint 1 wurde als erstes die Welcome Scene erstellt. Im Nachfolgenen Bild kann man den Code zu diesem Interface sehen.

![Image for Welcome Scene](https://github.com/BollingerJerome/Memory/blob/master/src/main/resources/Documentation/Welcome%20Scene.PNG)

#### Ein weiterer wichtiger Punkt im Sprint 1 war der EventHandler
![Image for EventHandler](https://github.com/BollingerJerome/Memory/blob/master/src/main/resources/Documentation/eventHandler%20snippet.PNG)


#### Ebenfalls wichtig in Sprint 1 waren die ganzen Attribute

![Image for Board Class Attributes](https://github.com/BollingerJerome/Memory/blob/master/src/main/resources/Documentation/boardClass%20attributes.PNG)


### Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories Sprint 1

## Dokumentation Sprint 2

### Taskliste für die Umsetzung der User Stories Sprint 2

#### User Story 6
Als Spieler möchte ich die Spielgrösse auswählen um das Spiel zu starten

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 6.1 | GUI-Design, min. 3 Buttons für Spielgrösse | 0.75 |
| 6.2 | Kontrollstruktur | 1.5 |

#### User Story 7
Als Spieler möchte ich meinen Namen eingeben um im Multiplayermodus zu sehen, wer am Zug ist

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 7.1 | GUI-Design, TextFields für Namenseingabe | 2 |
| 7.2 | Kontrollstruktur | 3 |

#### User Story 9
Als Spieler möchte ich zu jedem Zeitpunkt ins Hauptmenü zurück um die Spieleinstellungen zu ändern

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 9.1 | GUI-Design, 1 Button für Hauptmenü | 0.75 |
| 9.2 | Kontrollstruktur | 1 |

#### User Story 10
Als Spieler möchte ich Memory mit Bildern spielen um eine schönere Oberfläche zu haben

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 10.1 | Bilder aussuchen, min. 50 Stk. | 1.5 |
| 10.2 | Karten aus Bildern fertigen | 1 |
| 10.3 | Events den Karten hinzufügen, Memoryverhalten | 4 |

#### User Story 13
Als Spieler möchte ich ein Fenster um die Spielstatistiken zu sehen

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 13.1 | Momentane Statistik im GUI einbinden | 2 |

### Dokumentation wichtiger Code Snippets Sprint 2

![Image for Multiplayer](https://github.com/BollingerJerome/Memory/blob/master/src/main/resources/Documentation/Multiplayer_snippet.PNG)
![Image for Sorting algorithm for randomize method](https://github.com/BollingerJerome/Memory/blob/master/src/main/resources/Documentation/sorting%20algorithm%20for%20randomize%20method.PNG)
![Image for Turning cards method](https://github.com/BollingerJerome/Memory/blob/master/src/main/resources/Documentation/turning%20cards%20method.PNG)

### Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories Sprint 2

## Dokumentation Sprint 3

### Taskliste für die Umsetzung der User Stories Sprint 3

#### User Story 3
Als Spieler möchte ich meine Spielzeiten sehen um im Solospiel meine Zeiten mit vorangegangenen zu vergleichen

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 3.1 | Zeit im GUI anzeigen | 0.5 |
| 3.2 | Zeit messen/berechnen | 1 |

#### User Story 8
Als Spieler möchte ich die Rangliste sehen um im Multiplayermodus meine Platzierung zu sehen

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 8.1 | Spielstatistik speichern | 4 |
| 8.2 | Spielstatistiken der vergangenen Spiele lesen | 1.5 |
| 8.3 | Spielstatistiken der vergangenen Spiele ausgeben | 1.5 |

#### User Story 11
Als Spieler möchte ich mein Spiel pausieren um die Spielzeit gering zu halten, wenn ich vom Spiel weg muss

| **Task** |   **Beschreibung** | **Zeitaufwand in Stunden**  |
| :-: | - | :-: |
| 11.1 | GUI-Design | 0.5 |
| 11.2 | Kontrollstruktur (Zeit anhalten/fortsetzen) | 1.5 |

### Dokumentation wichtiger Code Snippets Sprint 3
### Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories Sprint 3
