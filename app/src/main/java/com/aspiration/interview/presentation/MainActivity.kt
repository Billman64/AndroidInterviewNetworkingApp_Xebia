package com.aspiration.interview.presentation

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aspiration.interview.InterviewTaskApplication
import com.aspiration.interview.R
import com.aspiration.interview.data.model.LatinMedia
import com.aspiration.interview.data.model.LatinMediaItem
import com.aspiration.interview.data.network.service.ApiService
import com.aspiration.interview.presentation.base.BaseActivity
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity :
    BaseActivity<MainAgreement.Presenter, MainAgreement.View>(R.layout.activity_main),
    MainAgreement.View {

    val TAG = "demo"

    override fun setupInputs() {
        InterviewTaskApplication.applicationComponent?.inject(this)   //crashes here???

        // TODO add your click listeners here
        this.findViewById<Button>(R.id.btnFetch).setOnClickListener {
            showLoading()

            val dataApi = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)

//            GlobalScope.launch(Dispatchers.IO){

            CoroutineScope(Dispatchers.IO).launch{
                try{








                    // mock data

                    val item1 = LatinMediaItem(
                            42,
                            1,
                            "someTitle",
                            "some body of text"
                    )

                    val item2 = LatinMediaItem(
                            1,
                            2,
                            "someOtherTitle",
                            "some other body of text"
                    )


                    val list = LatinMedia()
                    list.add(item1)
                    list.add(item2)

                    Log.d(TAG, "list count: ${list.count()}")


                    withContext(Dispatchers.Main){
                        hideLoading()

                        val rv = findViewById<RecyclerView>(R.id.recyclerView)
                        rv.layoutManager = LinearLayoutManager(baseContext)
                        val adapter = ItemAdapter(list)
                        rv.adapter = adapter
                        rv.visibility = View.VISIBLE

                    }
                } catch(e:Exception){
                    Log.e(TAG, "net error! ${e.message}")

                    withContext(Dispatchers.Main){
                        hideLoading()
                        showError()
                    }
                }
            }
        }
    }

    override fun showLoading() {
        // TODO show progress when data is loading
        this.findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
    }

    override fun hideLoading() {
        // TODO hide progress and button when data came
        this.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
    }

    // TODO add method for data population to the recycler view
    // TODO add method for showing error state

    fun populateDataInRecyclerView(list:LatinMedia){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(list)
    }

    fun showError(){
        this.findViewById<TextView>(R.id.tvError).visibility = View.VISIBLE
    }

    fun hideError(){
        this.findViewById<TextView>(R.id.tvError).visibility = View.GONE
    }

    override fun returnThisHerePlease(): MainAgreement.View = this

}