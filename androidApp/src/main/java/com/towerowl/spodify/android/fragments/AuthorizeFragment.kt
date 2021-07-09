package com.towerowl.spodify.android.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.towerowl.spodify.Secrets
import com.towerowl.spodify.android.R

class AuthorizeFragment : Fragment(R.layout.fragment_authorize) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authorize()
    }

    private fun authorize() {
        val authRequest = AuthorizationRequest
            .Builder(
                Secrets.SPOTIFY_CLIENT_ID,
                AuthorizationResponse.Type.TOKEN,
                Secrets.SPOTIFY_REDIRECT_URI
            )
            .setShowDialog(true)
            .build()

        AuthorizationClient.openLoginActivity(
            requireActivity(),
            REQUEST_AUTH_TOKEN_CODE,
            authRequest
        )
    }

    companion object {
        const val REQUEST_AUTH_TOKEN_CODE = 0x11
    }

}