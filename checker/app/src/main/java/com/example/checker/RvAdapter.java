package com.example.checker;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CustomViewHolder> {

    private ArrayList<Ch_schedule> itemList;
    final LottieAnimationView checkMark = null;

    public RvAdapter(ArrayList<Ch_schedule> itemList) {
        this.itemList = itemList;

    }



    @NonNull
    @Override
    public RvAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final RvAdapter.CustomViewHolder holder, int position) {

        holder.tv_scheduleName.setText(itemList.get(position).getSchedule_name());
        holder.tv_scheduleCont.setText(itemList.get(position).getSchedule_content());

        holder.itemView.setTag(position);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String curName = holder.tv_scheduleName.getText().toString();
                String curCon = holder.tv_scheduleCont.getText().toString();
                holder.checkBox.isChecked();


            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
}

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void remove(int position){//삭제
        try{
            itemList.remove(position);
            notifyItemRemoved(position);
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_scheduleName;
        protected TextView tv_scheduleCont;
        protected CheckBox checkBox;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_scheduleName = (TextView)itemView.findViewById(R.id.item_tv_scheduleName);
            this.tv_scheduleCont = (TextView)itemView.findViewById(R.id.item_tv_scheduleCont);
            this.checkBox = (CheckBox)itemView.findViewById(R.id.checkbox);

        }
    }
}
