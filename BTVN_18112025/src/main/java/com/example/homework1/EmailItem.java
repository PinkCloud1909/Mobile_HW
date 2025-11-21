package com.example.homework1;

public class EmailItem {
    public String sender;
    public String title;
    public String preview;
    public String time;
    public String avatarChar;

    public EmailItem(String sender, String title, String preview, String time) {
        this.sender = sender;
        this.title = title;
        this.preview = preview;
        this.time = time;
        this.avatarChar = sender.substring(0, 1).toUpperCase();
    }
}
