package com.cwj.composebottomsheet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cwj.composebottomsheet.presentation.screens.BottomSheet
import com.cwj.composebottomsheet.presentation.screens.ModalBottomSheet
import com.cwj.composebottomsheet.ui.theme.ComposeBottomSheetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomSheetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    BottomSheet()
                    ModalBottomSheet()
                }
            }
        }
    }
}