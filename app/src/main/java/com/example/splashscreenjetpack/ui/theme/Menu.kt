package com.example.splashscreenjetpack.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.splashscreenjetpack.R
import java.util.Locale

@Composable
fun Menu () {
     previewDefault()
}

private val SugerenciaBodyData = listOf(
    R.drawable.batman to R.string.batman,
    R.drawable.batman to R.string.batman,
    R.drawable.batman to R.string.batman,
    R.drawable.batman to R.string.batman,
    R.drawable.batman to R.string.batman,
    R.drawable.batman to R.string.batman,
    R.drawable.batman to R.string.batman
).map { DrawableStringPair(it.first, it.second) }

private val FavoritosBodyData = listOf(
    R.drawable.lucy to R.string.lucy,
    R.drawable.lucy to R.string.lucy,
    R.drawable.lucy to R.string.lucy,
    R.drawable.lucy to R.string.lucy,
    R.drawable.lucy to R.string.lucy,
    R.drawable.lucy to R.string.lucy,
    R.drawable.lucy to R.string.lucy
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
            Text(text = "")
        },
        navigationIcon = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Acción al hacer clic en el ícono del menú hamburguesa */ }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menú")
                }
                Spacer(modifier = Modifier.width(8.dp))

            }
        },
        actions = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Acción al hacer clic en el ícono de usuario */ }) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Usuario")
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBar(padding: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Buscar")
        },
        modifier = Modifier
            .width(250.dp)
            .height(10.dp)
            .background(Color.White) // Establece el color de fondo como transparente
    )
}

@Composable
fun Sugerencias(

    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(88.dp)

        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 12.dp
            )
        )
    }
}


@Composable
fun Favoritos(

    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(88.dp)

        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 12.dp
            )
        )
    }
}


@Composable
fun FavoritosRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(15.dp)
    ) {
        items(FavoritosBodyData) { item ->
            Favoritos(item.drawable, item.text)
        }
    }
}


@Composable
fun SugerenciasRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(15.dp)
    ) {
        items(SugerenciaBodyData) { item ->
            Sugerencias(item.drawable, item.text)
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit

) {
    Column(modifier) {
        Text(
            stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }


}

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        IconButton(onClick = { /* Acción al hacer clic en el ícono del primer elemento */ }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }
        IconButton(onClick = { /* Acción al hacer clic en el ícono del segundo elemento */ }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun previewDefault() {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        AppTopBar()
        HomeSection(R.string.favoritos) { FavoritosRow() }
        HomeSection(R.string.sugerencias) { SugerenciasRow() }
        HomeSection(R.string.favoritos) { FavoritosRow() }
        HomeSection(R.string.sugerencias) { SugerenciasRow() }
        HomeSection(R.string.favoritos) { FavoritosRow() }
        HomeSection(R.string.sugerencias) { SugerenciasRow() }
        SootheBottomNavigation()
    }
}