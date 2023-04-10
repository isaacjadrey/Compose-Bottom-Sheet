package com.cwj.composebottomsheet.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cwj.composebottomsheet.R
import com.cwj.composebottomsheet.presentation.components.BottomSheetContent
import com.cwj.composebottomsheet.presentation.components.TopBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = { BottomSheetContent() },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetPeekHeight = 0.dp,
        sheetElevation = 5.dp,
        sheetBackgroundColor = MaterialTheme.colorScheme.background,
        content = {
            Scaffold(topBar = { TopBar(stringResource(id = R.string.bottom_sheet)) }) { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Content(scope = scope, state = bottomSheetScaffoldState)
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Content(scope: CoroutineScope, state: BottomSheetScaffoldState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                /**
                 * if button is clicked and bottom sheet state is collapsed,
                 * expand the bottom sheet
                 * else keep the bottom sheet collapsed
                 */
                scope.launch {
                    if (state.bottomSheetState.isCollapsed) {
                        state.bottomSheetState.expand()
                    } else state.bottomSheetState.collapse()
                }
            }
        ) {
            /**
             * if the state of the bottomSheet is Collapsed, change the text to open sheet
             * else show close sheet text
             */
            if (state.bottomSheetState.isCollapsed) {
                Text(text = "Open Bottom Sheet")
            } else Text(text = "Close Bottom Sheet")
        }
    }
}