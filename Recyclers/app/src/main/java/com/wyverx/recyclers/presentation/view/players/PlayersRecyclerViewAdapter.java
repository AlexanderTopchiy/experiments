package com.wyverx.recyclers.presentation.view.players;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wyverx.recyclers.presentation.view.players.ViewHolder;

import com.wyverx.recyclers.R;
import com.wyverx.recyclers.domain.players.models.Player;

import java.util.List;

public class PlayersRecyclerViewAdapter
        extends RecyclerView.Adapter<ViewHolder> {

    private List<Player> mPlayersList;


    public PlayersRecyclerViewAdapter() {

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_rv_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Player player = mPlayersList.get(position);
        holder.mPlayersTextView.setText(player.getFullName());
    }


    @Override
    public int getItemCount() {
        return mPlayersList.size();
    }


    public void setDataToAdapter(List<Player> playersList) {
        mPlayersList = playersList;
    }
}
