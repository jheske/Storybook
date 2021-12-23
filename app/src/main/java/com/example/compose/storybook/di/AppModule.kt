package com.example.compose.storybook.di

import android.content.Context
import com.example.compose.storybook.StorybookApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): StorybookApplication {
        return app as StorybookApplication
    }

    @Provides
    @Singleton
    fun provideContext(application: StorybookApplication): Context {
        return application.applicationContext
    }
}
