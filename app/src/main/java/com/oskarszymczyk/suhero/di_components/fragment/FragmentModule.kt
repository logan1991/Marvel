package com.oskarszymczyk.suhero.di_components.fragment

import com.oskarszymczyk.core.rest.NetworkService
import com.oskarszymczyk.suhero.repos.SuperheroListRepository
import dagger.Module
import dagger.Provides

@Module
class FragmentModule{

    @Provides
    @FragmentScope
    fun provideDownloadSuperHeroList(networkService: NetworkService) = SuperheroListRepository(networkService)
}
