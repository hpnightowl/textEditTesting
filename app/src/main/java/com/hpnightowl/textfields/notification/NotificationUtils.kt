package com.hpnightowl.textfields.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import com.hpnightowl.textfields.MainActivity
import com.hpnightowl.textfields.R

object NotificationUtils {
    private const val CHANNEL_ID = "TextFields"
    private const val REPLY_ACTION = "REPLY_ACTION"
    private const val KEY_REPLY = "key_reply"

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "TextFields Channel"
            val descriptionText = "Channel for TextFields notifications"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendDirectReplyNotification(context: Context) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val remoteInput = RemoteInput.Builder(KEY_REPLY)
            .setLabel("Reply")
            .build()

        val replyIntent = Intent(context, MainActivity::class.java)
        val replyPendingIntent = PendingIntent.getActivity(
            context,
            0,
            replyIntent,
            PendingIntent.FLAG_MUTABLE
        )

        val action = NotificationCompat.Action.Builder(
            android.R.drawable.ic_dialog_email,
            "Reply",
            replyPendingIntent
        )
            .addRemoteInput(remoteInput)
            .build()

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Direct Reply")
            .setContentText("Try the direct reply feature")
            .addAction(action)
            .build()

        NotificationManagerCompat.from(context).notify(1, notification)
    }
}