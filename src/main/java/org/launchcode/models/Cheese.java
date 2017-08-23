package org.launchcode.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * Created by LaunchCode
 */
public class Cheese {

    @NotNull
    @Size(min=3, max=15, message = "Cheese name must be between 3-15 characters.")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private CheeseType type;
    private int cheeseId;
    private static int nextId = 1;

    @Range(min=1, max=5, message = "Rating must be between 1-5 stars.")
    private int rating;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() { return cheeseId; }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() { return rating; }

    public void setRating(int rating) { this.rating = rating; }
}
