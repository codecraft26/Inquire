package dev.aman.inquire

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import io.github.kbiakov.codeview.classifier.CodeProcessor

class InquireApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        CodeProcessor.init(this);
    }
}
