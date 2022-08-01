package com.example.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.ActivityMainBinding
import com.example.myposts.databinding.ApiListItemBinding

class RvAdapterApi(var context: Context, var postsList: List<Post>):
        RecyclerView.Adapter<PostsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        //create a variable holdign the list
        var binding=ApiListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var postsViewHolder=PostsViewHolder(binding)
        return  postsViewHolder
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
    var currentPost=postsList.get(position)
        holder.binding.tvUserId.text= currentPost.userId.toString()
        holder.binding.tvId.text=currentPost.id.toString()
        holder.binding.tvTtitle.text=currentPost.title.toString()
        holder.binding.tvBody.text=currentPost.body
    }

    override fun getItemCount(): Int {
        return postsList.size

    }
}
class PostsViewHolder(var binding:ApiListItemBinding):
    RecyclerView.ViewHolder(binding.root)






