import java.util.ArrayList;
import java.util.List;

public class Genre {
   public static ArrayList <String> genreAdventure = new ArrayList<>();
    public static ArrayList <String> genreDrama = new ArrayList<>();
    public static ArrayList <String> genreFantasy = new ArrayList<>();
    public static ArrayList <String> genreCriminal = new ArrayList<>();
    public static ArrayList <String> genreSelfDevelopment = new ArrayList<>();
    public static ArrayList <String> genrePsyhological = new ArrayList<>();
    public static final  String Adventure = "Adventure";
    public static final  String Fantasy = "Fantasy";
    public static final  String Criminal = "Criminal";
    public static final  String SelfDevelepoment = "Self-Development";
    public static final  String Psychological = "Psychological";

    public static final String Drama = "Drama";

    public ArrayList<String> getGenreAdventure() {
        return genreAdventure;
    }

    public ArrayList<String> getGenreCriminal() {
        return genreCriminal;
    }

    public ArrayList<String> getGenreDrama() {
        return genreDrama;
    }

    public ArrayList<String> getGenreFantasy() {
        return genreFantasy;
    }

    public ArrayList<String> getGenrePsyhological() {
        return genrePsyhological;
    }

    public ArrayList<String> getGenreSelfDevelopment() {
        return genreSelfDevelopment;
    }
}
