package com.hs.myfirstkotlin.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.hs.myfirstkotlin.R

/**
 * 作者：zhanghaitao on 2017/8/1 17:00
 * 邮箱：820159571@qq.com
 */
class MyViewPagwerAdapter (context: Context,pageCount: Int): PagerAdapter() {

    private var context: Context? = context
    private var pageCount: Int = pageCount

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return pageCount
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }


    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        var imageView: ImageView? = ImageView(context)
        var resId: Int
        when (position) {
            0 -> {
                resId = R.drawable.ic_lunbo1
            }
            1 -> {
                resId = R.drawable.ic_lunbo2
            }
            2 -> {
                resId = R.drawable.ic_lunbo3
            }
            else -> {
                resId = R.drawable.ic_lunbo4
            }
        }
        imageView?.setImageDrawable(container?.context?.resources?.getDrawable(resId))
        var layoutParams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView?.layoutParams = layoutParams
        imageView?.scaleType = ImageView.ScaleType.CENTER_CROP
        container?.addView(imageView)
        return imageView!!
    }

}