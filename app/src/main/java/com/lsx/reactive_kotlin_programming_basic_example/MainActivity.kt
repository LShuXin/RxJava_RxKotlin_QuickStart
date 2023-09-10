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
        val myObserver = getObserver()
        val myObservable = getObservable()
        myObservable.safeSubscribe(myObserver)
    }

    private fun getObserver(): Observer<String> {
        return object: Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe")
            }
            override fun onNext(t: String) {
                Log.d(TAG, "onNext: $t")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError:" + e.message)
            }
            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }
        }
    }

    private fun getObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }
}
