
public class Main {
    public static void main(String[] args)  {
        Books books = new Books("Math Cries","Syndar","20/01/2024","Adventure");

        System.out.println("Book Author " + books.getBookAuthor());
        System.out.println("Book Name " + books.getBookName());
        System.out.println("Book WriteDate " + books.getBookWriteDate());
        System.out.println("Book Genre " + books.getBookGenre());
        books.genreCheckerAdd();
        //Deletes book by genre// books.genreCheckerRemove();

        System.out.println(books.getGenreAdventure());
        System.out.println(books.getGenreCriminal());
        System.out.println(books.getGenreDrama());
        System.out.println(books.getGenreFantasy());
        System.out.println(books.getGenrePsyhological());
        System.out.println(books.getGenreSelfDevelopment());





    }
}