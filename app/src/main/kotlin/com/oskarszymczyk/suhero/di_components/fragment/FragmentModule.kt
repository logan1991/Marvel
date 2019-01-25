package com.oskarszymczyk.suhero.di_components.fragment

import com.oskarszymczyk.core.rest.NetworkService
import com.oskarszymczyk.suhero.repos.SuperheroListRepository
import com.oskarszymczyk.suhero.ui.adapters.WelcomeAdapter
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SelectedSuperheroManger
import dagger.Module
import dagger.Provides

@Module
class FragmentModule{

    @Provides
    @FragmentScope
    fun provideSuperheroListRepository(networkService: NetworkService) = SuperheroListRepository(networkService)

    @Provides
    @FragmentScope
    fun provideSelectedSuperheroManger() = SelectedSuperheroManger()

    @Provides
    @FragmentScope
    fun provideWelcomeAdapter(selectedSuperheroManger: SelectedSuperheroManger) = WelcomeAdapter(selectedSuperheroManger)
}
