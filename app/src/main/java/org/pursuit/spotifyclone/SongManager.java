package org.pursuit.spotifyclone;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import org.pursuit.spotifyclone.song_list.Song;

import java.io.File;
import java.util.ArrayList;

public class SongManager {
    final String MEDIA_PATH =MediaStore.Audio.Media.getContentUri("external").toString();
    private Context c;

    public SongManager(Context c) {
        this.c = c;
    }

    public ArrayList<Song> getSongsFromStorage() {
        ArrayList<Song> songList = new ArrayList<>();
        ContentResolver contentResolver = c.getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null, null, null, null);

        if (songCursor != null && songCursor.moveToFirst()) {
            int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);

            do {
                long currentId = songCursor.getLong(songId);
                String currentTitle = songCursor.getString(songTitle);
                songList.add(new Song(currentTitle));
            } while (songCursor.moveToNext());
        }
        assert songCursor != null;
        songCursor.close();
        return songList;
    }

//    ArrayList<String> findSongs(String rootPath) {
//        ArrayList<String> fileList = new ArrayList<>();
//        try {
//            File rootFolder = new File(rootPath);
//            File[] files = rootFolder.listFiles(); //here you will get NPE if directory doesn't contains  any file,handle it like this.
//            for (File file : files) {
//                if (file.isDirectory()) {
//                    if (findSongs(file.getAbsolutePath()) != null) {
//                        fileList.addAll(findSongs(file.getAbsolutePath()));
//                    } else {
//                        break;
//                    }
//                } else if (file.getName().endsWith(".mp3")) {
//                    fileList.add(file.getAbsolutePath());
//                }
//            }
//            return fileList;
//        } catch (Exception e) {
//            return null;
//        }
//    }

}
