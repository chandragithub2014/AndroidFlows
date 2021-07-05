package com.devtides.androidcoroutinesflow.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.androidcoroutinesflow.R
import com.devtides.androidcoroutinesflow.model.PostsModel
import kotlinx.android.synthetic.main.item_news_article.view.*

class PostsListAdapter: RecyclerView.Adapter<PostsListAdapter.NewsItemViewHolder>() {

    private val newsItems = arrayListOf<PostsModel.PostsModelItem>()

    fun onAddPostsItem(item: PostsModel.PostsModelItem) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = NewsItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_news_article, parent, false)
    )

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    class NewsItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.newsImage
        private val author = view.newsAuthor
        private val title = view.newsTitle
        private val publishedAt = view.newsPublishedAt

        fun bind(newsItem: PostsModel.PostsModelItem) {
           // imageView.loadImage(newsItem.urlToImage)
            author.text = newsItem.id.toString()
            title.text = newsItem.title
            publishedAt.text = newsItem.body
        }
    }
}