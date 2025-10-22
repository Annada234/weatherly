package com.example.weatherly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherly.ui.theme.WeatherlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherlyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF87CEFA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Weatherly",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))


        Image(
            painter = painterResource(id = R.drawable.sunny),
            contentDescription = "Weather Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Bhubaneswar, India",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = "32°C",
            fontSize = 60.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Sunny",
            fontSize = 24.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(40.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ForecastCard("Mon", R.drawable.cloudy, "30°C")
            ForecastCard("Tue", R.drawable.rainy, "27°C")
            ForecastCard("Wed", R.drawable.storm, "25°C")
        }
    }
}

@Composable
fun ForecastCard(day: String, icon: Int, temp: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.3f)),
        modifier = Modifier
            .width(100.dp)
            .height(140.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = day, color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = temp, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherPreview() {
    WeatherlyTheme {
        WeatherScreen()
    }
}
