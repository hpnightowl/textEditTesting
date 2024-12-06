package com.hpnightowl.textfields.types

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldsList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Multi-line cases
        CustomTextField(
            label = "Multi Lines None",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.None,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            ),
            isMultiLine = true
        )

        CustomTextField(
            label = "Multi Lines Send",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            ),
            isMultiLine = true
        )

        CustomTextField(
            label = "Short Message Send Multi Lines",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            ),
            isMultiLine = true
        )

        CustomTextField(
            label = "Multi Lines Search",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            ),
            isMultiLine = true
        )

        CustomTextField(
            label = "Short Message Send",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            )
        )

        // Auto capitalization cases
        CustomTextField(
            label = "Auto Cap None",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.None,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            )
        )

        CustomTextField(
            label = "Auto Cap Send",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            )
        )

        // URI and Email
        CustomTextField(
            label = "URI Go",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Go
            )
        )

        CustomTextField(
            label = "Email Address Done",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )

        // Auto correct cases
        CustomTextField(
            label = "Auto Correct Search",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
                autoCorrect = true
            )
        )

        CustomTextField(
            label = "Auto Correct Next",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                autoCorrect = true
            )
        )

        CustomTextField(
            label = "Auto Correct Previous",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Previous,
                autoCorrect = true
            )
        )

        // Phone fields
        CustomTextField(
            label = "Phone",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )

        CustomTextField(
            label = "Phone No Action",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.None
            )
        )

        // Number fields
        CustomTextField(
            label = "Number Send",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Send
            )
        )

        CustomTextField(
            label = "Number No Action",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.None
            )
        )

        // Password fields
        CustomTextField(
            label = "Password Next",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            isPassword = true
        )

        CustomTextField(
            label = "Visible Password Done",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            isPassword = true,
            passwordVisible = true
        )

        CustomTextField(
            label = "Number Password Send",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),
            isPassword = true
        )

        // Special text fields
        CustomTextField(
            label = "No Suggestions",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Go
            ),
            enableSuggestions = false
        )

        // Capitalization with auto-correction
        CustomTextField(
            label = "Cap Characters with Auto Correction",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                autoCorrect = true
            )
        )

        CustomTextField(
            label = "Cap Words with Auto Correction",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = true
            )
        )

        CustomTextField(
            label = "Cap Sentences with Auto Correction",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            )
        )

        // Special input types
        CustomTextField(
            label = "Email Subject",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        CustomTextField(
            label = "Personal Name",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            )
        )

        CustomTextField(
            label = "Postal Address",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            )
        )

        // Number variations
        CustomTextField(
            label = "Number Signed",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false
            )
        )

        CustomTextField(
            label = "Number Decimal",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )

        CustomTextField(
            label = "Number Signed Decimal",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )

        // Date and time
        CustomTextField(
            label = "Date Time",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        CustomTextField(
            label = "Date",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        CustomTextField(
            label = "Time",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        // Auto-complete fields
        AutoCompleteTextFieldCustom(
            label = "App Completion"
        )

        AutoCompleteTextFieldCustom(
            label = "App Completion No Fullscreen"
        )
    }
}