package com.example.anyang.partymassworklistview.okhttp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
/**
 * OkHttp网络通信框架
 * @author anyang
 *
 */
public class OkHttpUtils {
	// 调试标签
	public static final String TAG = "OkHttpUtils";
	// 单例模式
	private static OkHttpUtils mInstance;
	// OkHttpClient变量声明
	private static OkHttpClient okHttpClient = null;
	// 服务器端URL
	public static final String BASE_URL="http://10.50.63.95:8080/SensorDataServer/";

	private OkHttpUtils()
	{
		// 创建okHttpClient对象
		okHttpClient = new OkHttpClient();
	}

	public static OkHttpUtils getInstance()
	{
		if (mInstance == null)
		{
			synchronized (OkHttpUtils.class)
			{
				if (mInstance == null)
				{
					mInstance = new OkHttpUtils();
				}
			}
		}
		return mInstance;
	}

	// Http Get请求
	public String okHttpForGet(String url){
		// 返回值字符串
		String responseStr = "";
		// 创建一个Request
		final Request request = new Request.Builder()
				.url(url)
				.build();
		// new call
		Call call = okHttpClient.newCall(request);
		// 执行请求：阻塞方式，同样地也存在异步方式：call.enqueue(new Callback())
		Response response;
		try {
			response = call.execute();
			// 解析响应实体
			if(response.isSuccessful()){
				// 请求成功
				responseStr = response.body().string();
				/**
				 * 此时执行线程并非UI线程，因此操作控件类的行为需要注意
				 *  runOnUiThread(new Runnable()
				 {
				 @Override
				 public void run()
				 {
				 mTv.setText(res);
				 }
				 });
				 */
			}else{
				// 请求失败
				responseStr = "OkHttpUtils:okHttpForGet:Unexpected code------>" + response.toString();
				Log.d("okHttpForGet:", "------>" + response.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回响应内容
		return responseStr;
	}

	// Http Post请求
	public String okHttpForPost(String url, HashMap<String, String> parameters){
		// 返回值字符串
		String responseStr = "";
		// 参数构造器
		FormEncodingBuilder builder = new FormEncodingBuilder();
		// 遍历HashMap,读取参数
		for (Entry<String, String> entry : parameters.entrySet()) {
			// 填充参数
			builder.add(entry.getKey().toString(), entry.getValue().toString());
			Log.d(TAG, entry.getValue().toString());
		}
		// 创建一个Request
		Request request = new Request.Builder()
				.url(url)
				.post(builder.build())
				.build();
		// new call
		Call call = okHttpClient.newCall(request);
		// 执行请求：阻塞方式，同样地也存在异步方式：call.enqueue(new Callback())
		Response response;
		try {
			response = call.execute();
			// 解析响应实体
			if(response.isSuccessful()){
				// 请求成功
				responseStr = response.body().string();
				/**
				 * 此时执行线程并非UI线程，因此操作控件类的行为需要注意
				 *  runOnUiThread(new Runnable()
				 {
				 @Override
				 public void run()
				 {
				 mTv.setText(res);
				 }
				 });
				 */
			}else{
				// 请求失败
				responseStr = "OkHttpUtils:okHttpForPost:Unexpected code------>" + response.toString();
				Log.d("okHttpForPost:", "------>" + response.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回响应内容
		return responseStr;
	}

	// 基于Http的文件上传
	public String okHttpForFile(String url, File file){
		// 返回值字符串
		String responseStr = "";
		// 	构建请求实体
		RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
		RequestBody requestBody = new MultipartBuilder()
				.type(MultipartBuilder.FORM)
				.addPart(Headers.of(
						"Content-Disposition", "form-data; name=\"mFile\"; filename =\"file.mp4\""), fileBody)
				.build();
		// 创建一个Request
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		// new call
		Call call = okHttpClient.newCall(request);
		// 执行请求：阻塞方式，同样地也存在异步方式：call.enqueue(new Callback())
		Response response;
		try {
			response = call.execute();
			// 解析响应实体
			if(response.isSuccessful()){
				// 请求成功
				responseStr = response.body().string();
				/**
				 * 此时执行线程并非UI线程，因此操作控件类的行为需要注意
				 *  runOnUiThread(new Runnable()
				 {
				 @Override
				 public void run()
				 {
				 mTv.setText(res);
				 }
				 });
				 */
			}else{
				// 请求失败
				responseStr = "OkHttpUtils:okHttpForFile:Unexpected code------>" + response.toString();
				Log.d("okHttpForFile:", "------>" + response.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回响应内容
		return responseStr;
	}

}
