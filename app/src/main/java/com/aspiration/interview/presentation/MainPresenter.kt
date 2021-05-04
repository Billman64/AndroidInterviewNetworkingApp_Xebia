package com.aspiration.interview.presentation

import com.aspiration.interview.domain.InterviewTaskUseCaseInterface
import com.aspiration.interview.presentation.base.BasePresenterImpl
import javax.inject.Inject

class MainPresenter @Inject constructor(private val useCase: InterviewTaskUseCaseInterface) :
    BasePresenterImpl<MainAgreement.View>(), MainAgreement.Presenter {
    // TODO implement your methods for fetching here
}