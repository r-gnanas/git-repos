package com.test.service;

import java.util.List;

import com.test.entity.Article;

public interface ArticleServiceInterface {

	List<Article> getAllArticles();
	Article getArticleById(int articleId);
	boolean addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(int articleId);
}
