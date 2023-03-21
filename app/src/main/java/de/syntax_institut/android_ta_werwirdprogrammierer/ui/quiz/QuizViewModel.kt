package de.syntax_institut.android_ta_werwirdprogrammierer.ui.quiz

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.android_ta_werwirdprogrammierer.data.QuizRepository
import de.syntax_institut.android_ta_werwirdprogrammierer.data.model.Question

/**
 * Das ViewModel kümmert sich um die Logik des Spiels.
 * Es ruft dabei >keine< Variablen oder Funktionen aus dem QuizFragment auf
 */
class QuizViewModel : ViewModel() {

    // Erstelle eine QuizRepository Instanz
    private val repository = QuizRepository()

    // Lade die Liste mit den Question Informationen aus der QuizRepository Instanz
    private val questionList = repository.list

    // Der Index zeigt die Position der aktuellen Frage in der Liste
    private var _questionIndex = MutableLiveData<Int>(0)
    val questionIndex: LiveData<Int>
        get() = _questionIndex

    // Diese Variable speichert die aktuelle Frage
    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    // Diese Variable speichert die aktuelle Preisstufe
    private var _currentPrice = MutableLiveData<Int>()
    val currentPrice: LiveData<Int>
        get() = _currentPrice

    // Diese Variable speichert, ob das Spiel vorbei ist
    private var _gameOver = MutableLiveData<Boolean>()
    val gameOver: LiveData<Boolean>
        get() = _gameOver

    init {
        _currentQuestion.value = questionList.value?.get(0)
        _currentPrice.value = _currentQuestion.value?.price
    }

    /**
     * Diese Funktion setzt alle Variablen auf ihren Ausgangswert zurück
     */
    private fun resetGame() {
        _questionIndex.value = 0
        _currentQuestion.value = questionList.value?.get(0)
        _currentPrice.value = 0
    }

    /**
     * Diese Funktion überprüft, ob die Frage richtig oder falsch beantwortet wurde und setzt die
     * Variablen dementsprechend
     */
    fun checkAnswer(answerIndex: Int) {
        if (answerIndex == _currentQuestion.value?.rightAnswer) {
            _questionIndex.value = _questionIndex.value!! + 1
            _currentQuestion.value = questionList.value!![_questionIndex.value!!]
            _currentPrice.value = _currentQuestion.value!!.price
        }else {
            _gameOver.value = true
            resetGame()
        }
    }
}
