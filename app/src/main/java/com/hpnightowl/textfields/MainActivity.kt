package com.hpnightowl.textfields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hpnightowl.textfields.notification.NotificationUtils
import com.hpnightowl.textfields.ui.theme.TextfieldsTheme
import android.Manifest
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            NotificationUtils.sendDirectReplyNotification(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NotificationUtils.createNotificationChannel(this)

        setContent {
            TextfieldsTheme {
                TextFieldsApp(
                    onSendNotification = { checkAndRequestNotificationPermission() }
                )
            }
        }
    }

    private fun checkAndRequestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            NotificationUtils.sendDirectReplyNotification(this)
        }
    }
}
