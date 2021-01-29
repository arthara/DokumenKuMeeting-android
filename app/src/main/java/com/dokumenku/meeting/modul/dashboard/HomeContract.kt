package com.dokumenku.meeting.modul.dashboard

import com.dokumenku.meeting.base.BasePresenter

interface HomeContract {
    interface Presenter : BasePresenter {
        fun syncData()
    }

    interface View{
        fun redirectToProfilePage()
        fun loadGoogleAccountPhoto()
        fun changeListToPdf()
        fun changeListToPhoto()
    }
}