package com.dokumenku.meeting.modul.dashboard.pdflist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dokumenku.meeting.R
import com.dokumenku.meeting.base.BaseFragment
import com.dokumenku.meeting.modul.dashboard.DashboardActivity
import java.util.*

class PdfListFragment : BaseFragment<DashboardActivity, PdfListContract.Presenter>(), PdfListContract.View {
//    TODO : Need Proper Activity, this one is temporary

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        fragmentView = inflater.inflate(R.layout.activity_pdf_mom, container, false)
        mPresenter = PdfListPresenter(this, activity.baseContext)
        mPresenter.start()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showList(fileList: Array<String>?) {
        Log.d("TesList", "Showing List : ${Arrays.toString(fileList)}")
    }
}