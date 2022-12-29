package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreeting(message = "Happy Birthday Jonathan!", from = "-from Jane")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreeting(message: String, from: String) {
    Box {
        val background = painterResource(id = R.drawable.birthdaybackground)
        Image(
            painter =  background,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column() {
            GreetingText(message = message, from = from)
            ThanksButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingPreview() {
    HappyBirthdayTheme {
        BirthdayGreeting(message = "Happy Birthday Jonathan!", from = "-from Jane")
    }
}

@Composable
fun GreetingText(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 28.sp,
            fontWeight = Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 100.dp)
        )
        Text(
            text = from,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ThanksButton() {
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.CenterHorizontally)
        .padding(top = 16.dp)
    ) {
        Button(onClick = {})
        { Text(text = "Say Thanks!") }
    }
}