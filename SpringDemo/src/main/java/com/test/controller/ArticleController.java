package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Article;
import com.test.service.ArticleServiceInterface;


@RestController
//@RequestMapping(value="/demo")
public class ArticleController {

	@Autowired
	ArticleServiceInterface articleService;
	
	@RequestMapping(value="articles", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Article>> getAllArticles(){
		List<Article> articlesList=articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(articlesList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="article/{id}",method=RequestMethod.GET)
	public ResponseEntity<Article> getArticleById(@PathVariable("id") int articleId){
		Article article=articleService.getArticleById(articleId);
		
		return new ResponseEntity<Article>(article,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="article",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addArticle(@RequestBody Article article){
		
		boolean flag=articleService.addArticle(article);
		if(flag){
			return new ResponseEntity<String>(HttpStatus.CREATED).ok("Created");
		}
		else{
			return new ResponseEntity<String>(HttpStatus.CONFLICT).ok("Conflict");
		}
	}
	
	@RequestMapping(value="article",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Article> updateArticle(@RequestBody Article article){
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="article/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") int articleId){
		
		articleService.deleteArticle(articleId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
