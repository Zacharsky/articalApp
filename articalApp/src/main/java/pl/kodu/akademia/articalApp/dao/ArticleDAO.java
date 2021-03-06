package pl.kodu.akademia.articalApp.dao;

import org.springframework.stereotype.Repository;
import pl.kodu.akademia.articalApp.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticles() {
        String hql ="FROM Article as act1 ORDER BY atc1.articleId";

        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article artc1 = getArticleById(article.getArticleId());
        artc1.setTitle(article.getTitle());
        artc1.setCategory(article.getCategory());
    }

    @Override
    public void deleteArticleById(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    @Override
    public boolean articleExist(String title, String category) {
        String hql = "From Article as act1 WHERE act1.title = ? and act1.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1,title)
                .setParameter(2,category).getResultList().size();

        //
        return count > 0 ? true : false;

    }
}
