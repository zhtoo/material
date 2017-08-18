package com.hs.myfirstkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.hs.myfirstkotlin.adapter.MyViewPagwerAdapter

// 使用来自主代码集的 R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mytext.setText("12312132")
//        testSetText("大家好")
        testSetText("大家好", "我叫Kotlin")
        //skip2Activity()
        //轮播图
        myViewPager.adapter = MyViewPagwerAdapter(this, 4)
        myViewPager.currentItem = 0
        startPlay()
    }

    var handler = Handler()


    fun startPlay() {

        Thread(Runnable {
            synchronized(this) {

                for (i in 1..4) {// for循环
                    try {
                        Thread.sleep(5000)//休眠5秒

                      //  myViewPager.currentItem = i
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }).start()


    }


    fun skip2Activity(view: View) {
        //获取intent对象
        val intent = Intent()
        // 获取class是使用::反射
        intent.setClass(this, TestActivity::class.java)
        //正常的java代码
        startActivity(intent)
    }

    fun testSetText(str: String?) {
        mytext.text = str
    }

    fun testSetText(str: String?, name: String?) {
        mytext.setText(name)
    }
}
