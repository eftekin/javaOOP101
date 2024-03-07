import java.util.ArrayList;

class Playlist {

    public static void main(String[] args) {

        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();

        desertIslandPlaylist.add("Till Lindemann");
        desertIslandPlaylist.add("Taylor Swift");
        desertIslandPlaylist.add("The Weeknd");
        desertIslandPlaylist.add("Travis Scott");
        desertIslandPlaylist.add("Metallica");
        desertIslandPlaylist.add("Rammstein");

        System.out.println(desertIslandPlaylist.size());
        desertIslandPlaylist.remove("Taylor Swift");
        System.out.println(desertIslandPlaylist.size());

        int indexA = desertIslandPlaylist.indexOf("Travis Scott");
        int indexB = desertIslandPlaylist.indexOf("The Weeknd");

        String tempA = "Travis Scott";
        desertIslandPlaylist.set(indexA, "Migos");

        System.out.println(desertIslandPlaylist);
    }

}