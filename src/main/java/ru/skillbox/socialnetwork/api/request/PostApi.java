package ru.skillbox.socialnetwork.api.request;

public class PostApi {

    private String title;

    private String post_text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }
}