package com.example.day9_ereader.ui.windows

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Playground() {
//    CircleInBox()
}
//
//
//@Composable
//fun CircleInBox() {
//    Box(modifier = Modifier.fillMaxSize()) {
//        Box(
//            modifier = Modifier
//                .size(200.dp)
//                .background(Color.LightGray)
//        )
//
//        Canvas(modifier = Modifier.size(150.dp)) {
//            clipToBounds {
//                drawCircle(
//                    color = Color.Blue,
//                    radius = size.minDimension / 2,
//                    center = Offset(size.width / 2, size.height / 2)
//                )
//            }
//        }
//
//        Box(
//            modifier = Modifier
//                .size(150.dp)
//                .background(Color.White)
//        )
//    }
//}
