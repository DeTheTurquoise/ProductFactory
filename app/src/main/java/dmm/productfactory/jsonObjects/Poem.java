package dmm.productfactory.jsonObjects;

public class Poem {

    private String title;
    private String poemText;
    private int pageNumber;


    public Poem(String title, String poemText, int pageNumber) {
        this.title = title;
        this.poemText = poemText;
        this.pageNumber = pageNumber;
    }
}
