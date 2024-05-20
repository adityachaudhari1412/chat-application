

package com.google.firebase.quickstart.vertexai.feature.functioncalling

import androidx.compose.runtime.toMutableStateList

class FunctionsChatUiState(
    messages: List<FunctionsChatMessage> = emptyList()
) {
    private val _messages: MutableList<FunctionsChatMessage> = messages.toMutableStateList()
    val messages: List<FunctionsChatMessage> = _messages

    fun addMessage(msg: FunctionsChatMessage) {
        _messages.add(msg)
    }

    fun replaceLastPendingMessage() {
        val lastMessage = _messages.lastOrNull()
        lastMessage?.let {
            val newMessage = lastMessage.apply { isPending = false }
            _messages.removeLast()
            _messages.add(newMessage)
        }
    }
}
