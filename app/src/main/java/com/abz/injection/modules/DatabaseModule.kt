package com.abz.injection.modules

import android.content.Context
import com.abz.core.pagination.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideResourceDao(appDatabase: AppDatabase) = appDatabase.getResourceDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getInstance(appContext)
}