package com.hpnightowl.textfields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

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

@Composable
fun TextFieldsList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Multi-line text fields
        CustomTextField(
            label = "Multi-line None",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                imeAction = ImeAction.None
            ),
            isMultiLine = true
        )

        CustomTextField(
            label = "Multi-line Send",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                imeAction = ImeAction.Send
            ),
            isMultiLine = true
        )

        // Short message text fields
        CustomTextField(
            label = "Short Message Send",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                imeAction = ImeAction.Send
            )
        )

        // Email fields
        CustomTextField(
            label = "Email Address",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )

        // URI fields
        CustomTextField(
            label = "URI",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Go
            )
        )

        // Phone fields
        CustomTextField(
            label = "Phone",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )

        // Number fields
        CustomTextField(
            label = "Number",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Send
            )
        )

        // Password fields
        CustomTextField(
            label = "Password",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        // Auto-complete field
        AutoCompleteTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteTextField() {
    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val suggestions = listOf("United States", "United Kingdom", "Germany", "France", "Italy")
    val filteredSuggestions = suggestions.filter { it.contains(text, ignoreCase = true) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                expanded = true
            },
            label = { Text("Country") },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        if (filteredSuggestions.isNotEmpty()) {
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                filteredSuggestions.forEach { suggestion ->
                    DropdownMenuItem(
                        text = { Text(suggestion) },
                        onClick = {
                            text = suggestion
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CustomTextField(
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isMultiLine: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        keyboardOptions = keyboardOptions,
        singleLine = !isMultiLine,
        visualTransformation = visualTransformation
    )
}