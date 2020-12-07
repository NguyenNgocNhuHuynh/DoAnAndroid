package com.example.ungdungdocbao.Models;

import org.w3c.dom.Text;

import java.util.Date;

public class Post {

//    $table->bigIncrements('id');
//    $table->string('title');
//    $table->dateTime('pubDate');
//    $table->string('link')->nullable();
//    $table->string('guid')->nullable();
//    $table->string('author')->nullable();
//    $table->string('thumbnail')->nullable();
//    $table->string('description');
//    $table->string('content');
//    $table->boolean('status');
//    $table->unsignedBigInteger('idcat');

    private int id;
    private String title;
    private String pubDate;
    private String link;
    private String guid;
    private String author;
    private String thumbnail;
    private String description;
    private String content;
    private int status;
    private int idcat;

    public Post(int id, String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, int status, int idcat) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.status = status;
        this.idcat = idcat;
    }



    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }
}

