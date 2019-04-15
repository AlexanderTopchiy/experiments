package com.wyverx.recyclers.presentation.view.players;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.recyclers.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView mPlayersTextView;

    public ViewHolder(View itemView) {
        super(itemView);
        mPlayersTextView = itemView.findViewById(R.id.players_text_view);
    }
}
