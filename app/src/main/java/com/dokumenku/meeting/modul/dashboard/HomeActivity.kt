package com.dokumenku.meeting.modul.dashboard

import android.util.Log
import com.bumptech.glide.Glide
import com.dokumenku.meeting.R
import com.dokumenku.meeting.base.BaseFragmentHolderActivity
import com.dokumenku.meeting.modul.dashboard.pdflist.PdfListFragment
import com.dokumenku.meeting.modul.dashboard.photolist.PhotoListFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn


class HomeActivity : BaseFragmentHolderActivity(), HomeContract.View{
    private val photoList = PhotoListFragment()
    private val pdfList = PdfListFragment()
    private val presenter = HomePresenter(this)

    companion object{
        private const val TAG = "HomeActivity"
    }

    override fun initializeView() {
        super.initializeView()
        loadGoogleAccountPhoto()
    }

    override fun initializeFragment() {
        initializeView()
        changeListToPdf()
    }

    override fun redirectToProfilePage() {
        // TODO("Not yet implemented")
    }

    override fun loadGoogleAccountPhoto() {
        val acct = GoogleSignIn.getLastSignedInAccount(this)

        if (acct != null) {
            Log.d(TAG, "Loading photo from url : ${acct.photoUrl.toString()}")
            Glide.with(this)
                .load(acct.photoUrl)
                .into(findViewById(R.id.profile_photo))
        }
    }

    override fun changeListToPdf() {
        //TODO : Add some kind of feedback that user is currently seeing pdfList
        setCurrentFragment(pdfList, false)
    }

    override fun changeListToPhoto() {
        //TODO : Add some kind of feedback that user is currently seeing pdfList
        setCurrentFragment(photoList, false)
    }
}