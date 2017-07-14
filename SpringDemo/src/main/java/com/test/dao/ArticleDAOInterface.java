package com.test.dao;

import java.util.List;

import com.test.entity.Article;

public interface ArticleDAOInterface {

	List<Article> getAllArticles();
	Article getArticleById(int articleId);
	void addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(int articleId);
	boolean isArticleExist(String title,String category);
	
}
