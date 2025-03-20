package com.example.music_store

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music_store.ui.UserViewModel

@Composable
fun RegistrationScreen(
    viewModel: UserViewModel,
    registrationButtonClicked: () -> Unit
){
    val color = MaterialTheme.colorScheme.onPrimaryContainer
    val state by viewModel.uiState.collectAsState()
    var flag by remember { mutableStateOf(false) }
    val title = if (flag) stringResource(R.string.registration) else stringResource(R.string.login)
    val buttonText = if (flag) stringResource(R.string.login) else stringResource(R.string.registration)
    var fieldColor by remember { mutableStateOf(color) }
    val emailPattern = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")

    val registration = stringResource(R.string.registration)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 50.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        OutlinedTextField(
            value = state.login,
            onValueChange = { newText ->
                viewModel.updateLogin(newText)
            },
            label = { Text(stringResource(R.string.email)) },
            textStyle = MaterialTheme.typography.titleLarge.copy(
                color = fieldColor
            ),
            maxLines = 1,
            modifier = Modifier.width(300.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = state.password,
            onValueChange = { newText ->
                viewModel.updatePassword(newText)
            },
            label = { Text(text = stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = MaterialTheme.typography.titleLarge.copy(
                color = fieldColor
            ),
            maxLines = 1,
            modifier = Modifier.width(300.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = {
                if(viewModel.checkUser() && title!=registration){
                    registrationButtonClicked()
                }
                else if(title == registration && state.login.matches(emailPattern) && state.password.isNotEmpty() && !viewModel.checkUserLogin()){
                    viewModel.regUser()
                    registrationButtonClicked()
                }
                else{
                    fieldColor = Color.Red
                }
            },
            modifier = Modifier.width(150.dp)) {
            Text(
                text = "OK",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = buttonText,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.clickable(onClick = {flag = !flag})
        )
    }
}
