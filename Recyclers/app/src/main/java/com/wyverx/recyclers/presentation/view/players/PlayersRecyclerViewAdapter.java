package com.wyverx.recyclers.presentation.view.players;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyverx.recyclers.R;
import com.wyverx.recyclers.domain.players.models.Player;

import java.util.List;

public class PlayersRecyclerViewAdapter
        extends RecyclerView.Adapter<PlayersRecyclerViewAdapter.ViewHolder> {

    private List<Player> mPlayersList;


    public PlayersRecyclerViewAdapter(List<Player> playersList) {
        mPlayersList = playersList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_rv_item, parent, false);
        return new ViewHolder(view);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mPlayersTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mPlayersTextView = itemView.findViewById(R.id.players_text_view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Player player = mPlayersList.get(position);
        String playerName = player.getLastName() + " " + player.getFirstName();
        holder.mPlayersTextView.setText(playerName);
    }


    @Override
    public int getItemCount() {
        return mPlayersList.size();
    }
}
