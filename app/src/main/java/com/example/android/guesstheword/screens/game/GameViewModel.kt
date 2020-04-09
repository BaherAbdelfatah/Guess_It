package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel()
{
    // The current word
    val word = MutableLiveData<String>()

    // The current score
    val score = MutableLiveData<Int>()
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel","GameViewModel created!")
        resetList()
        nextWord()
        score.value = 0
    }

    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            //gameFinished()
        } else {
            word.value = wordList.removeAt(0)
        }
    }

    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","GameViewModel destroyed!")
    }
}
