package com.pradeep.spotifyclone.di

import android.content.Context

import android.provider.MediaStore
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class) // as long as our service exists
object ServiceModule {

    @ServiceScoped
    @Provides
    fun provideAudioAttributes()= AudioAttributes.Builder()
        .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
        .setUsage(C.USAGE_MEDIA)
        .build()

    @ServiceScoped
    @Provides
    fun provideExoPlayer(context: Context, audioAttributes: AudioAttributes)
    =ExoPlayer.Builder(context)
        .build().apply {
            setAudioAttributes(audioAttributes,true)
            setHandleAudioBecomingNoisy(true)
        }

    @ServiceScoped
    @Provides
    fun provideDataSourceFactory(
        context: Context
    )=DefaultDataSource.Factory(context).createDataSource()






}