package com.jiyuns.alatan_kaoshi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyuns.alatan_kaoshi.R;
import com.jiyuns.alatan_kaoshi.bean.DataBean;

import java.util.ArrayList;

/**
 * 阿拉坦   H1810B
 * Date: 2019/6/13
 * Time: 11:32
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<DataBean> dataBeans;

    public MyAdapter(Context context, ArrayList<DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    public void setList(ArrayList<DataBean> dataBeans) {
        if (dataBeans != null) {
            this.dataBeans.addAll(dataBeans);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        if (i == 100) {
            View inflate = LinearLayout.inflate(context, R.layout.item_title_layout, null);
            viewHolder = new ViewHolder1(inflate);
        } else {
            if (i == 200) {
                View inflate = LinearLayout.inflate(context, R.layout.item_tuer_layout, null);
                viewHolder = new ViewHolder2(inflate);
            } else {
                if (i == 300) {
                    View inflate = LinearLayout.inflate(context, R.layout.item_layout1, null);
                    viewHolder = new ViewHolder3(inflate);
                } else {
                    View inflate = LinearLayout.inflate(context, R.layout.item_layout2, null);
                    viewHolder = new ViewHolder4(inflate);
                }
            }
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DataBean dataBean = dataBeans.get(i);
        if (viewHolder instanceof ViewHolder1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.titleName.setText(dataBean.getTitle());
            Glide.with(context).load(dataBean.getPic()).into(viewHolder1.titleImage);
        } else {
            if (viewHolder instanceof ViewHolder2) {
                ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
                viewHolder2.title1.setText(dataBean.getTitle());
                viewHolder2.title2.setText(dataBean.getTitle());
                Glide.with(context).load(dataBean.getPic()).into(viewHolder2.Image1);
                Glide.with(context).load(dataBean.getPic()).into(viewHolder2.Image2);
            } else {
                if (viewHolder instanceof ViewHolder3) {
                    ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
                    viewHolder3.name1.setText(dataBean.getTitle());
                    Glide.with(context).load(dataBean.getPic()).into(viewHolder3.img1);
                } else {
                    if (viewHolder instanceof ViewHolder4) {
                        ViewHolder4 viewHolder4 = (ViewHolder4) viewHolder;
                        viewHolder4.name2.setText(dataBean.getTitle());
                        Glide.with(context).load(dataBean.getPic()).into(viewHolder4.img2);
                    }
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 100;
        } else {
            if (position == 1) {
                return 200;
            } else {
                if (position % 2 == 0) {
                    return 300;
                } else {
                    return 400;
                }
            }
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView titleName;
        ImageView titleImage;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            this.titleName = (TextView) itemView.findViewById(R.id.titleName);
            this.titleImage = (ImageView) itemView.findViewById(R.id.titleImage);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView Image1;
        TextView title1;
        ImageView Image2;
        TextView title2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            this.Image1 = (ImageView) itemView.findViewById(R.id.Image1);
            this.title1 = (TextView) itemView.findViewById(R.id.title1);
            this.Image2 = (ImageView) itemView.findViewById(R.id.Image2);
            this.title2 = (TextView) itemView.findViewById(R.id.title2);
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView name1;
        ImageView img1;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            this.name1 = (TextView) itemView.findViewById(R.id.name1);
            this.img1 = (ImageView) itemView.findViewById(R.id.img1);
        }
    }

    public class ViewHolder4 extends RecyclerView.ViewHolder {
        TextView name2;
        ImageView img2;

        public ViewHolder4(@NonNull View itemView) {
            super(itemView);
            this.name2 = (TextView) itemView.findViewById(R.id.name2);
            this.img2 = (ImageView) itemView.findViewById(R.id.img2);
        }
    }


}
