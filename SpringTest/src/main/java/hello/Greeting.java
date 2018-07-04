package hello;

public class Greeting {
    private final long id;

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    private final String text;

    public Greeting(long id, String text) {
        this.id = id;
        this.text = text;
    }
}
