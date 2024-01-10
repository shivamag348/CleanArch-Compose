package com.example.shivam_agarwal.presentation.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shivam_agarwal.data.remote.model.ArticlesItem

@Composable
fun LazyListing(articles: List<ArticlesItem>) {

    Box(modifier = Modifier.fillMaxSize()){
//        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(5.dp)) {
        LazyColumn(contentPadding = PaddingValues(5.dp)) {
            items(articles.size) { index ->
                NewsItem(
                    article = articles[index],
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(5.dp)
                )
            }
        }
    }

}
@Composable
fun NewsItem(
    article: ArticlesItem,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        AsyncImage(
            model = article.urlToImage,
            contentDescription = "Article Image ${article.title}"
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(text = article.title, style = MaterialTheme.typography.subtitle1)
            Text(text = article.author, style = MaterialTheme.typography.caption)
            Text(text = article.description, style = MaterialTheme.typography.body1)
        }
    }
}