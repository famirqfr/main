package ir.qwerty.myapplication.model;

import android.net.Uri;

import java.net.URL;

public class MessageModel {
    Uri image;
    String name;
    String date;
    String context;

    public MessageModel(String image, String name, String date, String context) {
        this.image = Uri.parse(image);
        this.name = name;
        this.date = date;
        this.context = context;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
