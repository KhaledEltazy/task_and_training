package com.android.taskandtraining.module

import com.android.taskandtraining.adapter.MyAdapter
import com.android.taskandtraining.single_responsibility.Countries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module  {

    @Provides
    fun provideCountries() = Countries()

    @Provides
    fun provideAdapter() = MyAdapter()
}