package el1000mile.tpd2.b5twa.navdrawer;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static el1000mile.tpd2.b5twa.navdrawer.R.id.imageView;

/**
 * Created by KeMoOoOoO on 9/18/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    Context c ;
    ArrayList<News> news ;

    public RecyclerAdapter(Context c, ArrayList<News> news) {
        this.c = c;
        this.news = news;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

            TextView title , desc , by , date , url  ;
            ImageView img;
            ProgressBar pb;

        public ViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.Title);
//            desc=(TextView)itemView.findViewById(R.id.Desc);
            by=(TextView)itemView.findViewById(R.id.by);
            date=(TextView)itemView.findViewById(R.id.Date);

            url=(TextView)itemView.findViewById(R.id.url);

            img=(ImageView)itemView.findViewById(R.id.NewsImage);

            pb=(ProgressBar)itemView.findViewById(R.id.progresBar);




        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(c).inflate(R.layout.rec_model ,parent ,  false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, final int position) {



        News n = news.get(position);
        holder.title.setText(n.getTitle());
//        holder.desc.setText(n.getDesc());




        if (n.getDate() != "null" ||
             n.getDate() != null ||
             !n.getImg().equals("null") ||
             n.getImg() != null   ||
             !n.getBy().equals("null") ||
             n.getBy() != null) {

            holder.date.setText(n.getDate());
            holder.by.setText(n.getBy());



            ImageLoader.getInstance().displayImage(n.getImg(), holder.img, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                    holder.pb.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    holder.pb.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });







        } else {
            holder.date.setText("Not Set ");
            holder.by.setText("Not Set ");
            holder.img.setImageResource(R.drawable.text_lines);

        }





    }

    @Override
    public int getItemCount() {
        return news.size();
    }



}
