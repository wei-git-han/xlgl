//package com.css.app.xlgl.util;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import javax.imageio.ImageIO;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
////import org.bytedeco.javacv.FFmpegFrameGrabber;
//import org.bytedeco.javacv.Frame;
//import org.bytedeco.javacv.FrameGrabber.Exception;
//
//import org.bytedeco.javacv.FFmpegFrameGrabber;
//import org.bytedeco.javacv.Java2DFrameConverter;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
///*import org.bytedeco.javacv.Java2DFrameConverter;*/
//
//import com.css.addbase.FileBaseUtil;
//
//import cn.com.css.filestore.impl.HTTPFile;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//public class CutOutVideoUtil {
//
//	public static String getPictureFileid(String videoFileId,String url) {
//		HTTPFile httpFile = new HTTPFile(videoFileId);
//		String fileName = httpFile.getFileName();
//		String videoURL =url+"/"+fileName;
//		InputStream is = httpFile.getInputSteam();
//		File file = new File(videoURL);
//		try {
//			FileOutputStream out = new FileOutputStream(file);
//			byte[] b = new byte[1024];
//			try {
//				while ((is.read(b)) != -1) {
//					out.write(b);
//				}
//				is.close();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String substring = fileName.substring(0, fileName.indexOf("."));
//		String pictureFileURL = url+"/"+substring+".png";
//		generateVideoImg(videoURL,pictureFileURL);
//		File pictureFile = new File(pictureFileURL);
//		DiskFileItemFactory factory = new DiskFileItemFactory(16, null);
//		FileItem item = factory.createItem(pictureFile.getName(), "text/plain", true, pictureFile.getName());
//		MultipartFile multipartFile = new CommonsMultipartFile(item);
//		String fileId = FileBaseUtil.fileServiceUpload(multipartFile);
//		return fileId;
//	}
//
//
//	/**
//	 *@param videoFilePath 视频路径
//	 *@param pictureFilePath 截取图片路径
//	 * */
//	public static void generateVideoImg(String videoFilePath,String pictureFilePath) {
//		File file = new File(pictureFilePath);
//		FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videoFilePath);
//		try {
//			ff.start();
//			int length = ff.getLengthInAudioFrames();
//			int i = 0;
//			Frame f = null;
//			while(i < length) {
//				f= ff.grabImage();
//				if((i > 5) && (f.image !=null)) {
//					break;
//				}
//				i++;
//			}
//			BufferedImage bi = toImage(f);
//			ImageIO.write(bi, "png",file );
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				ff.close();
//				ff.stop();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//
//	private static BufferedImage toImage(Frame frame) {
//		Java2DFrameConverter converter = new Java2DFrameConverter();
//		BufferedImage bufferedImage = converter.getBufferedImage(frame);
//		if(bufferedImage.getWidth() > bufferedImage.getHeight()) {
//			return rotate(bufferedImage);
//		}
//		return bufferedImage;
//	}
//
//public static BufferedImage rotate(BufferedImage img) {
//		BufferedImage bufferedImage = new BufferedImage(img.getHeight(), img.getWidth(), BufferedImage.TYPE_4BYTE_ABGR);
//		for (int i = 0; i < img.getWidth(); i++) {
//			for (int j = 0; j < img.getHeight(); j++) {
//				int rgb = img.getRGB(i, j);
//				bufferedImage.setRGB(img.getHeight()-j-1, i, rgb);
//			}
//		}
//		return bufferedImage;
//	}
//}
