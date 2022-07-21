package com.pradeep.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.pradeep.spotifyclone.data.entities.Song
import com.pradeep.spotifyclone.utils.Constants.SONG_COLLECTION
import java.lang.Exception
import kotlinx.coroutines.tasks.await
import java.util.concurrent.Executor


class MusicDatabase {
    private val firestore=FirebaseFirestore.getInstance()
    private val songCollection= firestore.collection(SONG_COLLECTION)


    suspend fun getAllSongs():List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        }catch (e:Exception){
            emptyList<Song>()
        }
    }

}