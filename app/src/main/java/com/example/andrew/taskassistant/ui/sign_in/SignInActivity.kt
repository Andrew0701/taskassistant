package com.example.andrew.taskassistant.ui.sign_in

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.andrew.taskassistant.R
import com.example.andrew.taskassistant.ui.base.BaseActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.android.synthetic.main.activity_sign_in.*
import timber.log.Timber

class SignInActivity : BaseActivity() {

    companion object {
        const val SIGN_IN_CODE = 12
    }

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        configureSignInClient()

        btn_sign_in.setOnClickListener { signOut() }
        btn_google_sign_in.setOnClickListener { signIn() }

        checkUserLogin()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == SIGN_IN_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task?.getResult(ApiException::class.java)

            handleSignInResult(account)
        }
    }

    private fun handleSignInResult(account: GoogleSignInAccount?) {
        if (account == null) {
            showMessage("Some error")
        } else {
            showMessage(account.displayName + "\n" + account.email)
        }
    }

    private fun showMessage(message: String?) {
        Timber.v(message)
        Log.e("TAG", message)
    }

    override fun initViews() {
        super.initViews()

    }

    private fun configureSignInClient() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
    }

    private fun signIn() {
        val singInIntent = googleSignInClient.signInIntent
        startActivityForResult(singInIntent, SIGN_IN_CODE)
    }

    private fun signOut() {
//        FirebaseAuth.getInstance().signOut()
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener { checkUserLogin() }
    }

    private fun checkUserLogin() {
        val account = GoogleSignIn.getLastSignedInAccount(this)

        handleSignInResult(account)
    }
}