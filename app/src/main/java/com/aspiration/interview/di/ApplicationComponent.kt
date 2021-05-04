package com.aspiration.interview.di

import com.aspiration.interview.di.modules.ApplicationModule
import com.aspiration.interview.di.modules.NetworkingModule
import com.aspiration.interview.di.modules.PresenterModule
import com.aspiration.interview.di.modules.RxModule
import com.aspiration.interview.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkingModule::class, RxModule::class, ApplicationModule::class, PresenterModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}