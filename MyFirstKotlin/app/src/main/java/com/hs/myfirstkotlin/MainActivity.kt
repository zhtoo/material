package com.hs.myfirstkotlin


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
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

        var str:String = "my name is rd"

        str = str.replace("rd","hs")

    }

    var handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            myViewPager.currentItem = msg!!.what
        }
    }

    fun startPlay() {

//        while (true){
//            for (i in 1..4) {// for循环从1到4
//                try {
//                    Thread.sleep(1000)//休眠5秒
//                    handler.sendEmptyMessage(i);
//                    //  myViewPager.currentItem = i
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }

//        var msg = Message()
//        msg.what = 1
//        handler.sendMessageDelayed(msg, 1000)

        Thread(Runnable {
            //保持代码同步
            synchronized(this) {
                for (i in 1..4000) {// for循环从1到4000
                    try {
                        Thread.sleep(3000)//休眠3秒
                        handler.sendEmptyMessage(i)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }).start()
    }

    /**
     * activity的跳转
     */
    fun skip2Activity(view: View) {
        //获取intent对象
        val intent = Intent()
        // 获取class是使用 :: 反射
        intent.setClass(this, TestActivity::class.java)
        //正常的java代码
        startActivity(intent)
        Log.d("123456","12346546")
    }

    fun testSetText(str: String?) {
        mytext.text = str
    }

    fun testSetText(str: String?, name: String?) {
        mytext.setText(name)
    }
}
