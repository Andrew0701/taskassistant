package com.example.andrew.taskassistant.ui.sign_in

import android.content.Intent
import android.os.Bundle
import com.example.andrew.taskassistant.R
import com.example.andrew.taskassistant.ui.base.BaseActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity() {

    companion object {
        const val SIGN_IN_CODE = 12
    }

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        configureSignInClient()

        btn_sign_in.setOnClickListener { signIn() }

        checkUserLogin()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGN_IN_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {
        val account = task?.getResult(ApiException::class.java)

        if (account == null) {
            showMessage("Some error")
        } else {
            showMessage(account.displayName)
        }
    }

    private fun showMessage(message: String?) {
        tv_text.text = message
    }

    override fun initViews() {
        super.initViews()

    }

    private fun configureSignInClient() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
    }

    private fun signIn() {
        val singInIntent = googleSignInClient.signInIntent
        startActivityForResult(singInIntent, SIGN_IN_CODE)
    }

    private fun checkUserLogin() {
        val account = GoogleSignIn.getLastSignedInAccount(this)

        if (account == null) {
            showLogInScreen()
        } else {
            showMainScreen()
        }
    }

    private fun showMainScreen() {
        tv_text.text = "You are already logged in"
    }

    private fun showLogInScreen() {

    }
}