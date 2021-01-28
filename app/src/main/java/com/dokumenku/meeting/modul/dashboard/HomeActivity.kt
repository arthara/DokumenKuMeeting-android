package com.dokumenku.meeting.modul.dashboard

import com.dokumenku.meeting.base.BaseFragmentHolderActivity
import com.dokumenku.meeting.modul.dashboard.pdflist.PdfListFragment

class HomeActivity : BaseFragmentHolderActivity(){
    companion object{
        private const val TAG = "HomeActivity"
    }

    override fun initializeFragment() {
        initializeView()
        setCurrentFragment(PdfListFragment(), true)
    }
}