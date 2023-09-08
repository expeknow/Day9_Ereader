package com.example.day9_ereader.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.day9_ereader.R
import com.example.day9_ereader.ui.theme.backgroundDarkGray
import com.example.day9_ereader.ui.theme.gibson

@Composable
fun TopBarRow(navController: NavController, modifier: Modifier = Modifier) {
//    Spacer(modifier = Modifier.height(5.dp))
//    Divider(thickness = 3.dp, color = backgroundDarkGray, modifier = modifier.fillMaxWidth())
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(vertical = 6.dp)) {
        Text(text = "E.reader", fontSize = 16.sp, color = backgroundDarkGray, fontFamily = gibson,
            modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
        Icon(painter = painterResource(id = R.drawable.menu), contentDescription = "menu",
            Modifier.size(22.dp), tint = backgroundDarkGray)
    }
    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back",
        modifier
            .size(24.dp)
            .padding(0.dp)
            .clickable { navController.popBackStack() } , tint = backgroundDarkGray)

    Spacer(modifier = Modifier.height(5.dp))
    Divider(thickness = 2.dp, color = backgroundDarkGray, modifier = modifier.fillMaxWidth())
}