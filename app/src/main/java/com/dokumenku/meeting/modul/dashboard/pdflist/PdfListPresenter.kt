package com.dokumenku.meeting.modul.dashboard.pdflist

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import com.dokumenku.meeting.shared.FileManagerUtils
import java.io.File
import java.util.*

class PdfListPresenter(private val view: PdfListContract.View, context: Context): PdfListContract.Presenter{
    companion object{
        private const val TAG = "PdfListPresenter"
    }
    private val baseFolder = context.getExternalFilesDir(FileManagerUtils.PDF_PATH)

    override fun loadFiles(folderName: String?) {
        val listFile = FileManagerUtils.loadFiles(baseFolder, folderName)

        Log.d(TAG, "Loading Files : ${Arrays.toString(listFile)}")
        view.showList(listFile)
    }

    override fun start() {
        //TODO : Remove CreateNewFolder and openpdf
        createNewFolder("Empty Folder")
        loadFiles(null)
        //openPdf("Empty Folder", "PDF Test.pdf")
    }

    override fun createNewFolder(folderName: String) {
        if(FileManagerUtils.createNewFolder(baseFolder, folderName)){
            Log.d(TAG, "Buat Folder Berhasil")
            //TODO : update list or something
        }
    }

    override fun openPdf(folderName: String?, fileName: String) {
        val file = if(folderName != null)
            File(baseFolder, "$folderName/$fileName")
        else
            File(baseFolder, fileName)
        view.showPdf(file)
    }
}