package com.example.cx.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cx on 17/1/3.
 */

class MyAdapter extends RecyclerView.Adapter {

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName,tvContent,tvSize;
        private ImageView tvImage;

        public ViewHolder(View root) {
            super(root);
            tvName = (TextView) root.findViewById(R.id.name);
            tvContent = (TextView) root.findViewById(R.id.content);
            tvSize = (TextView) root.findViewById(R.id.size);
            tvImage = (ImageView) root.findViewById(R.id.imageView);


        }

        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvContent() {
            return tvContent;
        }

        public TextView getTvSize() {
            return tvSize;
        }

        public ImageView getTvImage() {
            return tvImage;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //通过资源文件创建，创建布局解释器，解析布局
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        Item cd = data[position];

        vh.getTvName().setText(cd.name);
        vh.getTvContent().setText(cd.content);
        vh.getTvSize().setText(cd.size);
        vh.getTvImage().setImageResource(cd.drawableId);



    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    //自定义数据对象
   private Item[] data = new Item[]{
            new Item("探探","13.92M","互相喜欢才能聊天的零骚扰社交", R.drawable.p1),
            new Item("极无双（真三手游版）","306.6M","3D动作军团征战手游",R.drawable.p2),
            new Item("芒果TV","29.38M","湖南台唯一官方视频软件",R.drawable.p3),
            new Item("永恒纪元城","144.7M","高冷法师贵族式战斗",R.drawable.p4)

   };


}