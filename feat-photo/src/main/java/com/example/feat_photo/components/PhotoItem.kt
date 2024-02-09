package com.example.feat_photo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.core_domain.model.PhotoModel
import com.example.feat_common.theme.LightGray
import com.example.feat_common.theme.LighterGray
import com.example.feat_common.theme.TextWhite
import kotlin.random.Random

@Composable
fun CoinsItem(
    coins: PhotoModel,
    onItemClick: (PhotoModel) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onItemClick(coins) }
    ) {
        val (urlImage, titleText, fansText, priceText, percentageText, followButton, divider) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(urlImage) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .clip(CircleShape)
                .background(LighterGray)
                .size(40.dp)
        ) {
            AsyncImage(
                model = coins.url,
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = coins.title.toString(),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            color = TextWhite,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(urlImage.end, margin = 16.dp)
                    end.linkTo(followButton.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                },
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${generateFansNumber()} 位粉絲",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            color = TextWhite,
            modifier = Modifier.constrainAs(fansText) {
                top.linkTo(titleText.bottom, margin = 8.dp)
                start.linkTo(titleText.start, margin = 0.dp)
            }
        )
        Box(
            modifier = Modifier
                .constrainAs(followButton) {
                    top.linkTo(parent.top, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color(0x40FFFFFF),
                    shape = RoundedCornerShape(10.dp)
                )
                .background(Color.Black)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "Follow",
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
        }
        Divider(
            color = LightGray,
            thickness = 1.dp,
            modifier = Modifier.constrainAs(divider) {
                bottom.linkTo(parent.bottom, margin = 0.dp)
                start.linkTo(titleText.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })
    }
}

fun generateFansNumber(): String {
    return Random.nextInt(1, 9999 + 1).toString()
}
