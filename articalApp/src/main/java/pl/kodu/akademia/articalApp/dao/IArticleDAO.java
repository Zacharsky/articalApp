package pl.kodu.akademia.articalApp.dao;

import pl.kodu.akademia.articalApp.model.Article;

import java.util.List;

public interface IArticleDAO {

    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticleById(int articleId);

    boolean articleExist(String title, String category);


}
