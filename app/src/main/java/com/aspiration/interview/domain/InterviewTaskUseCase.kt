package com.aspiration.interview.domain

import com.aspiration.interview.domain.repository.InterviewTaskRepositoryInterface
import io.reactivex.Scheduler

class InterviewTaskUseCase(
    private val ioScheduler: Scheduler,
    private val repository: InterviewTaskRepositoryInterface
) :
    InterviewTaskUseCaseInterface {
    // TODO mandatory: use usecase as a proxy for your data and just return what came from server
    // TODO mandatory: write logs that represents success/error state
    // TODO optional: add header after each item. For more details, look into Readme file
}