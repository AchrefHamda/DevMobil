package com.example.achref_p

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.achref_p.ui.theme.AchrefPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AchrefPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageSwitcher(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ImageSwitcher(modifier: Modifier = Modifier) {
    var imageRes by remember { mutableStateOf(R.drawable.image) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Displayed image",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            imageRes = if (imageRes == R.drawable.image) R.drawable.image2 else R.drawable.image
        }) {
            Text(text = "Changer l'image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageSwitcherPreview() {
    AchrefPTheme {
        ImageSwitcher()
    }
}
