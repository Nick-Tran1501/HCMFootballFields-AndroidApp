package com.example.hcmfootballfields_asm1_tranchannam_s3804825.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.R
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.Field
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.FieldType
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.ThemeViewModel
import com.google.gson.Gson

//Field card component defined
@Composable
fun FieldCard(field: Field, navController: NavController, themeViewModel: ThemeViewModel) {
    val isDarkTheme = themeViewModel.isDarkTheme.value
    AppTheme(useDarkTheme = isDarkTheme) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp)
                .clickable {
                    val fieldJson = Gson().toJson(field) // Convert the field object to JSON string
                    navController.navigate("field_detail/$fieldJson") // Navigate with the field data
                },
        ) {
//            Header Area
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                Image(
//                   painter = painterResource(id = getImageResource(field.image)),
                    ImageBitmap.imageResource(getImageResource(field.image)),
                    contentDescription = field.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .padding(4.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
                )
                Column(
                    modifier = Modifier.padding(4.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = field.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "Rating: ${field.rate}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = field.shortDescription,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                }
            }

        }

    }
}

// Image name condition to return drawable result fỏ image resource
fun getImageResource(imageName: String): Int {
    return when (imageName) {
        "athletic_bilbao" -> R.drawable.athletic_bilbao
        "atletico_madrid" -> R.drawable.atletico_madrid
        "almeria" -> R.drawable.almeria
        "barca" -> R.drawable.barca
        "betis" -> R.drawable.betis
        "cadiz" -> R.drawable.cadiz
        "celta" -> R.drawable.celta
        "deportivo" -> R.drawable.deportivo
        "getafe" -> R.drawable.getafe
        "girona" -> R.drawable.girona
        "granada" -> R.drawable.granada
        "mallorca" -> R.drawable.mallorca
        "rayo" -> R.drawable.rayo
        "osasuna" -> R.drawable.osasuna
        "palmas" -> R.drawable.palmas
        "real" -> R.drawable.real
        "sevilla" -> R.drawable.sevilla
        "sociedad" -> R.drawable.sociedad
        "valencia" -> R.drawable.valencia
        "villareal" -> R.drawable.villareal
        // Add other mappings here
        else -> R.drawable.ballonly // Fallback drawable
    }
}

// Preview Example
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FieldCardPreview() {
    val navController = rememberNavController()
    val themeViewModel: ThemeViewModel = viewModel()
    FieldCard(
        Field(
            image = "barca",
            name = "Barca",
            phone = "01234124884",
            address = "lyweb",
            rate = 5.5,
            shortDescription = "ádfasd",
            fullDescription = "12341234wqjfbnkbaskjbwqr",
            type = FieldType.FUTSAL
        ),
        navController = navController,
        themeViewModel = themeViewModel
    )
}