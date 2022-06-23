package com.daco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
        private static ArrayList<Album> albums = new ArrayList<>();
        public static void main(String[] args) {


            Album album = new Album("Album1","AC/DC");

            album.addSong("TNT",4.5);
            album.addSong("Song2",3.5);
            album.addSong("Song3",4.1);
            albums.add(album);

            album = new Album("Album2", "Eminem");

            album.addSong("Rap God",2.5);
            album.addSong("Lose yourself",3.7);
            album.addSong("Not Afraid",3.1);

            albums.add(album);

            LinkedList<Song> playList_1 = new LinkedList<>();

            albums.get(0).addToPlayList("TNT",playList_1);
            albums.get(0).addToPlayList("Song2",playList_1);
            albums.get(1).addToPlayList("Rap God",playList_1);

            play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
    //tu pokracovanie 31:17 video
    }
    private static void printMenu() {
            System.out.println("Available options\n press");
            System.out.println("0 - to quit\n" + "1 - to play next song\n" + "2 - to play prvious song\n" + "3 - to replay current song\n" + "4 - list of all songs\n");
    }

    private static void printList(LinkedList<Song> playList) {
            Iterator<Song> iterator = playList.iterator();

            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
    }
}
