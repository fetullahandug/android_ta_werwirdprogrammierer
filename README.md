# Aufgaben

## Android_TA_WerWirdProgrammierer


In dieser Aufgabe vereinfachen wir die bekannte App “Wer wird Programmierer?” mithilfe von Live Data.<br />
Außerdem wird statt einem End-Dialog bei Spielende ein neues Fragment angezeigt.

<p align="center">
<img height="300" src="https://user-images.githubusercontent.com/97540492/223437378-9394873c-0c33-427f-8005-3406aaf0d6d6.png">
<img height="300" src="https://user-images.githubusercontent.com/97540492/223437402-889eb0d8-1655-4466-baf6-edd7ea201571.png">
</p>

> Nützliche Hinweise:
> - Man spricht den Inhalt einer LiveData-Variablen mit .value an (und kann ihn so auch verändern), z.B.: _number.value<br />
> - Mit  observe() können Variablen aus dem Viewmodel beobachtet werden<br />
> - Nutze folgende Notation, um auf Variablen im ViewModel zugreifen zu können: android:text=“@{viewmodel.dieRichtigeVariable}”<br />
> - Du kannst zusätzlich zur Variablen noch weitere Zeichen hinzufügen (z.B. “€”) -> “@{... + \`€\`}

* Speichere die Rückgabe von loadQuestions() in QuizRepository als LiveData-Variable "questions"


* Greife in Quizmodel auf "questions" zurück und speichere sie in einer Variable "questionsList"
* Initialisiere "questionIndex" 
* Erstelle 3 LiveData-Variablen. Initialisiere - "currentQuestion" mit dem ersten Objekt aus der Liste, "currentPrice" wie "currentQuestion" und "gameOver" auf false


* Schreibe restartGame() - setze darin alle Variablen von eben auf die Anfangswerte
* Schreibe checkAnswer(index_gewählte_Antwort) - <br />
  Erhöhe questionIndex, hole das neue Question Objekt und die neue Preisstufe daraus, falls index_gewählte_Antwort gleich dem index der im Question Objekt gespeicherten richtigen Antwort.<br />
  Falls nicht, setze gameOver und starte neu


* Setze im Quizfragment onClickListener auf alle Antwortmöglichkeiten. Rufe jeweils checkAnswer() auf und übergebe jeweils die Zahl (A=1, B=2, etc.)
* Beobachte gameOver und navigiere zum ResultFragment, falls true


* Benutze LiveData im Layout und setze alle TV text Attribute auf die entsprechende Variable aus dem Question Object der aktuellen Frage


Achte auf sauberen und gut lesbaren Code verwende Kommentare.
