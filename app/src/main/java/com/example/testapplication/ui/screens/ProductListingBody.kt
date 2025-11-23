package com.example.testapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Error
import androidx.compose.material.icons.outlined.Expand
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Scale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.testapplication.R
import com.example.testapplication.data.products.Product
import com.example.testapplication.ui.BottomItem

@Composable
fun ProductListingBody(products: List<Product?>?) {
    val bottomItems = listOf(
        BottomItem.Home,
        BottomItem.List,
        BottomItem.Cart,
        BottomItem.Wishlist,
        BottomItem.Profile
    )

    val navController = rememberNavController()

    val currentDestination =
        navController.currentBackStackEntryAsState().value?.destination




    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Products",
                fontWeight =  FontWeight(900),
                fontSize = 40.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.End,
            ) {
                Icon(
                    Icons.Outlined.Expand,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )

                Icon(
                    Icons.Outlined.FilterAlt,
                    contentDescription = ""
                )
            }
        }

        if (products?.size != null) {

            Text(
                "${products.size} products found",
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp)
            )
        }

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(products?.size ?: 0) { index ->
                val item = products?.get(index)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {


                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.End)
                        )

                        NetworkImageWithGlide(
                            item?.thumbnail.toString(),
                            Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(horizontal = 8.dp)
                        )

                        Text(item?.brand ?: "",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            maxLines = 1,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Text(item?.description ?: "",
                            color = Color.Gray,
                            maxLines = 2,
                            modifier = Modifier.padding(top = 4.dp),
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 16.sp
                            )

                        )
                        Text("$"+item?.price.toString(),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            maxLines = 1,
                            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)

                        )
                    }
                }
            }
        }

    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NetworkImageWithGlide(
    url: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        GlideImage(
            model = url,
            contentDescription = "Logo",
            modifier = modifier
        )
    }
}
