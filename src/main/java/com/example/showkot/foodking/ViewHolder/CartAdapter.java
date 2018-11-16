package com.example.showkot.foodking.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.showkot.foodking.Common.Common;
import com.example.showkot.foodking.Adapter.AddapteForList;
import com.example.showkot.foodking.Interface.ItemClickListener;
import com.example.showkot.foodking.Model.Order;
import com.example.showkot.foodking.R;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener {

    public TextView txt_cart_name, txt_price;
    public ImageView img_cart_count;

    private ItemClickListener itemClickListener;

    public void setTxt_cart_name(TextView txt_cart_name) {
        this.txt_cart_name = txt_cart_name;
    }

    public CartViewHolder(View itemView){
        super(itemView);
        txt_cart_name = itemView.findViewById(R.id.cart_item_name);
        txt_price = itemView.findViewById(R.id.cart_item_Price);
        img_cart_count = itemView.findViewById(R.id.cart_item_count);
        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onClick(View view){

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle(Common.DELETE);

        menu.add(0,0,getAdapterPosition(),Common.DELETE);
    }
}

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<Order> listData = new ArrayList<>();
    private Context context;
    private AddapteForList la ;
    private Order[] order;

    public CartAdapter(List<Order> listData, Context context){
        this.listData = listData;
        this.context = context;
        la = new AddapteForList();
        order = new Order[listData.size()];

    }


    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        order = la.convert(listData); ///Function to convert the list into an array /// Adapter Pattern
        // This method uses array
        TextDrawable drawable = TextDrawable.builder().buildRound(""+order[position].getQuanlity(), Color.RED);
        holder.img_cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("en","US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(order[position].getPrice()))*(Integer.parseInt(order[position].getQuanlity()));
        holder.txt_price.setText(fmt.format(price));
        holder.txt_cart_name.setText(order[position].getProductName());

    }

    @Override
    public int getItemCount() {

        return listData.size();
    }
}
