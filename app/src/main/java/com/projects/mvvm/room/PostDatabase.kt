package com.projects.mvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.projects.mvvm.models.PostListItem

@Database(entities = [PostListItem::class], version = 1)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao() : PostDao

    companion object {
        @Volatile
        private var INSTANCE : PostDatabase? = null

        fun getDatabase(context: Context) : PostDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        PostDatabase::class.java,
                        "PostDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}