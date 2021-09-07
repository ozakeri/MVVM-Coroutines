package com.example.mvvmapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.adapter.UserListAdapter
import com.example.mvvmapplication.model.User
import com.example.mvvmapplication.utils.Status
import com.example.mvvmapplication.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userListAdapter: UserListAdapter
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUoUi()
        setUpObserve()
    }

    fun setUoUi() {
        userListAdapter = UserListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = userListAdapter
    }

    fun setUpObserve() {
        userViewModel.fetchUser().observe(this, Observer {
            it.let { resourse ->

                when (resourse.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE
                        resourse.data?.let { users -> addData(users) }
                    }

                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.GONE
                        Toast.makeText(this,it.message,Toast.LENGTH_LONG)
                    }

                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }


    fun addData(users: List<User>) {
        userListAdapter.addData(users)
        userListAdapter.notifyDataSetChanged()
    }
}