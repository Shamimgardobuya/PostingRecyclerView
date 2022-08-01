package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
//        displayP.ost()
    }
       fun fetchPosts(){
          var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
          var request=apiClient.getPosts()
          request.enqueue(object : Callback<List<Post>> {
              override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                  if(response.isSuccessful){
                   var posts=response.body()

                      Toast.makeText(baseContext,"fetched ${posts!!.size}posts",Toast.LENGTH_LONG).show()
                      var adapter=RvAdapterApi(baseContext,posts)
                      Log.d("Tag",posts.toString())
                      binding.rvApi.adapter=adapter
                      binding.rvApi.layoutManager=LinearLayoutManager(baseContext)
                  }
              }

              override fun onFailure(call: Call<List<Post>>, t: Throwable) {  //tellling our api object in main page

              }

          })
       }
//    fun displayPost(){
//        var post1=Post(23,34,"William Earnest","I am my own captain.")
//        var post2=Post(4,23,"Pinero","Anyone can progress one foot at a time.")
//        var post3=Post(23,12,"Mine game","Mine game is like sudoku.")
//        var post4=Post(12,56,"Originals","Always and forever.")
//        var post5=Post(111,89,"Will Smith","Don't let fear stop you from your dreams.")
//        var post6=Post(11,78,"Viola","I am the author of my own story.")
//        var post7=Post(0,8,"Kotlin","Kotlin is a fun language.")
//        var post8=Post(7,87,"Kirigo","I like baking pies and cake.")
//        var post9=Post(77,55,"Naima","I like strawberry yorghurt.")
//
//        var postings= listOf(post1,post2,post3,post4,post5,post6,post7,post8,post9)
//        var postingAdapter=RvAdapterApi(postings)//create variable and link your adapter class with the list
//     binding.rvApi.layoutManager= LinearLayoutManager(this)  //declare a linera manager for recyclerview
//     binding.rvApi.adapter=postingAdapter     //
//    }
}