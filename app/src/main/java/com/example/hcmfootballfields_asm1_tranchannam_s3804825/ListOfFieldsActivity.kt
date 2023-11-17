package com.example.hcmfootballfields_asm1_tranchannam_s3804825


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.Field
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.ThemeViewModel
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.ui.theme.components.FieldCard


@Composable
//Define screen and parameters
fun ListOfFieldsScreen(
    fields: List<Field>,
    navController: NavController,
    themeViewModel: ThemeViewModel
) {
    // Observe the theme state
    val isDarkTheme = themeViewModel.isDarkTheme.value
    AppTheme(useDarkTheme = isDarkTheme) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
//         Header Area
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        IconButton(
                            onClick = { navController.navigate("login_screen") },
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                                contentDescription = "Toggle Theme",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Lists of Fields",
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    IconButton(
                        onClick = { themeViewModel.toggleTheme() },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            imageVector = if (isDarkTheme) ImageVector.vectorResource(id = R.drawable.light_mode) else ImageVector.vectorResource(
                                id = R.drawable.dark_mode
                            ),
                            contentDescription = "Toggle Theme",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
//               Loop through the list of fields and render all fields as a list
                LazyColumn {
                    items(fields) { field ->
                        FieldCard(
                            field = field,
                            navController = navController,
                            themeViewModel = themeViewModel
                        )
                    }
                }
            }

        }
    }

}




