package com.google.android.exoplayer2.gx;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.demo.R;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.util.Log;

public class FilePlayerActivity extends AppCompatActivity {

  protected StyledPlayerView mPlayerView;
  protected @Nullable
  ExoPlayer mPlayer;
  private String filePath = "/storage/emulated/0/lake.mp4";

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.player_activity);
    mPlayerView = findViewById(R.id.player_view);
    initPlayer(filePath);
  }

  private void initPlayer(String playUri) {
    if (playUri == null) {
      Log.d("ExoTest", "playUri is null!");
      return;
    }

    /* 1.创建SimpleExoPlayer实例 */
    mPlayer = new ExoPlayer.Builder(this).build();

    /* 2.创建播放菜单并添加到播放器 */
    MediaItem firstLocalMediaItem = MediaItem.fromUri(playUri);
    mPlayer.addMediaItem(firstLocalMediaItem);

    /* 3.设置播放方式为自动播放 */
    mPlayer.setPlayWhenReady(true);

    /* 4.将SimpleExoPlayer实例设置到StyledPlayerView中 */
    mPlayerView.setPlayer(mPlayer);
    /* 5，设置播放器状态为prepare */
    mPlayer.prepare();
  }

}
