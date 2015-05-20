package com.test.mytestproject;

import android.content.Context;
import android.widget.Toast;


public class JniResource {
	
	private Context mContext;
	public JniResource(Context context){
		this.mContext = context;
	}
	{
		System.loadLibrary("jnitest");
	}
	public native String hello();
	public native void showAddToast(int x,int y);
	public native void showDelToast(int x,int y);
	/**
	 * jni调用的java方法
	 */
	public void helloFromJava(){
		Toast.makeText(mContext, "jni call java code!", Toast.LENGTH_SHORT).show();
	}
	/**
	 * jni调用的java方法
	 */
	public void printAddResult(String content){
		Toast.makeText(mContext, "加法计算结果是： ".concat(content), Toast.LENGTH_SHORT).show();
	}
	public void printDelResult(String content){
		Toast.makeText(mContext, "减法计算结果是： ".concat(content), Toast.LENGTH_SHORT).show();
	}
	public String add(int x,int y){
		return String.valueOf(x+y);
	}
	
	public String del(int x,int y){
		return String.valueOf(x-y);
	}
}
