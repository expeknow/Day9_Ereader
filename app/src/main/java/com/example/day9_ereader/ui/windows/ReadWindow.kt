package com.example.day9_ereader.ui.windows

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
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
import com.example.day9_ereader.ui.theme.primaryOrangeTranslucent
import com.example.day9_ereader.ui.utils.TopBarRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadWindow(navController: NavHostController) {
    val modifier = Modifier.padding(horizontal = 20.dp)

    Scaffold(containerColor = backgroundWhite,
    modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(backgroundWhite)) {

            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 70.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.orange_circle_right),
                    contentDescription = "", modifier = Modifier
                        .size(320.dp)
                        .scale(-1f, 1f),
                    tint = primaryOrange
                )
            }

            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 15.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.orange_stroke_full),
                    contentDescription = "", modifier = Modifier.size(220.dp),
                    tint = primaryOrange
                )
            }

            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 280.dp, horizontal = 40.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.white_outline),
                    contentDescription = "", modifier = Modifier.size(160.dp),
                    tint = backgroundWhite
                )
            }
            Column(
                modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                TopBarRow(navController = navController)
                SearchBarRow(modifier)
                ArticleNameAndNumber("", 24, modifier)
                Spacer(modifier = Modifier.height(30.dp))
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(
                        containerColor = backgroundDarkGray
                    ), elevation = CardDefaults.cardElevation(20.dp),
                    shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)
                ) {
                    ArticalDescriptionCard(smallTitle = "", largeTitle = "", description = "")
                }
            }

        }
    }
}

@Composable
fun ArticalDescriptionCard(smallTitle: String, largeTitle: String, description: String) {
    val sampleArticleDetail = "During the Neolithic era (starting at 7000 BC) and the time of the Indo-European migrations (starting at c. 4000 BC.) Europe saw massive migrations from the east and southeast which also brought agriculture, new technologies, and the Indo-European languages, primarily through the areas of the Balkan peninsula and the Black sea region. "
    Spacer(modifier = Modifier.height(20.dp))
    Column(
        Modifier
            .padding(horizontal = 20.dp, vertical = 15.dp)
            .verticalScroll(rememberScrollState())) {
        Text(text = "The End Of", fontSize = 24.sp, fontFamily = gibson, fontWeight = FontWeight.Medium,
             color = backgroundWhite)
        Text(text = "The Roman Empire", fontSize = 35.sp, fontFamily = gibson, fontWeight = FontWeight.Medium,
             color = backgroundWhite)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = sampleArticleDetail, fontSize = 15.sp, color = backgroundWhite,
            fontFamily = avenir, fontWeight = FontWeight.Medium)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)) {
            Text(text = "Available read nr: 37", fontSize = 14.sp, color = backgroundWhite,
                fontFamily = avenir)
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.weight(1f)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "",
                    modifier = Modifier.size(60.dp), tint = primaryOrange)
                Text(text = "Begin Reading", fontSize = 15.sp, color = backgroundWhite,
                    fontFamily = avenir)
            }
        }
    }
}

@Composable
fun ArticleNameAndNumber(name: String, articleNumber: Int, modifier: Modifier) {

    var readNr by remember {
        mutableStateOf(23)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(text = "Italy", fontSize = 40.sp, fontFamily = gibson, fontWeight = FontWeight.Medium,
                modifier = Modifier, color = backgroundDarkGray)
        }
        Row(
            Modifier
                .height(200.dp)
                .fillMaxWidth()) {
            ReadNumberWidget(readNumber = readNr, readnrColor = backgroundWhite,
                countColor = backgroundDarkGray, size = 16)
            Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)) {
                Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End,
                    modifier = Modifier.weight(1f)
                    ) {
                    ReadNumberWidget(readNumber = readNr-1, readnrColor = primaryOrangeTranslucent,
                        countColor = primaryOrangeTranslucent, size = 8)
                    Spacer(modifier = Modifier.width(20.dp))
                    ReadNumberWidget(readNumber = readNr+1, readnrColor = primaryOrangeTranslucent,
                        countColor = primaryOrangeTranslucent, size = 8)
                }
                Row() {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "",
                        Modifier
                            .size(30.dp)
                            .clickable { readNr -= 1 },
                             tint = backgroundDarkGray)
                    Spacer(modifier = Modifier.width(70.dp))
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "",
                        Modifier.size(30.dp).clickable { readNr+=1 }, tint = backgroundDarkGray)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Divider(thickness = 2.dp, color = backgroundDarkGray, modifier = Modifier.width(120.dp))

            }
        }
    }
}

@Composable
fun ReadNumberWidget(readNumber: Int, readnrColor: Color , countColor: Color, size: Int) {
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
        Text(text = "Read nr.", fontSize = size.sp, fontFamily = avenir,
            color = readnrColor, fontWeight = FontWeight.Medium)
        val chapterNumberFontSize = size*6
        Text(text = readNumber.toString(), fontSize = chapterNumberFontSize.sp, fontFamily = avenir,
            color = countColor,)
    }
}

@Composable
fun SearchBarRow(modifier: Modifier) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp), horizontalAlignment = Alignment.End,
    verticalArrangement = Arrangement.Center) {

        Column(Modifier.fillMaxWidth(0.4f)) {
            Row() {
                Text(text = "Search title", fontSize = 14.sp, fontFamily = avenir,
                    color = backgroundDarkGray, modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Default.Search, contentDescription = "search",
                    Modifier.size(18.dp), tint = backgroundDarkGray)
            }
            Divider(thickness = 2.dp, color = backgroundDarkGray, modifier = Modifier.fillMaxWidth())
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ReadPreview() {
    ReadWindow(navController = rememberNavController())
}