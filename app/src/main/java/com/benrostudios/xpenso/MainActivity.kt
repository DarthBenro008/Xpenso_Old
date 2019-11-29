package com.benrostudios.xpenso

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.Fragment
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() ,  BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<BottomNavigationViewEx>(R.id.bottom_bar)
        loadFrag(home_frag())
        navigation.setOnNavigationItemSelectedListener(this)
        navigation.setCurrentItem(1)
    }

    override fun onResume() {
        super.onResume()
        //showBiometricPrompt()
    }

    private fun showBiometricPrompt() {
        val executor = Executors.newSingleThreadExecutor()
        val biometricPrompt = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                loadFrag(AuthenticationFailedFragment())
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                loadFrag(home_frag())
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                loadFrag(AuthenticationFailedFragment())
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.authenticate_title))
            .setSubtitle(getString(R.string.authenticate_subtitle))
            .setNegativeButtonText("Cancel")
            .build()
        biometricPrompt.authenticate(promptInfo)

    }

    private fun loadFrag(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()


            return false
        }
        return true
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        var fragmenthere: Fragment
        when (menuItem.itemId) {
            R.id.navigation_home -> fragmenthere = home_frag()
            R.id.navigation_bal -> fragmenthere = spend_frag()
            R.id.navigation_transactions -> fragmenthere = trans_frag()
            else -> fragmenthere = home_frag()
        }

        loadFrag(fragmenthere)


        return true
    }

}
