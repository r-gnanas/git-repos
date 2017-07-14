package com.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Article;

@Transactional
@Repository
public class ArticleDAO implements ArticleDAOInterface {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql="FROM Article as a ORDER BY a.articleId";
		return (List<Article>)entityManager.createQuery(hql).getResultList();
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
		Article article1=getArticleById(article.getArticleId());
		article1.setTitle(article.getTitle());
		article1.setCategory(article.getCategory());
		entityManager.flush();
	}

	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	@Override
	public boolean isArticleExist(String title, String category) {
		String hql="FROM Article as a WHERE a.title=? AND a.category=?";
		int count=entityManager.createQuery(hql).setParameter(1,title).setParameter(2, category).getResultList().size();
		
		return count > 0 ? true : false;
	}

}
