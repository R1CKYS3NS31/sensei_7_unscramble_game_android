package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private var _score = 0
    val score: Int get() = _score
    private var _currentWordCount = 0
    val currentWordCount: Int get() = _currentWordCount
    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String get() = _currentScrambledWord
    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord,false)){
            tempWord.shuffle()
        }
        if (wordList.contains(currentWord)){
            getNextWord()
        }else{
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }

    init {
        Log.d("GameFragment","GameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment","GameViewModel destroyed!")
    }

    private val wordList:MutableList<String> = mutableListOf()
    private lateinit var currentWord:String

}
