package com.cwj.composebottomsheet.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
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
fun ModalBottomSheet() {
    /**
     * modalBottomSheetState saves the state of the modal bottom sheet
     * we use the coroutine scope to expand and collapse the bottom sheet
     */
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(sheetContent = { BottomSheetContent() },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = MaterialTheme.colorScheme.background,
        content = {
            Scaffold(topBar = { TopBar(stringResource(id = R.string.modal_bottom_sheet)) }) { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    ModalContent(scope = scope, state = modalBottomSheetState)
                }
            }
        })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalContent(scope: CoroutineScope, state: ModalBottomSheetState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            scope.launch {
                state.show()
            }
        }) {
            Text(text = "Open Modal Bottom Sheet")
        }
    }
}