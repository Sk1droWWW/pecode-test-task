package com.example.pecodeTestTask.item

interface OnItemFragmentListener {
    fun addFragment()
    fun removeFragment()
    fun createNotification(id: Int?)
    fun removeNotification(id: Int?)
}