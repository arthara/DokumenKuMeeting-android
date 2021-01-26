package com.dokumenku.meeting.modul.dashboard.pdflist

import com.dokumenku.meeting.base.BasePresenter

interface PdfListContract {
    interface Presenter : BasePresenter{
        fun loadFiles(folderName : String?)
    }

    interface View{
        fun showList(fileList : Array<String>?)
    }
}