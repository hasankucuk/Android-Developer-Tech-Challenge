package com.techchallange.market_state_textview

enum class State(val state: String) {
    SUCCESS("Yolda"), PENDING("Onay Bekliyor"), PREPARING("Hazırlanıyor");

    companion object {
        private val lookup = HashMap<String, State>()

        init {
            State.values().map { lookup.put(it.state, it) }
        }

        fun getFromValue(value: String):State {
            return lookup[value]!!
        }
    }
}