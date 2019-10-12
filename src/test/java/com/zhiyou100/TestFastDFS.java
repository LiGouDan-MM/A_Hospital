package com.zhiyou100;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class TestFastDFS {
	
	/*
	 * 1.依赖 /jar
	 * 2.FastDFS 配置文件
	 * 3.javaapi
	 *      加载配置文件
	 *      创建Tracker客户端
	 *      通过Tracker客户端得到Tracker对象
	 *      通过Tracker
	 */
	@Test
	public void upload() throws IOException, MyException {
		// 加载配置文件
		ClientGlobal.init("E:\\workspace\\A_Hospital\\src\\main\\resources\\fastFDS.properties");
		TrackerClient tc = new TrackerClient();
		TrackerServer connection = tc.getConnection();
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName","5.jpg");// 名字要与上传的一致
		//参数1 文件的地址() 参数2 文件类型 参数3 文件属性对象数组
		String file_id = storageClient1.upload_file1("D:\\图片2\\9.jpg","jpg",list);
		System.out.println("上传成功"+file_id);
		
	}
	
	
	@Test
	public void download() throws IOException, MyException {
		String fid ="group1/M00/00/00/wKiLgF2IcquASvc4AABHMkIpl30902.jpg";
		// 记载配置文件
		ClientGlobal.init("E:\\workspace\\A_Hospital\\src\\main\\resources\\fastFDS.properties");
		TrackerClient tc = new TrackerClient();
		TrackerServer connection = tc.getConnection();
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		byte[] bytes = storageClient1.download_file1(fid);
		OutputStream f= new FileOutputStream("D:\\图片2\\9000.jpg");
		f.write(bytes);
		f.close();
		System.out.println("下载成功");
		
	}
	
	
	@Test
	public void delete() throws IOException, MyException {
		String fid ="group1/M00/00/00/wKiLgF2JgZ6AVLMhAABRICyCb0w909.jpg";
		// 记载配置文件
		ClientGlobal.init("E:\\workspace\\A_Hospital\\src\\main\\resources\\fastFDS.properties");
		TrackerClient tc = new TrackerClient();
		TrackerServer connection = tc.getConnection();
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		storageClient1.delete_file1(fid);
		System.out.println("删除成功");
		
	}

}
