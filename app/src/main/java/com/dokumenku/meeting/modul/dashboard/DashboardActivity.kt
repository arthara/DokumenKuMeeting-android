package com.dokumenku.meeting.modul.dashboard

import com.dokumenku.meeting.base.BaseFragmentHolderActivity
import com.dokumenku.meeting.modul.dashboard.pdflist.PdfListFragment

class DashboardActivity : BaseFragmentHolderActivity(){
    override fun initializeFragment() {
        initializeView()
        setCurrentFragment(PdfListFragment(), true)
    }
}