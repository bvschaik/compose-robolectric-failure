package com.github.bvschaik.composerobolectric

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import com.github.bvschaik.composerobolectric.ui.theme.CloseIcon
import com.github.bvschaik.composerobolectric.ui.theme.ComposeRobolectricTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeRobolectricTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    println("Running on API: ${Build.VERSION.SDK_INT}")
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.systemBarsPadding()) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding))
            ) {
                Button(
                    onClick = { showBottomSheet = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Hit me")
                }

                if (showBottomSheet) {
                    MyBottomSheet { showBottomSheet = false }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomSheet(onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        Image(
            imageVector = LocalContext.current.CloseIcon,
            contentDescription = "Close this",
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding))
                .clickable {
                    println("Click was called")
                    scope
                        .launch { sheetState.hide() }
                        .invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                onDismiss()
                            }
                        }
                }
        )
    }
}
