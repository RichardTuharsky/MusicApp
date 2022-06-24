package com.daco;

import java.util.*;

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
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0) {
            System.out.println("Tento playlist nema ziadne pesnicky");
        } else {
            System.out.println("Now playing" + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("Ziadna pesnicka nieje k dispozicii, sme na konci zoznamu");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing" + listIterator.previous().toString());
                    } else {
                        System.out.println("Sme na prvej pensnicke");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now playing" + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Sme na zatiacku zoznamu");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing"+ listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Dostal isme sa na koniec zoznamu");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing"+ listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing"+ listIterator.previous().toString());
                        }
                    }

            }
        }

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
