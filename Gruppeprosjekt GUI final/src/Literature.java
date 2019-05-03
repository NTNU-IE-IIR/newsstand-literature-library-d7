public abstract class Literature {
    protected String title;
    protected String publisher;

    public Literature(String title, String publisher){
        this.title = title;
        this.publisher = publisher;
    }

    public String getTitle(){
        return title;
    }

    public String getPublisher(){
        return publisher;
    }
}