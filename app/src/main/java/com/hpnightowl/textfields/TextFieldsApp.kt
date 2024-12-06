package com.hpnightowl.textfields

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hpnightowl.textfields.types.TextFieldsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldsApp(
    onSendNotification: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    // Notification Action
                    IconButton(onClick = onSendNotification) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Send Notification"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        TextFieldsList(Modifier.padding(paddingValues))
    }
}



