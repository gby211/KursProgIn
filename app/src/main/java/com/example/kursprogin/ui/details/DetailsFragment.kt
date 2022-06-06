package com.example.kursprogin.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursprogin.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

//    private val parent_view: View? = null
//    private var viewPager: ViewPager? = null
//    private var layout_dots: LinearLayout? = null
//    private var adapterImageSlider: AdapterImageSlider? = null
//
//    private val array_image_product = intArrayOf(
//        R.drawable.image_shop_9,
//        R.drawable.image_shop_10,
//        R.drawable.image_shop_11,
//        R.drawable.image_shop_12,
//        R.drawable.image_shop_13
//    )
//
//    public override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_details)
//        initToolbar()
//        initComponent()
//    }
//
//    private fun initToolbar() {
//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        toolbar.setNavigationIcon(R.drawable.ic_menu)
//        setSupportActionBar(toolbar)
//        getSupportActionBar()?.setTitle("Product")
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
//    }
//
//    private fun initComponent() {
//        layout_dots = findViewById<View>(R.id.layout_dots) as LinearLayout?
//        viewPager = findViewById<View>(R.id.pager) as ViewPager?
//        adapterImageSlider = AdapterImageSlider(this, ArrayList<Image>())
//        val items: MutableList<Image> = ArrayList<Image>()
//        for (i in array_image_product) {
//            items.add( ContextCompat.getDrawable(this, R.drawable.diski_png) )
//        }
//        adapterImageSlider!!.setItems(items)
//        viewPager!!.adapter = adapterImageSlider
//
//        // displaying selected image first
//        viewPager!!.currentItem = 0
//        addBottomDots(layout_dots, adapterImageSlider!!.count, 0)
//        viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {
//            override fun onPageScrolled(
//                pos: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//            }
//
//            override fun onPageSelected(pos: Int) {
//                addBottomDots(layout_dots, adapterImageSlider!!.count, pos)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {}
//        })
//    }
//
//    private fun addBottomDots(layout_dots: LinearLayout?, size: Int, current: Int) {
//        val dots = arrayOfNulls<ImageView>(size)
//        layout_dots!!.removeAllViews()
//        for (i in dots.indices) {
//            dots[i] = ImageView(this)
//            val width_height = 15
//            val params =
//                LinearLayout.LayoutParams(ViewGroup.LayoutParams(width_height, width_height))
//            params.setMargins(10, 10, 10, 10)
//            dots[i]!!.layoutParams = params
//            dots[i]!!.setImageResource(R.drawable.shape_circle)
//            dots[i]!!
//                .setColorFilter(
//                    ContextCompat.getColor(this, R.color.overlay_dark_10),
//                    PorterDuff.Mode.SRC_ATOP
//                )
//            layout_dots.addView(dots[i])
//        }
//        if (dots.size > 0) {
//            dots[current]!!
//                .setColorFilter(
//                    ContextCompat.getColor(this, R.color.colorPrimaryLight),
//                    PorterDuff.Mode.SRC_ATOP
//                )
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.menu_search_setting, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home) {
//            finish()
//        } else {
//            Toast.makeText(getApplicationContext(), item.title, Toast.LENGTH_SHORT).show()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//
//    private class AdapterImageSlider(private val act: Activity, items: List<Image>) :
//        PagerAdapter() {
//        private var items: List<Image>
//        private var onItemClickListener: OnItemClickListener? = null
//
//        private interface OnItemClickListener {
//            fun onItemClick(view: View?, obj: Image?)
//        }
//
//        fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
//            this.onItemClickListener = onItemClickListener
//        }
//
//        override fun getCount(): Int {
//            return items.size
//        }
//
//        fun getItem(pos: Int): Image {
//            return items[pos]
//        }
//
//        fun setItems(items: List<Image>) {
//            this.items = items
//            notifyDataSetChanged()
//        }
//
//        override fun isViewFromObject(view: View, `object`: Any): Boolean {
//            return view === `object` as RelativeLayout
//        }
//
//        override fun instantiateItem(container: ViewGroup, position: Int): Any {
//            val o: Image = items[position]
//            val inflater = act.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val v: View = inflater.inflate(R.layout.item_slider_image, container, false)
//            val image = v.findViewById<View>(R.id.image) as ImageView
//            val lyt_parent: MaterialRippleLayout =
//                v.findViewById<View>(R.id.lyt_parent) as MaterialRippleLayout
//            Tools.displayImageOriginal(act, image, o.image)
//            lyt_parent.setOnClickListener(View.OnClickListener { v ->
//                if (onItemClickListener != null) {
//                    onItemClickListener!!.onItemClick(v, o)
//                }
//            })
//            (container as ViewPager).addView(v)
//            return v
//        }
//
//        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//            (container as ViewPager).removeView(`object` as RelativeLayout)
//        }
//
//        // constructor
//        init {
//            this.items = items
//        }
//    }

}