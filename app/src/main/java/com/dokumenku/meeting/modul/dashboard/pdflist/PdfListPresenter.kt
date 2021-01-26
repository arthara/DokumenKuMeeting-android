package com.dokumenku.meeting.modul.dashboard.pdflist

import android.content.Context
import android.util.Log
import java.io.File
import java.util.*

class PdfListPresenter: PdfListContract.Presenter{
    private val view: PdfListContract.View
    private val baseFolder: File

    companion object{
        private const val TAG = "PdfListPresenter"
        private const val PATH = "pdf"
    }

    constructor(view : PdfListContract.View, context : Context){
        this.view = view
        baseFolder = context.getDir(PATH, Context.MODE_PRIVATE)
        Log.d(TAG, "Base Folder : ${baseFolder.absolutePath}")
        if(baseFolder.isDirectory)
            Log.d(TAG, "Base Folder is created successfully")
    }

    override fun loadFiles(folderName: String?) {
        val listFile = if(folderName != null)
            File(baseFolder, folderName).list()
        else
            baseFolder.list()

        Log.d(TAG, "Loading Files : ${Arrays.toString(listFile)}")
        view.showList(listFile)
    }

    override fun start() {
        loadFiles(null)
    }
}