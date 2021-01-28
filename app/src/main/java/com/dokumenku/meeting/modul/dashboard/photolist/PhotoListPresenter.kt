package com.dokumenku.meeting.modul.dashboard.photolist

import android.content.Context
import android.util.Log
import com.dokumenku.meeting.shared.FileManagerUtils
import java.io.File
import java.util.*

class PhotoListPresenter(private val view: PhotoListContract.View, context: Context): PhotoListContract.Presenter{
    companion object{
        private const val TAG = "PhotoListPresenter"
    }
    private val baseFolder = context.getExternalFilesDir(FileManagerUtils.MOM_PHOTO_PATH)

    override fun loadFiles(folderName: String?) {
        val listFile = FileManagerUtils.loadFiles(baseFolder, folderName)

        Log.d(TAG, "Loading Files : ${Arrays.toString(listFile)}")
        view.showList(listFile)
    }

    override fun start() {
        //TODO : Remove CreateNewFolder and openpdf
        createNewFolder("Empty Folder")
        loadFiles(null)
    }

    override fun createNewFolder(folderName: String) {
        if(FileManagerUtils.createNewFolder(baseFolder, folderName)){
            Log.d(TAG, "Buat Folder Berhasil")
            //TODO : update list or something
        }
    }

    override fun openPhoto(folderName: String?, fileName: String) {
        val file = if(folderName != null)
            File(baseFolder, "$folderName/$fileName")
        else
            File(baseFolder, fileName)
        view.showPhoto(file)
    }
}