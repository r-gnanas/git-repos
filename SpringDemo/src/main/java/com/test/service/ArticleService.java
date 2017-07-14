package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ArticleDAOInterface;
import com.test.entity.Article;

@Service
public class ArticleService implements ArticleServiceInterface {

	@Autowired
	ArticleDAOInterface articleDAO;
	
	@Override
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@Override
	public Article getArticleById(int articleId) {
		return articleDAO.getArticleById(articleId);
	}

	@Override
	public boolean addArticle(Article article) {
		if(articleDAO.isArticleExist(article.getTitle(), article.getCategory())){
			return false;
		}
		else{
			articleDAO.addArticle(article);
			return true;
		}
		
	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}

}
