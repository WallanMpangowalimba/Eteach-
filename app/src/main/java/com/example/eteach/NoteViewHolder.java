package com.example.eteach;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView notetv, nametv;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        notetv = itemView.findViewById(R.id.note_tv);
        nametv = itemView.findViewById(R.id.name_tv);
    }
}
