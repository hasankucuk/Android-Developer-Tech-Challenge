package com.techchallange.app.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager.getDefaultSharedPreferences


class PreferencesHelper private constructor(context: Context) {
    private val mPreferences: SharedPreferences = getDefaultSharedPreferences(context)
    private val mEditor: SharedPreferences.Editor

    companion object {

        private var instance: PreferencesHelper? = null

        const val PROP_USERNAME = "prop.login.username"
        const val PROP_PASSWORD = "prop.login.password"
        const val PROP_REMEMBER_ME = "prop.login.remember.me"


        fun getInstance(context: Context): PreferencesHelper {
            if (instance == null)
                instance = PreferencesHelper(context)
            return instance as PreferencesHelper
        }
    }

    init {
        mEditor = mPreferences.edit()
    }

    var username: String?
        get() = mPreferences.getString(PROP_USERNAME, "")
        set(userId) {
            mEditor.putString(PROP_USERNAME, userId)
            mEditor.commit()
        }

    var password: String?
        get() = mPreferences.getString(PROP_PASSWORD, "")
        set(userId) {
            mEditor.putString(PROP_PASSWORD, userId)
            mEditor.commit()
        }

    var rememberMe: Boolean
        get() = mPreferences.getBoolean(PROP_REMEMBER_ME, false)
        set(value) {
            mEditor.putBoolean(PROP_REMEMBER_ME, value)
            mEditor.commit()
        }


    fun clear() {
        mEditor.clear().commit()
    }

}
