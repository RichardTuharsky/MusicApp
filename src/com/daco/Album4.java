package com.daco;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album4{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album4(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album4() {

    }
    public Song findSong(String title) {
        for(Song checkedSong : songs) {
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    //boolean because return value should be true when succesfully add new song and false when not
    public boolean addSong(String title, double duration) {
        //ked ideme pridavat song musime sa pozriet ci nahodou uz neexistuje
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            System.out.println(title + "Uspesne pridana do listu");
            return true;
        } else {
            System.out.println("Pesnicka s tymto menom" + title + "uz existuje v zozname");
            return false;
        }
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList) {
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()) {
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("Tento album nema pesnicku s trackovacim cislom" +trackNumber);
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song>PlayList){
        for(Song checkedSong : this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title+"Neexistuje takato pesnicka");
        return false;
    }
}
