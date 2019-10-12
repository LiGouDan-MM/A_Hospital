package util;

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
import org.springframework.web.multipart.MultipartFile;

public class TestFastDFS {
	private static int i = 1;
	public static String upload(MultipartFile img) throws IOException, MyException {
		// 获得文件名
		String fileName =img.getOriginalFilename();
		// 获得后缀
		String[] split = fileName.split("\\.");
		String suffix = split[1];
		// 加载配置文件
		// 绝对路径
		ClientGlobal.init("E:\\workspace\\A_Hospital\\src\\main\\resources\\fastFDS.properties");
        // 创建Tracker客户端
		TrackerClient tc = new TrackerClient();
        // 通过Tracker客户端得到Tracker对象
		TrackerServer connection = tc.getConnection();
        // 通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
        // 创建文件属性存储对象
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName",fileName);// 名字要与上传的一致
        // 通过客户端执行上传
		//参数1 文件的地址() 参数2 文件类型 参数3 文件属性对象数组
		String file_id= storageClient1.upload_file1(img.getBytes(),suffix,list);
		System.out.println("上传成功"+file_id);
		String path="http://ligoudan/"+file_id;
		return path;
	}
	/*
	 * 下载文件
	 */
	public static void download(String file_id,String suffx) throws IOException, MyException {
		//String file_id ="group1/M00/00/00/wKiLgF2IcquASvc4AABHMkIpl30902.jpg";
		// 记载配置文件
		ClientGlobal.init("E:\\workspace\\A_Hospital\\src\\main\\resources\\fastFDS.properties");
		TrackerClient tc = new TrackerClient();
		TrackerServer connection = tc.getConnection();
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		byte[] bytes = storageClient1.download_file1(file_id);
		OutputStream f= new FileOutputStream("D:\\图片\\"+i+"."+suffx);
		i++;
		f.write(bytes);
		f.close();
		System.out.println("下载成功");
		
	}
	
	
	/*
	 * 删除文件
	 */
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
