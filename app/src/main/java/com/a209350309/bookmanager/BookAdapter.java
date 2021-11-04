package com.a209350309.bookmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    //数据源
    private ArrayList<Book> books;

    //定义长按对象
    private View.OnLongClickListener longClickListener;

    //定义点击对象
    private View.OnClickListener clickListener;

    public BookAdapter(View.OnLongClickListener longClickListener, View.OnClickListener clickListener) {
        this.longClickListener = longClickListener;
        this.clickListener = clickListener;
    }

    //给成员对象传值
    public void setLongClickListener(View.OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    //给成员对象传值
    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setDataChange(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();//刷新
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建列表项布局视图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.DataBind(books.get(position));

        //将监听对象与列表项绑定在一起
        holder.itemView.setOnLongClickListener(longClickListener);

        //将监听对象与列表项绑定在一起
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return books == null ? 0 : books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvName;
        private TextView tvAuthor;
        private TextView tvPublish;
        private TextView tvPrice;

        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.id);
            tvName = itemView.findViewById(R.id.name);
            tvAuthor = itemView.findViewById(R.id.author);
            tvPublish = itemView.findViewById(R.id.publish);
            tvPrice = itemView.findViewById(R.id.price);

            this.itemView = itemView;
        }

        public void DataBind(Book book) {
            itemView.setTag(book);

            //将列表项与数据绑定在一起
            tvId.setText(String.valueOf(book.getId()));
            tvName.setText(book.getName());
            tvAuthor.setText(book.getAuthor());
            tvPublish.setText(book.getPublish());
            tvPrice.setText(String.valueOf(book.getPrice()));
        }
    }
}
