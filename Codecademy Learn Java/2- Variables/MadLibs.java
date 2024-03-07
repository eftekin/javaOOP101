public class MadLibs {
    /*
     * This program generates a mad libbed story.
     * Author: Mustafa
     * Date: 17/10/2023
     */
    public static void main(String[] args) {
        String name1 = "Mustafa";
        String name2 = "Atadan";
        String adjective1 = "peaceful";
        String adjective2 = "afraid";
        String adjective3 = "hopeless";
        String verb1 = "run";
        String noun1 = "banana";
        String noun2 = "candle";
        String noun3 = "speaker";
        String noun4 = "orange";
        String noun5 = "pen";
        String noun6 = "mouse";
        int number = 1;
        String place1 = "Istanbul";

        // The template for the story
        String story = "This morning " + name1 + " woke up feeling " + adjective1 + ". 'It is going to be a "
                + adjective2 + " day!' Outside, a bunch of " + noun1 + "s were protesting to keep " + noun2
                + " in stores. They began to " + verb1 + " to the rhythm of the " + noun3 + ", which made all the "
                + noun4 + "s very " + adjective3 + ". Concerned, " + name1 + " texted " + name2 + ", who flew " + name1
                + " to " + place1 + " and dropped " + name1 + " in a puddle of frozen " + noun5 + ". " + name1
                + " woke up in the year " + number + ", in a world where " + noun6 + "s ruled the world.";

        System.out.println(story);
    }
}
