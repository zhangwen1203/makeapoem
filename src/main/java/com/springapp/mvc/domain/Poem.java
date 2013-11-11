package com.springapp.mvc.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Poem implements Serializable{

    private List<String> sentences;

    @NotEmpty
    private String newSentence;

    public Poem(String newSentence) {
        this.newSentence = newSentence;
    }

    public Poem() {
    }

    public Poem(List sentences) {
        this.sentences = sentences;
    }


    public List<String> getSentences() {
        return sentences;
    }

    public String getNewSentence() {
        return newSentence;
    }

    public void setNewSentence(String newSentence) {
        this.newSentence = newSentence;
    }
}
