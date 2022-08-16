package com.gmail.at.kotamadeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoAboutCats {
    private String id;
    private String text;
    private String type;
    private String user;
    private int upvotes;

    @Override
    public String toString() {
        return String.format("%s - %s, %d%n%s %s.", id, user, upvotes, text, type);
    }
}
