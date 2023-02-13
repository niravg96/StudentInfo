package com.example.studentinfo;

import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentCustomAdapter extends RecyclerView.Adapter<StudentCustomAdapter.StudentViewHolder> {

    List<StudentModel> studentlist;
    StudentModel studentModel;

    public StudentCustomAdapter(List<StudentModel> studentlist){
        this.studentlist = studentlist;
    }

    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.custom_student_layout,parent,false);
        return new StudentViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        studentModel = studentlist.get(position);
        holder.tvid.setText(studentModel.getId());
        holder.tvname.setText(studentModel.getName());
        holder.tvsurname.setText(studentModel.getSurname());
        holder.tvage.setText(studentModel.getAge());
        holder.tvdob.setText(studentModel.getDob());
        holder.tvcity.setText(studentModel.getCity());
        holder.tvstate.setText(studentModel.getState());
        holder.tvdegree.setText(studentModel.getDegree());
    }
    @Override
    public int getItemCount() {
        return studentlist.size();
    }
    public class StudentViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvid,tvname,tvsurname,tvage,tvdob,tvcity,tvstate,tvdegree;

        public StudentViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tvid  =(TextView) itemView.findViewById(R.id.tvid);
            tvname  =(TextView) itemView.findViewById(R.id.tvname);
            tvsurname  =(TextView) itemView.findViewById(R.id.tvsurname);
            tvage  =(TextView) itemView.findViewById(R.id.tvage);
            tvdob  =(TextView) itemView.findViewById(R.id.tvdob);
            tvcity  =(TextView) itemView.findViewById(R.id.tvcity);
            tvstate  =(TextView) itemView.findViewById(R.id.tvstate);
            tvdegree  =(TextView) itemView.findViewById(R.id.tvdegree);
        }
    }
}
