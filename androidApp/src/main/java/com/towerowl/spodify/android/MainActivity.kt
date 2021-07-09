package com.towerowl.spodify.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.towerowl.spodify.android.fragments.AuthorizeFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            AuthorizeFragment.REQUEST_AUTH_TOKEN_CODE -> {
                val data = AuthorizationClient.getResponse(resultCode, data)
            }
        }

    }
}
