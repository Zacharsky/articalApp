package pl.kodu.akademia.articalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kodu.akademia.articalApp.dao.IArticleDAO;
import pl.kodu.akademia.articalApp.model.Article;

import java.util.List;

public class articlaService implements IArticleService {

    @Autowired
    private IArticleDAO iArticleDAO;


    @Override
    public List<Article> getAllArticles() {
        return iArticleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return iArticleDAO.getArticleById(articleId);
    }

    @Override
    public boolean  addArticle(Article article) {

        if (iArticleDAO.articleExist(article.getTitle(), article.getCategory())) {
            return false;
        }else {
            iArticleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticle(Article article) {
        iArticleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticleById(int articleId) {
        iArticleDAO.deleteArticleById(articleId);
    }
}
