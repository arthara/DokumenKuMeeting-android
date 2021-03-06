package com.dokumenku.meeting.modul.dashboard.pdflist

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

class PdfListFragment : BaseFragment<HomeActivity, PdfListContract.Presenter>(), PdfListContract.View {
    companion object{
        private const val TAG = "PdfListFragment"
    }
//    TODO : Need Proper Activity, this one is temporary

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        fragmentView = inflater.inflate(R.layout.activity_pdf_mom, container, false)
        mPresenter = PdfListPresenter(this, activity.applicationContext)
        mPresenter.start()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showList(fileList: Array<String>?) {
        Log.d("TesList", "Showing List : ${Arrays.toString(fileList)}")
    }

    override fun showPdf(pdfFile: File) {
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = FileProvider.getUriForFile(activity
                , "${this.context?.packageName}.provider"
                , pdfFile)

        intent.setDataAndType(uri, "application/pdf")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        Log.d(TAG, "Opening PDF")
        startActivity(intent)
    }

    override fun redirectToNewPdfPage() {
        // TODO : Not Yet Implemented
    }
}