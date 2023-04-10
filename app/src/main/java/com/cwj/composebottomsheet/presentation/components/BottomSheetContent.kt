package com.cwj.composebottomsheet.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cwj.composebottomsheet.util.makeToast

@Preview
@Composable
fun BottomSheetContent() {
    val context = LocalContext.current

    Column {
        BottomSheetItem(
            icon = Icons.Filled.Share,
            title = "Share",
            onItemClick = { title -> makeToast(context, title) })
        BottomSheetItem(
            icon = Icons.Filled.Link,
            title = "Get Link",
            onItemClick = { title -> makeToast(context, title) })
        BottomSheetItem(
            icon = Icons.Filled.Edit,
            title = "Make Edit",
            onItemClick = { title -> makeToast(context, title) })
        BottomSheetItem(
            icon = Icons.Filled.Delete,
            title = "Delete Item",
            onItemClick = { title -> makeToast(context, title) })
    }
}