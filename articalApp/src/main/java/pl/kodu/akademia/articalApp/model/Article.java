package pl.kodu.akademia.articalApp.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Articles")

public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int articles;

    @NotBlank
    private String title;

    @NotBlank
    private String category;


    public int getArticles() {
        return articles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
