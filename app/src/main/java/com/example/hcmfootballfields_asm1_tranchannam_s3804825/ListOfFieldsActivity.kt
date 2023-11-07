package com.example.hcmfootballfields_asm1_tranchannam_s3804825

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.modals.ThemeViewModel

@Composable
fun ListOfFieldsScreen(navController: NavController) {
    val themeViewModel: ThemeViewModel = viewModel()

    // Observe the theme state
    val isDarkTheme = themeViewModel.isDarkTheme.value
    AppTheme(useDarkTheme = isDarkTheme) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Button(onClick = { navController.navigate("login_screen") }) {
                Text("go back")
            }
            Text("This is the Second Screen")
        }

    }
}