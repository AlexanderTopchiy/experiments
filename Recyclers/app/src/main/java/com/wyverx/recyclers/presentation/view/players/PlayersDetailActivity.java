package com.wyverx.recyclers.presentation.view.players;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wyverx.recyclers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersDetailActivity extends AppCompatActivity {

    @BindView(R.id.players_detail_text_view)
    TextView mPlayersDetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_detail);

        ButterKnife.bind(this);

        Intent playersDetailIntent = getIntent();

        String playerInfo =
                playersDetailIntent.getIntExtra("Place", 0) + "\n" +
                playersDetailIntent.getStringExtra("Last name") + " " +
                playersDetailIntent.getStringExtra("First name") + "\n" +
                playersDetailIntent.getStringExtra("Country") + "\n" +
                playersDetailIntent.getIntExtra("Elo", 0) + "\n" +
                playersDetailIntent.getIntExtra("Memorized", 0);

        mPlayersDetailTextView.setText(playerInfo);
    }
}
