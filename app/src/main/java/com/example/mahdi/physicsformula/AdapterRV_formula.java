package com.example.mahdi.physicsformula;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterRV_formula extends RecyclerView.Adapter<AdapterRV_formula.itemViewHolder> {
    private Context context;
    private List<items> itemss;

    public AdapterRV_formula(Context context , List<items>itemss)
    {
        this.context=context;
        this.itemss=itemss;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder( itemViewHolder holder, int position) {

        final items items=itemss.get(position);
        holder.title.setText(items.getTitle());
        holder.content.setText(items.getContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,item_activity.class); //کامل شود
               // intent.putExtra(DatabaseOpenHelper.COL_ID,items.getId());
                intent.putExtra(Database_asset_helper.COL_TITLE,items.getTitle());
                intent.putExtra(Database_asset_helper.COL_CONTENT,items.getContent());
                intent.putExtra(Database_asset_helper.COL_IMG,items.getImage());
                context.startActivities(new Intent[]{intent});
            }
        });
    }



    @Override
    public int getItemCount() {
        return itemss.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView content;
        private ImageView imageView;

        public itemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.Title);
            content = itemView.findViewById(R.id.Content);
            imageView=itemView.findViewById(R.id.img_IA);
        }
    }
}
