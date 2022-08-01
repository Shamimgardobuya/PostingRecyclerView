package com.example.myposts

import android.icu.text.CaseMap
import android.provider.ContactsContract
import java.sql.RowId

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)
data class Comment(
    var postId:Int,
    var  id:Int,
    var name:String,
    var email: String,
    var body:String
)
//
////generic functions nit specific//generic type T
//fun comparePosts(post1:Post,post2:Post):Post{   //instead of creaiting 10 functions
//    //does something
//    return post1
//}
//fun compareComment(comment1:Comment,comment2:Comment):Comment{
//    //do something
//    return comment2
//}
//interface a contract between two systems