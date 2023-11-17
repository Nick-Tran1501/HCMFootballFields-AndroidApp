package com.example.hcmfootballfields_asm1_tranchannam_s3804825

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.Field
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.ThemeViewModel
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.ui.theme.components.getImageResource


@Composable
fun FieldDetail(field: Field, navController: NavController, themeViewModel: ThemeViewModel) {
    val isDarkTheme = themeViewModel.isDarkTheme.value
//    Defined state for scrolling
    val scrollState = rememberScrollState()
    AppTheme(useDarkTheme = isDarkTheme) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
//                        modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    IconButton(
                        onClick = { navController.navigate("list_of_fields") },
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Toggle Theme",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = "Field Information",
                        fontSize = 16.sp,
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
            Text(
                text = field.name,
                fontSize = 24.sp,
                fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                bitmap = ImageBitmap.imageResource(getImageResource(field.image)),
                contentDescription = field.name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Phone: ${field.phone}",
                fontSize = 18.sp
            )
            Text(
                text = "Address: ${field.address}",
                fontSize = 18.sp
            )
            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                FieldRatingStar(rate = field.rate)
            }
            Text(
                text = "Type: ${field.type.name}",
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Short Description: ${field.shortDescription}",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Full Description: ${field.fullDescription}",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

//Convert double values to start icon symbols
@Composable
fun FieldRatingStar(rate: Double) {
    val fullStars = kotlin.math.floor(rate).toInt()
    val halfStar = rate % 1 != 0.0
    val totalStars = 5

    for (i in 1..totalStars) {
        when {
            i <= fullStars -> Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.full_star),
                contentDescription = "Full Star",
                tint = MaterialTheme.colorScheme.secondary
            )

            halfStar && i == fullStars + 1 -> Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.half_full_star),
                contentDescription = "Half Star",
                tint = MaterialTheme.colorScheme.secondary
            )

            else -> Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.outlined_star),
                contentDescription = "Outlined Star",
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}