package com.daco;

public class Main {
    public static void main(String[] args) {

        Album4 album = new Album4(name: "Album1", artist: "AC/DC");

        album.addSong(title: "TNT", duration: 4.5);
        album.addSong(title: "Highway to hell", duration: 3.5);
        album.addSong(title: "Next song", duration: 4.7);

    }
}
