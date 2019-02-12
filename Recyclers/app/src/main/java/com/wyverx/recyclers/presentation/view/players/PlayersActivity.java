package com.wyverx.recyclers.presentation.view.players;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.wyverx.recyclers.R;
import com.wyverx.recyclers.data.repositories.players.PlayersRepositoryImpl;
import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.domain.threading.MainThreadImpl;
import com.wyverx.recyclers.domain.threading.ThreadExecutor;
import com.wyverx.recyclers.presentation.presenter.players.PlayersPresenter;
import com.wyverx.recyclers.presentation.presenter.players.PlayersPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersActivity extends AppCompatActivity implements PlayersPresenter.View {

    private PlayersPresenter mPresenter;

    @BindView(R.id.players_text_view)
    TextView mPlayersTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        ButterKnife.bind(this);

        mPresenter = new PlayersPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new PlayersRepositoryImpl());
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }


    @Override
    public void displayPlayersList(List<Player> playersList) {
        String result = "";
        for (Player player : playersList) {
            result += player.getName() + "\n";
        }
        mPlayersTextView.setText(result);
    }


    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
