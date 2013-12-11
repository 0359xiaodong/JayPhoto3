package com.example.jayphoto;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<ListData>{
	
	private Context context;
	private int layoutResourceId;
	private ArrayList<ListData> listData;

	//커스텀아답터는 컨텍스트정보, UI레이아웃Id, 리스트에 표시할 데이터가 필요.
	//UI레이아웃 Id는 리스트의 칸 하나의 레이아웃을 구성하는 것으로 이 예제에선
	//res/layout/custom_list_row.xml(R.layout.custom_list_row)를 사용.
	//커스텀아답터는 이렇게 자신이 직접 레이아웃 만들 수 있다. 
	public CustomAdapter(Context context, int layoutResourceId, ArrayList<ListData> listData) {
		super(context, layoutResourceId, listData);
		this.context= context;
		this.layoutResourceId = layoutResourceId;
		this.listData = listData;
	}
	
	//getView를 오버라이딩해 리스트가 어떻게 보여지게 될지를 정의 
	public View getView(int position, View convertView, ViewGroup parent) {
		//row는 리스트의 각각의 칸이 됨 
		View row = convertView;
		
		if(row==null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			
			row=inflater.inflate(layoutResourceId, parent, false); //UI레이아웃(custom_list_row.xml)을 불러 객체화를 함 
		}
		
		//row.findViewById로 row안의 레이아웃을 설정 
		TextView tvText1 = (TextView)row.findViewById(R.id.custom_row_textView1);
		TextView tvText2 = (TextView)row.findViewById(R.id.custom_row_textView2);
		
		//int position은 리스트의 순서값으로 listData리스트에서 ListData객체를 가져와 get을 이용해 데이터를 가져와 setText해줍니다.
		tvText1.setText(listData.get(position).getText1());
		tvText2.setText(listData.get(position).getText2());
		
		ImageView imageView = (ImageView) row.findViewById(R.id.custom_row_imageView);
		
		//이미지를 읽어와 리스트에 표시해 주는 것. 여기에선 assets폴더에 사진을 집어넣고 가져오는 방법.
		try{
			//이미지파일의 이름 가져오기 
			InputStream is = context.getAssets().open(listData.get(position).getImgName());
			//이미지를 불러와 drawable로 만들긔 
			Drawable d = Drawable.createFromStream(is, null);
			//이미지뷰에 표시
			imageView.setImageDrawable(d);
		} catch(IOException e) {
			Log.e("ERROR", "ERROR:" + e);
		}
		
		return row;
	}

}
