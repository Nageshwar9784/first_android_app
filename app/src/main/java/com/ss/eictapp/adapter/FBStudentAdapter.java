package com.ss.eictapp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ss.eictapp.R;

public class FBStudentAdapter extends RecyclerView.ViewHolder {
    View v;
    public FBStudentAdapter(@NonNull View itemView) {
        super(itemView);
        v=itemView;
    }
    public void setView(Context context, int id, String name, String branch, int age, String imageUrl)
    {
        TextView sid, sname, sbranch, sage;
        ImageView iv;
        sid=v.findViewById(R.id.sid);
        sname=v.findViewById(R.id.sname);
        sbranch=v.findViewById(R.id.sbranch);
        sage=v.findViewById(R.id.sage);
        iv=v.findViewById(R.id.image);
        sid.setText(String.valueOf(id));
        sage.setText(String.valueOf(age));
        sname.setText(String.valueOf(name));
        sbranch.setText(branch);
        Picasso.get().load(imageUrl).into(iv);
    }
}
