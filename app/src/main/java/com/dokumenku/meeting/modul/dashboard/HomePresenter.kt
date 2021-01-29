package com.dokumenku.meeting.modul.dashboard

class HomePresenter(private val view: HomeContract.View): HomeContract.Presenter{
    override fun syncData() {
        //TODO : Sync data after google drive integrated
    }

    override fun start() {
        syncData()
    }
}