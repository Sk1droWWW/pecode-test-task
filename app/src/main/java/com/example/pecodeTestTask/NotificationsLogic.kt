package com.example.pecodeTestTask

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationsLogic(private val context: Context) {
    private val CHANNEL_ID = "myChannel"
    private val notificationManager: NotificationManager

    fun create(id: Int) {
        val notificationIntent = Intent(context, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            .setAction(Intent.ACTION_DEFAULT)
            .putExtra(NOTIFICATIONS_ID, id)

        val contentIntent = PendingIntent.getActivity(
            context,
            id, notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setContentTitle(context.resources.getString(R.string.notification_title))
            .setContentText(context.resources.getString(R.string.notification_text) + id)
            .setContentIntent(contentIntent)
        notificationManager.notify(id, builder.build())
    }

    fun remove(id: Int?) {
        id?.let { notificationManager.cancel(it) }
    }

    private fun createChannel(id: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                id, context.resources.getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    init {
        notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createChannel(CHANNEL_ID)
    }
}