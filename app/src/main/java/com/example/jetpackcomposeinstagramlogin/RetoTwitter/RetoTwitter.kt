package com.example.jetpackcomposeinstagramlogin.RetoTwitter

import android.os.Build
import androidx.annotation.RequiresApi

import androidx.compose.foundation.*

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.jetpackcomposeinstagramlogin.R
import java.time.Duration
import java.time.LocalDateTime
import kotlin.math.round


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RetoTwitter() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Twit(
            DataTwit("Aris",
                "@AristiDevs",
                "2022-02-13T18:04:00",
                "Descripcion id w arga sobre dwd texto descripcion larga sobre texto description larga sobre texto description larga sobre texto description larga sobre texto description",
                R.drawable.profile
            )
            )
        DividerPrincipal()
    }
}

@Composable
fun DividerPrincipal() {
    Divider(
        Modifier
            .fillMaxWidth()
            .height(1.dp),
        color = Color.LightGray
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun  Twit(dataTwit: DataTwit){
    val imagen = dataTwit.imagen
    Row(
        Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        IconoProfile(Modifier
            .clip(shape = CircleShape)
            .weight(1f), imagen)
        CuerpoTwit(Modifier
            .weight(5f)
            .padding(start = 10.dp), dataTwit)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CuerpoTwit(modifier: Modifier, dataTwit: DataTwit) {
    val usuario = dataTwit.usuario
    val alias = dataTwit.alias
    val horaTwit = dataTwit.horaTwit
    val twit = dataTwit.twit
    val imagen = dataTwit.imagen
    Column(modifier = modifier) {
        ParteSuperior(modifier = Modifier.fillMaxWidth(), usuario, alias, horaTwit)
        Spacer(modifier = Modifier.size(5.dp))
        TwitAndImage(twit, imagen)
        Spacer(modifier = Modifier.size(20.dp))
        Iconos(Modifier.fillMaxWidth(), Arrangement.Start)
        Spacer(modifier = Modifier.size(5.dp))
    }
}

@Composable
fun Iconos(modifier: Modifier, arrangement: Arrangement.Horizontal) {
    Row() {
        Comentarios(horizontalArrangement = Arrangement.Start, modifier = Modifier.weight(1f))
        Compartido(horizontalArrangement = Arrangement.Start, modifier = Modifier.weight(1f))
        Like(horizontalArrangement = Arrangement.Start, modifier = Modifier.weight(1f))
    }

}

@Composable
fun Like(horizontalArrangement: Arrangement.Horizontal, modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = horizontalArrangement) {
        var likeMarcado by rememberSaveable { mutableStateOf(false) }
        Icon(
            painter = painterResource(id = if (likeMarcado) R.drawable.ic_like_filled else R.drawable.ic_like),
            contentDescription = "icono like",
            tint = if (likeMarcado) Color.Red else Color.LightGray,
            modifier = Modifier.clickable { likeMarcado = !likeMarcado }
        )
        Text(if (likeMarcado) "2" else "1", color = Color.LightGray)
    }
}

@Composable
fun Compartido(horizontalArrangement: Arrangement.Horizontal, modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = horizontalArrangement) {
        var retweeMarcado by rememberSaveable { mutableStateOf(false) }
        Icon(
            painter = painterResource(id = R.drawable.ic_rt),
            contentDescription = "icono rt",
            tint = if (retweeMarcado) Color.Green else Color.LightGray,
            modifier = Modifier.clickable { retweeMarcado = !retweeMarcado }
        )
        Text(if (retweeMarcado) "2" else "1", color = Color.LightGray)
    }
}

@Composable
fun Comentarios(horizontalArrangement: Arrangement.Horizontal, modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = horizontalArrangement) {
        var comentariosMarcado by rememberSaveable { mutableStateOf(false) }
        Icon(
            painter = painterResource(id = if (comentariosMarcado) R.drawable.ic_chat_filled else R.drawable.ic_chat),
            contentDescription = "icono comentarios",
            tint = Color.LightGray,
            modifier = Modifier.clickable {
                comentariosMarcado = !comentariosMarcado
            }
        )
        Text(if (comentariosMarcado) "2" else "1", color = Color.LightGray)
    }
}

@Composable
fun TwitAndImage(twit: String, imagen: Int) {
    Text(
        twit,
        color = Color.White
    )
    Spacer(modifier = Modifier.size(15.dp))
    Image(
        painter = painterResource(id = imagen),
        contentDescription = "Imagen twit",
        Modifier
            .clip(shape = RoundedCornerShape(25.dp))
            .height(230.dp),
        contentScale = ContentScale.Crop
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ParteSuperior(modifier: Modifier, usuario: String, alias: String, horaTwit: String) {
    Row(modifier = modifier) {
        Text(usuario, fontWeight = FontWeight.Bold, color = Color.White)
        Text(
            alias,
            Modifier.padding(horizontal = 5.dp),
            color = Color.LightGray
        )
        val fechaActual = LocalDateTime.now()
        val fechaTwit = LocalDateTime.parse(horaTwit)
        val diferencia = Duration.between(fechaTwit, fechaActual).toHours()
        var texto = ""
        if (diferencia <= 23) texto = "${diferencia}h" else texto = "${round((diferencia/24).toDouble()).toInt()}d"
        Text(texto, color = Color.LightGray)
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) {
            Icon(
                painter = painterResource(R.drawable.ic_dots),
                contentDescription = "Icono de puntos",
                //modifier = Modifier.weight(1f),
                tint = Color.LightGray
            )
        }
    }
}

@Composable
fun IconoProfile(modifier: Modifier, imagen: Int) {
    Image(
        painter = painterResource(id = imagen),
        contentDescription = "icono profile",
        modifier = modifier
    )
}
