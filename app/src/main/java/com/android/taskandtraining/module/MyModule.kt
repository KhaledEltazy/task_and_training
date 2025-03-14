package com.android.taskandtraining.module

import com.android.taskandtraining.adapter.MyAdapter
import com.android.taskandtraining.single_responsibility.Cities
import com.android.taskandtraining.single_responsibility.Continents
import com.android.taskandtraining.single_responsibility.Countries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MyModule {
    @Provides
    fun provideCountries() = Countries()

    @Provides
    fun provideCities() = Cities()

    @Provides
    fun providesContinents() = Continents()

    @Provides
    fun provideAdapter() = MyAdapter()
}