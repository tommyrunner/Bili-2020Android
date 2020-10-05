package com.example.myapplication.entity;

public class JsonEntity {

    /**
     * hitokoto : 正因为生来什么都没有，因此我们能拥有一切。
     * creator : 普通的雾雨魔法使
     * commit_from : web
     * length : 21
     * created_at : 1501842190
     * from : 游戏人生
     * creator_uid : 481
     * id : 1224
     * reviewer : 0
     * type : a
     * from_who : null
     * uuid : b2834ef3-ee81-4dd0-bbd5-53119ebfa6d5
     */
    private String hitokoto;
    private String creator;
    private String commit_from;
    private int length;
    private String created_at;
    private String from;
    private int creator_uid;
    private int id;
    private int reviewer;
    private String type;
    private String from_who;
    private String uuid;

    public void setHitokoto(String hitokoto) {
        this.hitokoto = hitokoto;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setCommit_from(String commit_from) {
        this.commit_from = commit_from;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setCreator_uid(int creator_uid) {
        this.creator_uid = creator_uid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFrom_who(String from_who) {
        this.from_who = from_who;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHitokoto() {
        return hitokoto;
    }

    public String getCreator() {
        return creator;
    }

    public String getCommit_from() {
        return commit_from;
    }

    public int getLength() {
        return length;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getFrom() {
        return from;
    }

    public int getCreator_uid() {
        return creator_uid;
    }

    public int getId() {
        return id;
    }

    public int getReviewer() {
        return reviewer;
    }

    public String getType() {
        return type;
    }

    public String getFrom_who() {
        return from_who;
    }

    public String getUuid() {
        return uuid;
    }
}
