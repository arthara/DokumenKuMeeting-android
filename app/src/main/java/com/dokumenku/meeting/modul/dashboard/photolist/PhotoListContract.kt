package com.dokumenku.meeting.modul.dashboard.photolist

import com.dokumenku.meeting.base.BasePresenter
import java.io.File

interface PhotoListContract {
    interface Presenter : BasePresenter{
        fun loadFiles(folderName: String?)
        fun createNewFolder(folderName: String)
        fun openPhoto(folderName: String?, fileName: String)
    }

    interface View{
        fun showList(fileList: Array<String>?)
        fun showPhoto(pdf: File)
        fun redirectToNewPhotoPage()
    }
}