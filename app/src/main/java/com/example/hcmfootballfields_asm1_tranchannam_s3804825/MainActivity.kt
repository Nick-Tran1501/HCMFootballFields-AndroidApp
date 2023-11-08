package com.example.hcmfootballfields_asm1_tranchannam_s3804825

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.modals.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeViewModel: ThemeViewModel = viewModel()

            // Observe the theme state
            val isDarkTheme = themeViewModel.isDarkTheme.value
            AppTheme(useDarkTheme = isDarkTheme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }

            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController, themeViewModel: ThemeViewModel) {
    val isDarkTheme = themeViewModel.isDarkTheme.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {

            IconButton(onClick = { themeViewModel.toggleTheme() }) {
                Icon(
                    imageVector = if (isDarkTheme) ImageVector.vectorResource(id = R.drawable.light_mode) else ImageVector.vectorResource(
                        id = R.drawable.dark_mode
                    ),
                    contentDescription = "Toggle Theme",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp),
            color = MaterialTheme.colorScheme.primary,
            text = "Welcome To HCM FootFields",
            fontSize = 48.sp,
            lineHeight = 48.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = if (!isDarkTheme) painterResource(id = R.drawable.ballonly) else painterResource(
                id = R.drawable.ballonlydark
            ),
            contentDescription = "Application Icon Theme",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp),
            color = MaterialTheme.colorScheme.secondary,
            text = "Show Your Talents Anywhere and Anytime",
            fontSize = 24.sp,
            lineHeight = 48.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { navController.navigate("list_of_fields") },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Let's Start")
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val themeViewModel: ThemeViewModel = viewModel()
    NavHost(navController = navController, startDestination = "login_screen") {
        composable("login_screen") { FirstScreen(navController, themeViewModel) }
        composable("list_of_fields") { ListOfFieldsScreen(navController) }
    }
}
