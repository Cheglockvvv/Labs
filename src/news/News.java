package csdev;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private String text = "";
    private String date = "";

    public News() {
        text = "example";
        date = "01-01-2000";
    }

    public News(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public void printWithDate() {
        System.out.println(date);
        System.out.println(text);
    }

    public void printWithoutDate() {
        System.out.println(text);
    }

    public String getText() {
        return this.text;
    }

    public String getDate() {
        return this.date;
    }
}
