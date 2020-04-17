package edu.ycp.cs320.comm.model;

import java.awt.Image;
import java.io.File;
import java.util.List;

public class Content 
{
	private Image StaticImg;
	private List<Image> SlideShowImages;
	private File VideoFile;
	
	public Content()
	{
		
	}
	
	public Image getStaticImage()
	{
		return StaticImg;
	}
	
	public List<Image> getSlideShowImages()
	{
		return SlideShowImages;
	}
	
	public File getVideoFile()
	{
		return VideoFile; 
	}
	
	public void setStaticImage(Image img)
	{
		StaticImg = img;
	}
	
	public void setSlideShowImgs(List<Image> imgs)
	{
		SlideShowImages = imgs;
	}
	
	public void setVideoFile(File Video)
	{
		VideoFile=Video;
	}

}
