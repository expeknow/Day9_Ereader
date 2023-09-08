package com.example.day9_ereader.ui.windows

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.day9_ereader.R
import com.example.day9_ereader.ui.theme.avenir
import com.example.day9_ereader.ui.theme.backgroundDarkGray
import com.example.day9_ereader.ui.theme.backgroundWhite
import com.example.day9_ereader.ui.theme.gibson
import com.example.day9_ereader.ui.theme.primaryOrange
import com.example.day9_ereader.ui.utils.TopBarRow
import com.example.day9_ereader.ui.utils.countryHistoryList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWindow(navController: NavHostController) {
    Scaffold {
        val modifier = Modifier.padding(horizontal = 20.dp)
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(backgroundWhite)) {

            Column(horizontalAlignment = Alignment.End, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp)) {
                Icon(painter = painterResource(id = R.drawable.orange_circle_right),
                    contentDescription = "", modifier = Modifier.size(440.dp),
                    tint = primaryOrange)
            }

            Column(horizontalAlignment = Alignment.End, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 70.dp, horizontal = 10.dp)) {

                Icon(painter = painterResource(id = R.drawable.white_outline),
                    contentDescription = "", modifier = Modifier.size(100.dp),
                    tint = backgroundWhite)
            }

            Column(horizontalAlignment = Alignment.End, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp)) {
                Icon(painter = painterResource(id = R.drawable.orange_stroke),
                    contentDescription = "", modifier = Modifier.size(250.dp),
                tint = primaryOrange)
            }



            Column(
                Modifier
                    .fillMaxSize()
                    ) {
                TopBarRow(navController, modifier = modifier)
                TextInfoRow(modifier)
                Spacer(modifier = Modifier.height(30.dp))
                Card(shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundDarkGray),
                elevation = CardDefaults.cardElevation(20.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 15.dp)
                   ) {
                    Spacer(modifier = Modifier.height(30.dp))

                    Column(Modifier.verticalScroll(rememberScrollState())) {
                        val countryData = countryHistoryList
                        for(data in countryData) {
                            ArticleRow(
                                place = data.countryName,
                                chapter = data.historySnippet,
                                availableNumbers = data.availableReadables,
                                navController = navController
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(0.dp))
            }
        
        }
    }
}

@Composable
fun ArticleRow(
    place: String,
    chapter: String,
    availableNumbers: Int,
    navController: NavHostController
) {

    Spacer(modifier = Modifier.height(0.dp))
    Column(Modifier.padding(horizontal = 20.dp, vertical = 5.dp)) {
        Text(text = place, fontSize = 34.sp, fontFamily = avenir, fontWeight = FontWeight.Medium,
        color = backgroundWhite)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = chapter, fontSize = 15.sp, color = backgroundWhite,
        fontFamily = avenir, maxLines = 3, fontWeight = FontWeight.Medium)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)) {
            Text(text = "Available read nr: ${availableNumbers}", fontSize = 14.sp, color = backgroundWhite,
                fontFamily = avenir)
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.weight(1f)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .clickable { navController.navigate("article") },
                    tint = primaryOrange)
                Text(text = "Begin Reading", fontSize = 15.sp, color = backgroundWhite,
                    fontFamily = avenir)
            }
        }
        Divider(Modifier.fillMaxWidth(), color = backgroundWhite, thickness = 2.dp)

    }

}


@Composable
fun TextInfoRow(modifier: Modifier) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Select The History", fontSize = 25.sp, fontFamily = gibson, fontWeight = FontWeight.Medium,
    modifier = modifier, color = backgroundDarkGray)
    Text(text = "Of Your Choice", fontSize = 35.sp, fontFamily = gibson, fontWeight = FontWeight.Medium,
        modifier = modifier, color = backgroundDarkGray)

}




@Preview(showBackground = true)
@Composable
fun PreviewSplash() {
    MainWindow(rememberNavController())
}