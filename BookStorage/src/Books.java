public class Books extends Genre implements Interfaces{
    private String bookName;
    private String bookAuthor;
    private String bookWriteDate;
    private String bookGenre;


    public Books (String bookName,String bookAuthor,String bookWriteDate,String bookGenre){
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookWriteDate = bookWriteDate;
        this.bookGenre = bookGenre;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookWriteDate() {
        return bookWriteDate;
    }

    public String genreCheckerAdd(){
        switch (bookGenre){
            case Genre.Adventure:
                genreAdventure.add(bookName + bookAuthor + bookWriteDate + "Adventure");
                break;
            case Genre.Drama:
                genreDrama.add(bookName + bookAuthor + bookWriteDate + "Drama");
                break;
            case Genre.Criminal:
                genreCriminal.add(bookName + bookAuthor + bookWriteDate + "Criminal");
                break;
            case Genre.Fantasy:
                genreFantasy.add(bookName + bookAuthor + bookWriteDate + "Fantasy");
                break;
            case Genre.SelfDevelepoment:
                genreFantasy.add(bookName + bookAuthor + bookWriteDate + "SelfDevelopment");
                break;
            case Genre.Psychological:
                genrePsyhological.add(bookName + bookAuthor + bookWriteDate + "Psychological");
                break;
            default:
                throw new IllegalStateException("Unexpected genre: " + bookGenre);
        }
        return null;
    }

    public String genreCheckerRemove(){

        switch (bookGenre){
            case Genre.Adventure:
                genreAdventure.removeFirst();
                break;
            case Genre.Drama:
                genreDrama.removeFirst();
                break;
            case Genre.Criminal:
                genreCriminal.removeFirst();
                break;
            case Genre.Fantasy:
                genreFantasy.removeFirst();
                break;
            case Genre.SelfDevelepoment:
                genreSelfDevelopment.removeFirst();
                break;
            case Genre.Psychological:
                genrePsyhological.removeFirst();
                break;
            default:
                throw new IllegalStateException("Unexpected genre: " + bookGenre);
        }
        return null;
    }


}

