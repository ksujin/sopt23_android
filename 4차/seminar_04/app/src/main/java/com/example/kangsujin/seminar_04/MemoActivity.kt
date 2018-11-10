package com.example.kangsujin.seminar_04

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.kangsujin.seminar_04.adapter.MemoRecyclerViewAdapter
import com.example.kangsujin.seminar_04.data.MemoData
import com.example.kangsujin.seminar_04.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_memo.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MemoActivity : AppCompatActivity() {
    //사실 얘도 lazy 써도 됨
    lateinit var memoRecyclerViewAdapter: MemoRecyclerViewAdapter
    val dataList : ArrayList<MemoData> by lazy {
        ArrayList<MemoData>()
    }
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager!!.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0)
    }

    fun setupUI(view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    hideSoftKeyboard(this@MemoActivity)
                    return false
                }
            })
        }

        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until (view as ViewGroup).childCount) {
                val innerView = (view as ViewGroup).getChildAt(i)
                setupUI(innerView)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        setupUI(findViewById(R.id.view_memo_act_parent))
        setRecyclerView()
        btn_memo_act_logout.setOnClickListener {
            SharedPreferenceController.clearUserSharedPreferences(this)
            startActivity<LoginActivity>()
            finish()
        }
        btn_memo_act_add_memo.setOnClickListener {
            val title = et_memo_act_title.text.toString()
            val content = et_memo_act_content.text.toString()
            if (title.isNotEmpty() && content.isNotEmpty()){
                /*val position = memoRecyclerViewAdapter.itemCount
                memoRecyclerViewAdapter.dataList.add(MemoData(title, content)) //recycMemoRecyclerViewAdapter.notifyDataSetChanged()
                //특정데이터 하나 들어갔을때 좋은 것. 어디 들어갈거냐. -> position
                memoRecyclerViewAdapter.notifyItemInserted(position)*/
                memoRecyclerViewAdapter.addNewItem(MemoData(title, content))
            }

        }
        srl_memo_act_refresh.setOnRefreshListener {
            toast("새로 고침!")
            //이곳에 서버 통신과 같은 로직을 구현해주시면 됩니다!!
            srl_memo_act_refresh.isRefreshing = false // 뺑뺑이 멈추기!
        }

    }
    private fun setRecyclerView() { //임시 데이터

        memoRecyclerViewAdapter = MemoRecyclerViewAdapter(this, dataList)
        rv_memo_act_memo_list.adapter = memoRecyclerViewAdapter
        rv_memo_act_memo_list.layoutManager = LinearLayoutManager(this)
    }
}
