package com.mohanravi.composify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohanravi.composify.ui.theme.ComposifyTheme
import com.mohanravi.composifylib.CardWithAnimatedBorder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposifyTheme {
                // A surface container using the 'background' color from the theme
                val colors = listOf(
                        Color(0xFFFF595A),
                        Color(0xFFFFC766),
                        Color(0xFF35A07F),
                        Color(0xFF35A07F),
                        Color(0xFFFFC766),
                        Color(0xFFFF595A)
                    )

                    CardWithAnimatedBorder(
                        modifier = Modifier.padding(16.dp).fillMaxWidth().height(200.dp),
                        borderColors = colors,
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "test", color = Color.Black)
                        }

                    }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposifyTheme {
        Greeting("Android")
    }
}