package com.oskarszymczyk.suhero.utils

import java.util.*
import javax.inject.Inject

class UserInputCallback @Inject constructor() {

    private val TIMER_DELAY_IN_MILLIS = 1000L
    private var timer: Timer = Timer()


    fun waitForInputFinished(function: () -> Unit) {
        timer.cancel()
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                function()
            }
        }, TIMER_DELAY_IN_MILLIS)
    }
}