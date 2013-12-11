package com.example.jayphoto;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener{

	private ArrayList<ListData> listDataArray = new ArrayList<ListData>();
	
	private Button button1;
	private Button button2;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		//맞나???p.91 
		
		Dao dao = new Dao(getApplicationContext());
		
		String testJsonData = dao.getJsonTestData();
		
		dao.insertJsonData(testJsonData);
		
		ListData data1 = new ListData("햄토리", "당근이 주식이다.", "1.png");
		listDataArray.add(data1);
		
		ListData data2 = new ListData("끼토", "책을 본다.", "2.jpg");
		listDataArray.add(data2);
		
		ListData data3 = new ListData("냐옹이", "곰인형을 좋아한다.", "3.jpg");
		listDataArray.add(data3);
		
		ListData data4 = new ListData("멍뭉이", "잘생겼다.", "4.gif");
		listDataArray.add(data4);
		
		ListData data5 = new ListData("강쥐", "놀랐다.", "5.jpg");
		listDataArray.add(data5);
		
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
		
		
		ListView listView = (ListView)findViewById(R.id.custom_list_listView);
		CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_list_row, listDataArray);
		listView.setAdapter(customAdapter);
		
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		Log.i("TEST", position + "번 리스트 선택됨");
		Log.i("TEST", "리스트 내용: " + listDataArray.get(position).getText1());
		
		
	}

	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()) {
		case R.id.button1:
			Intent intentWrite = new Intent(this, Writer.class);
			startActivity(intentWrite);
			break;
		case R.id.button2:
			break;
		}
	}



}
