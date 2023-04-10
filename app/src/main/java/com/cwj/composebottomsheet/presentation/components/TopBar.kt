package com.cwj.composebottomsheet.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.cwj.composebottomsheet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = { Text(text = title, fontSize = 18.sp)},
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
    ) 
}