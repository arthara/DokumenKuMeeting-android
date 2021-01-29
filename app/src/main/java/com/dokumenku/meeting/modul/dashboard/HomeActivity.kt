package com.dokumenku.meeting.modul.dashboard

import android.util.Log
import com.bumptech.glide.Glide
import com.dokumenku.meeting.R
import com.dokumenku.meeting.base.BaseFragmentHolderActivity
import com.dokumenku.meeting.modul.dashboard.pdflist.PdfListFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn


class HomeActivity : BaseFragmentHolderActivity(), HomeContract.View{
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
        setCurrentFragment(PdfListFragment(), true)
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
}