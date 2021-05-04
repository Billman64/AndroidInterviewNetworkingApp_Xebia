package com.aspiration.interview.presentation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aspiration.interview.InterviewTaskApplication
import com.aspiration.interview.R
import com.aspiration.interview.data.model.LatinMedia
import com.aspiration.interview.data.model.LatinMediaItem
import com.aspiration.interview.presentation.base.BaseActivity
import com.aspiration.interview.presentation.base.ItemAdapter

class MainActivity :
    BaseActivity<MainAgreement.Presenter, MainAgreement.View>(R.layout.activity_main),
    MainAgreement.View {

    override fun setupInputs() {
        InterviewTaskApplication.applicationComponent?.inject(this)

        // TODO add your click listeners here
        this.findViewById<Button>(R.id.btnFetch).setOnClickListener {



            Toast.makeText(this, "testing", Toast.LENGTH_SHORT)
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

    override fun returnThisHerePlease(): MainAgreement.View = this

}