package com.example.helloworld.api;

public class Saying {
    private long id;

    private String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Saying() {
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Saying saying = (Saying)obj;
        if(saying.getContent().equals(this.getContent())){
            return true;
        }
        return false;
    }

    public String getContent() {
        return content;
    }
}
