package com.example.hafta6bpjp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.hafta6bpjp.ui.theme.Hafta6BPJPTheme
import com.example.hafta6bpjp.ui.theme.benim_fontum

// resource
// start - leading - left - sol
// end - trailing - right - sağ
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hafta6BPJPTheme {
                Row (
                    modifier = Modifier.fillMaxSize(),
                    // contentAlignment = Alignment.Center
                    // verticalArrangement = Arrangement.Center,
                    // horizontalAlignment = Alignment.CenterHorizontally
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom
                    ) {
                    Text(
                        text = "Merhaba, Jetpack!",
                        style = TextStyle(
                            fontSize = 36.sp,
                            // color = Color.Red
                            color = Color(0xFF54D335),
                            background = Color.White,
                            // fontWeight = FontWeight.ExtraBold
                            fontWeight = FontWeight(weight = 750),
                            shadow = Shadow(
                                color = Color.Gray,
                                offset = Offset(2.5f, 2.5f)
                            ),
                            fontFamily = benim_fontum,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = "İkinci satir!"
                    )

                }
            }
        }
    }
}