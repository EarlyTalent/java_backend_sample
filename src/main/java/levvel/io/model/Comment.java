package levvel.io.model;

import lombok.Data;

@Data
public class Comment {
    private String author;
    private String text;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
