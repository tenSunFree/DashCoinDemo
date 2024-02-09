package com.example.feat_photo

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feat_photo.components.CoinsItem

@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun PhotoScreen(
    viewModel: PhotoViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val scaffoldState = rememberScaffoldState()
    val lazyListState = rememberLazyListState()
    Scaffold(
        scaffoldState = scaffoldState,
    ) { paddingValues ->
        Log.d("more", "MainScreen, paddingValues: $paddingValues")
        Box(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxSize()
                .clipToBounds()
        ) {
            Column(
                modifier = Modifier
                    .background(Color(0xFF101010))
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = com.example.feat_common.R.drawable.icon_top_bar), // 替換為頭部圖片資源
                    contentDescription = "icon_top_bar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .aspectRatio(858F / 138F)
                )
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    state = lazyListState
                ) {
                    items(items = state.value.coins, key = { it.id.toString() }) { coins ->
                        CoinsItem(
                            coins = coins,
                            onItemClick = {}
                        )
                    }
                }
                Image(
                    painter = painterResource(id = com.example.feat_common.R.drawable.icon_bottom_bar), // 替換為頭部圖片資源
                    contentDescription = "icon_bottom_bar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF101010))
                        .aspectRatio(856F / 117F)
                )
            }
            if (state.value.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}