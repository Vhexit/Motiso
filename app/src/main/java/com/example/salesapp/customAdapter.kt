package com.example.salesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class customAdapter(var context: Context, var data:ArrayList<Productss>): BaseAdapter() {
        private class ViewHolder(row: View?){
            var mTxtName: TextView
            var mTxtcloth: TextView
            var mTxtype: TextView
            var mTxtsize: TextView
            init {
                this.mTxtName = row?.findViewById(R.id.mTvName) as TextView
                this.mTxtcloth = row?.findViewById(R.id.mTvcloth) as TextView
                this.mTxtype = row?.findViewById(R.id.mTvtype) as TextView
                this.mTxtsize = row?.findViewById(R.id.mTvsize) as TextView
            }
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view: View?
            var viewHolder:ViewHolder
            if (convertView == null){
                var layout = LayoutInflater.from(context)
                view = layout.inflate(R.layout.myitem_layout,parent,false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            }else{
                view = convertView
                viewHolder = view.tag as ViewHolder
            }
            var item:Productss = getItem(position) as Productss
            viewHolder.mTxtName.text = item.name
            viewHolder.mTxtcloth.text = item.cloth
            viewHolder.mTxtype.text = item.type
            return view as View
        }



        override fun getItem(position: Int): Any {
            return  data.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return data.count()
        }
    }
