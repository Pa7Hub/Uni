package Q3.programming.hue3.src;

public class Entry implements Data {
    private String contents;

    public Entry(String content) {
        this.contents = content;
    }

    @Override
    public String getContents() {
        return this.contents;
    }

}
