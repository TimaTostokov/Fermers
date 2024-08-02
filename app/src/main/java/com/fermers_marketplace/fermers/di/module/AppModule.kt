package com.fermers_marketplace.fermers.di.module

import com.fermers_marketplace.fermers.domain.usecase.ChangeButtonIconAndTextColorUseCase
import com.fermers_marketplace.fermers.domain.usecase.ResetLastSelectedButtonUseCase
import com.fermers_marketplace.fermers.domain.usecase.SelectInitialButtonUseCase
import com.fermers_marketplace.fermers.domain.usecase.SetupButtonClickListenerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSetupButtonClickListenerUseCase(): SetupButtonClickListenerUseCase {
        return SetupButtonClickListenerUseCase()
    }

    @Provides
    @Singleton
    fun provideSelectInitialButtonUseCase(): SelectInitialButtonUseCase {
        return SelectInitialButtonUseCase()
    }

    @Provides
    @Singleton
    fun provideResetLastSelectedButtonUseCase(): ResetLastSelectedButtonUseCase {
        return ResetLastSelectedButtonUseCase()
    }

    @Provides
    @Singleton
    fun provideChangeButtonIconAndTextColorUseCase(): ChangeButtonIconAndTextColorUseCase {
        return ChangeButtonIconAndTextColorUseCase()
    }

}