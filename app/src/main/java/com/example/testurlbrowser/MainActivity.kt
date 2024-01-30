package com.example.testurlbrowser

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testurlbrowser.ui.theme.TestURLBrowserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestURLBrowserTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TestURLBrowserTheme()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun TestURLBrowserTheme() {
    //val testURLEdge = "microsoft-edge:https://www.ilfattoquotidiano.it/"
    val testURLEdge = "https://www.ilfattoquotidiano.it/"
    val testURLChrome = "https://www.ilfattoquotidiano.it/"
    val packageNameChrome = "com.android.chrome" // Chrome package name
    val packageNameEdge = "com.microsoft.emmx" // Chrome package name
    //val className = "com.google.android.apps.chrome.Main" // Main activity class name
    //val componentName = ComponentName(packageName, className)
    val context = LocalContext.current
    val valFioriIntentEdge = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse(testURLEdge))
    }
    val valFioriIntentChrome = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse(testURLChrome))
    }
    valFioriIntentChrome.setPackage(packageNameChrome)
    valFioriIntentEdge.setPackage(packageNameEdge)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        Button(onClick = { context.startActivity(valFioriIntentEdge) }) {
            Text(text = "Start Edge Browser")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { context.startActivity(valFioriIntentChrome) }) {
            Text(text = "Start Chrome Browser")
        }
    }
}
