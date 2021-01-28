package com.dokumenku.meeting.modul.dashboard.photolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import com.dokumenku.meeting.R
import com.dokumenku.meeting.base.BaseFragment
import com.dokumenku.meeting.modul.dashboard.HomeActivity
import java.io.File
import java.util.*

class PhotoListFragment : BaseFragment<HomeActivity, PhotoListContract.Presenter>(), PhotoListContract.View {
    companion object{
        private const val TAG = "PhotoListFragment"
    }
//    TODO : Need Proper Activity, this one is temporary

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        fragmentView = inflater.inflate(R.layout.activity_pdf_mom, container, false)
        mPresenter = PhotoListPresenter(this, activity.applicationContext)
        mPresenter.start()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showList(fileList: Array<String>?) {
        Log.d("TesList", "Showing List : ${Arrays.toString(fileList)}")
    }

    override fun showPhoto(pdfFile: File) {
        // TODO : Not Yet Implemented
    }

    override fun redirectToNewPhotoPage() {
        // TODO : Not Yet Implemented
    }
}