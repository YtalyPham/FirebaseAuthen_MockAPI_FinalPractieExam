package com.example.phamngocnhuy_18055121;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private ArrayList<Student> listStudents;
    private Context context;
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list,parent,false);
        RecyclerViewHolder recylerViewHolder = new RecyclerViewHolder(v);
        return recylerViewHolder;
    }


    public RecyclerAdapter(ArrayList<Student> listStudents, Context context) {
        this.listStudents = listStudents;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Student stu = listStudents.get(position);
        holder.tvID.setText(stu.getId());
        holder.tvName.setText(stu.getName());
        holder.tvClass.setText(stu.getClasshoc());
        holder.tvStatus.setText(stu.getStatus());
        holder.tvWorkingAt.setText(stu.getWorkingAt());

    }



    @Override
    public int getItemCount() {
        return listStudents.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView tvID;
        public TextView tvName;
        public TextView tvClass;
        public TextView tvStatus;
        public TextView tvWorkingAt;
        public Button btnDelete,btnUpdate;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvClass = itemView.findViewById(R.id.tvClass);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvWorkingAt = itemView.findViewById(R.id.tvWorking);

            btnDelete=itemView.findViewById(R.id.btnDelete);
            btnUpdate=itemView.findViewById(R.id.btnUpdate);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mPosition=getLayoutPosition();
                    Student s= listStudents.get(mPosition);
                    Intent i = new Intent(context,DeleteScreen.class);
                    i.putExtra("id",s.getId());
                    context.startActivity(i);
                }
            });

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mPosition=getLayoutPosition();
                    Student s= listStudents.get(mPosition);
                    Intent i = new Intent(context,UpdateScreen.class);
                    i.putExtra("id",s.getId());
                    i.putExtra("name",s.getName());
                    i.putExtra("classhoc",s.getClasshoc());
                    i.putExtra("status",s.getStatus());
                    i.putExtra("working",s.getWorkingAt());
                    context.startActivity(i);
                }
            });

        }
    }
}
