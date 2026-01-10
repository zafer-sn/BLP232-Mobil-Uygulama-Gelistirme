package com.example.appfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.appfrontend.ui.theme.AppFrontEndTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data class Oyun(
    val id: Int,
    val ad: String,
    val tur: String,
    val resimDosya: String?
)

var client = HttpClient(CIO)
{
    install(ContentNegotiation) {
        json()
    }
}

const val BASE_URL = "http://10.0.2.2:8080"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFrontEndTheme {
                Uygulama()
            }
        }
    }
}

@Composable
fun Uygulama()
{
    var nav_controller = rememberNavController()
    NavHost(navController = nav_controller, startDestination = "anamenu")
    {
        composable("anamenu")
        {
            AnaMenu(
                onListele = {nav_controller.navigate("listele")},
                onEkle = {nav_controller.navigate("ekle")}
            )
        }
        composable("listele")
        {
            Listele(
                onGeri = {nav_controller.popBackStack()}
            )
        }
        composable("ekle")
        {
            Ekle(
                onGeri = {nav_controller.popBackStack()}
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaMenu(onListele : () -> Unit, onEkle : () -> Unit)
{
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {Text(text = "AnaMenu")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }

    )
    { ic_bosluk ->
        Column(
            modifier = Modifier.fillMaxSize().padding(ic_bosluk),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(R.drawable.steam),
                contentDescription = "",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(200.dp))
            Text(text = "Ana Menu", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onListele
            ) {
                Text(text = "Listele", style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onEkle
            ) {
                Text(text = "Ekle", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
@Composable
fun Listele(onGeri : () -> Unit)
{
    var oyunListesi by remember { mutableStateOf(listOf<Oyun>()) }

    LaunchedEffect(Unit) {
        try {
            oyunListesi = client.get("${BASE_URL}/oyunGetir").body()
        } catch (e : Exception)
        {
            println("Hata: ${e.message}")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Button(
                onClick = onGeri
            ) {
                Text(text = "<-")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Text(text = "Listele", style = MaterialTheme.typography.titleLarge)
        }
        LazyColumn {
            items(oyunListesi)
            {
                OyunSatiri(it)
            }
        }
    }
}
@Composable
fun goster(e: Exception)
{
    Text(text = "Hata: ${e.message}")
}

@Composable
fun OyunSatiri(oyun : Oyun)
{
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    )
    {
        Row(
            modifier = Modifier.padding(12.dp)
        )
        {
            if(oyun.resimDosya != null)
            {
                AsyncImage(
                    model = "${BASE_URL}/resimler/${oyun.resimDosya}",
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Column()
                {
                    Text(text = oyun.ad, style = MaterialTheme.typography.titleMedium)
                    Text(text = "Tur: ${oyun.tur}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun Ekle(onGeri : () -> Unit)
{
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Button(
                onClick = onGeri
            ) {
                Text(text = "<-")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Text(text = "Ekle", style = MaterialTheme.typography.titleLarge)
        }
    }
}
