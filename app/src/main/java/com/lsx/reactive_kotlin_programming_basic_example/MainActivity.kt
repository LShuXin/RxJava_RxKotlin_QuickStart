package com.lsx.reactive_kotlin_programming_basic_example

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lsx.reactive_kotlin_programming_basic_example.ui.theme.ReactivekotlinprogrammingbasicexampleTheme
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

class MainActivity : ComponentActivity() {
    private val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startStream();
            }
        })
    }

    private fun startStream() {
        var list = listOf<Int>(1, 2, 3, 4, 5)
        list.toObservable()
            .subscribeBy(
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("onComplete") }
            )
    }
}
