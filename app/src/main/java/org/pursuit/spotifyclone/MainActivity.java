package org.pursuit.spotifyclone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.pursuit.spotifyclone.song_list.Song;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private Button pauseButton;
    public static final String TAG = "MainActivity.class";
    private List<Song> songList;
    private MediaPlayer currentSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initSongManager();
        Log.d(TAG, "onCreate: " + songList.get(0).title);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    void initSongManager() {
        SongManager songManager = new SongManager(this);
        songList = songManager.getSongsFromStorage();
    }

    void initViews() {
        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
//        currentSong = MediaPlayer.create(this, )
    }

}
