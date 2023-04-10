package com.cwj.composebottomsheet.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Bottom Sheet Item that shows each item on the bottom sheet
 * @param icon shows an imageVector / image for the bottom sheet item
 * @param title displays tne text for bottom sheet item
 * @param onItemClick performs click actions on te bottom sheet item
 */
@Composable
fun BottomSheetItem(
    icon: ImageVector, title: String, onItemClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(title) }
            .height(55.dp)
            .padding(start = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = "")
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, fontSize = 18.sp)
    }
}

@Preview
@Composable
fun SheetPreview() {
    BottomSheetItem(icon = Icons.Filled.Share, title = "Share", onItemClick = {})
}