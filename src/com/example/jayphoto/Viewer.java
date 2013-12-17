package com.example.jayphoto;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Viewer extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewer);
		
		TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
		TextView tvWriter = (TextView)findViewById(R.id.tvWriter);
		TextView tvContent = (TextView)findViewById(R.id.tvContent);
		TextView tvWriteDate = (TextView)findViewById(R.id.tvWriteDate);
		ImageView ivImage = (ImageView)findViewById(R.id.imageView1);
		
		String articleNumber = getIntent().getExtras().getString("ArticleNumber");
		
		//Dao초기화
		Dao dao = new Dao(getApplicationContext());
		//Dao의 데이터타입이 int여서 String을 int로 변환 
		Article article = dao.getArticleByArticleNumber(Integer.parseInt(articleNumber));
		
		tvTitle.setText(article.getTitle());
		tvWriter.setText(article.getWriter());
		tvContent.setText(article.getContent());
		tvWriteDate.setText(article.getWriteDate());
		
		try {
			//이미지파일의 이름 가져옴
			InputStream ims = getApplicationContext().getAssets().open(article.getImgName());
			//이미지를 불러와 Drawable로 만드고
			Drawable d = Drawable.createFromStream(ims, null);
			//이미지뷰에 표시
			ivImage.setImageDrawable(d);
		} catch(IOException e) {
			Log.e("ERROR", "ERROR:" + e);
		}
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
