package com.aspiration.interview.presentation

import com.aspiration.interview.presentation.base.BasePresenter
import com.aspiration.interview.presentation.base.BaseView

interface MainAgreement {
    interface View : BaseView {
        // TODO set UI reflection methods
    }

    interface Presenter : BasePresenter<View> {
        // TODO set API request (usecase) methods invocation


    }
}