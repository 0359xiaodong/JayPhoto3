package com.example.jayphoto;

public class Article {
	//게시글 하나에 해당하는 정보를 담고있는 클래스 
	int articleNumber;
	String title;
	String writer;
	String id;
	String content;
	String writeDate;
	String imgName;
	
	public Article(int articleNumber, String title, String writer, String id, String content, String writeDate, String imgName) {
		this.articleNumber =  articleNumber;
		this.title = title;
		this.writer = writer;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.imgName = imgName;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public String getImgName() {
		return imgName;
	}

}