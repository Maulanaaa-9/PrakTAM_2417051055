package com.example.praktam_2417051055

import com.example.praktam_2417051055.model.Anime
import com.example.praktam_2417051055.model.AnimeSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praktam_2417051055.ui.theme.PrakTAM_2417051055Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2417051055Theme {
                DaftarAnimeScreen()
            }
        }
    }
}

@Composable
fun DaftarAnimeScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            AnimeSource.dummyAnime.forEach { anime ->
                DetailScreen(anime = anime)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun DetailScreen(anime: Anime) {

    var isFavorite by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {

        Box {
            Image(
                painter = painterResource(id = anime.imageRes),
                contentDescription = anime.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )


            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isFavorite) "Hapus dari favorit" else "Tambah ke favorit",
                    tint = if (isFavorite) Color.Red else Color.White
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = anime.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Season: ${anime.season} ${anime.year}",
            style = MaterialTheme.typography.bodyLarge
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Rating: ${anime.rating} | Episodes: ${anime.episodes}",
            style = MaterialTheme.typography.bodyLarge
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Tambahkan ke Watchlist")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarAnimePreview() {
    PrakTAM_2417051055Theme {
        DaftarAnimeScreen()
    }
}
