package com.dokumenku.meeting.modul.dashboard.pdflist

import com.dokumenku.meeting.base.BasePresenter
import java.io.File

interface PdfListContract {
    interface Presenter : BasePresenter{
        fun loadFiles(folderName: String?)
        fun createNewFolder(folderName: String)
        fun openPdf(folderName: String?, fileName: String)
    }

    interface View{
        fun showList(fileList: Array<String>?)
        fun showPdf(pdf: File)
        fun redirectToNewPdfPage()
    }
}