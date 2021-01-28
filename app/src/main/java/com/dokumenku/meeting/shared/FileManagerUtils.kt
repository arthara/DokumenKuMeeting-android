package com.dokumenku.meeting.shared

import android.util.Log
import java.io.File
import java.util.*

class FileManagerUtils private constructor(){
    companion object{
        private const val TAG = "FileUtils"
        const val PDF_PATH = "document"
        private const val PHOTO_PATH = "photo"
        const val MOM_PHOTO_PATH = "$PHOTO_PATH/mom"
        const val LOGO_PHOTO_PATH = "$PHOTO_PATH/logo_company"
        const val SIGNATURE_PHOTO_PATH = "$PHOTO_PATH/ttd"

        fun loadFiles(baseFolder: File?, folderName: String?): Array<String>? {
            val listFile = if(folderName != null)
                File(baseFolder, folderName).list()
            else
                baseFolder?.list()

            Log.d(TAG, "Loading Files : ${Arrays.toString(listFile)}")
            return listFile
        }

        fun createNewFolder(baseFolder: File?, folderName: String): Boolean {
            val newFolder = File(baseFolder, folderName)
            val isSuccess = newFolder.mkdir()

            if(isSuccess)
                Log.d(TAG, "Created New Folder, ${newFolder.absolutePath}")

            return isSuccess
        }
    }
}