package com.fermers_marketplace.fermers.di.module

import android.content.Context
import com.fermers_marketplace.fermers.domain.usecase.ChangeButtonIconAndTextColorUseCase
import com.fermers_marketplace.fermers.domain.usecase.ResetLastSelectedButtonUseCase
import com.fermers_marketplace.fermers.domain.usecase.SelectInitialButtonUseCase
import com.fermers_marketplace.fermers.domain.usecase.SetupButtonClickListenerUseCase
import com.fermers_marketplace.fermers.utils.pref.ProfileSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): ProfileSharedPreferences {
        return ProfileSharedPreferences(context)
    }

}