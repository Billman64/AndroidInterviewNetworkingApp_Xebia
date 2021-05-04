package com.aspiration.interview.di.modules

import android.content.Context
import com.aspiration.interview.data.InterviewTaskRepository
import com.aspiration.interview.data.network.service.ApiService
import com.aspiration.interview.di.qualifiers.ApplicationContext
import com.aspiration.interview.di.qualifiers.SchedulerIO
import com.aspiration.interview.domain.InterviewTaskUseCase
import com.aspiration.interview.domain.InterviewTaskUseCaseInterface
import com.aspiration.interview.domain.repository.InterviewTaskRepositoryInterface
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext() = context

    @Provides
    fun provideRepository(api: ApiService): InterviewTaskRepositoryInterface =
        InterviewTaskRepository(api)

    @Provides
    fun provideUsecase(
        repository: InterviewTaskRepositoryInterface,
        @SchedulerIO scheduler: Scheduler
    ): InterviewTaskUseCaseInterface = InterviewTaskUseCase(scheduler, repository)
}