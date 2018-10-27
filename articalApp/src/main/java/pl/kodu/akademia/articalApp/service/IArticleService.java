package pl.kodu.akademia.articalApp.service;

import pl.kodu.akademia.articalApp.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    boolean addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticleById(int articleId);

}
