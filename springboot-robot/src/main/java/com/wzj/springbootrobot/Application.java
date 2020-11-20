package com.wzj.springbootrobot;

import com.wzj.springbootrobot.util.DownloadImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
@SpringBootApplication
public class Application implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public void process(Page page) {
// 一页是24张图片
		for (int i = 1; i <= 24; i++) {

			// 使用Xpath解析，获取到单个图片的网页
			// WebMagic支持使用Xpath、CSS选择器、正则表达式、JsonPath来解析页面
			String str = page.getHtml().xpath("//div[@id=thumbs]/section/ul/li[" + i + "]/figure/a[@class=preview]/@href").toString();

			// 获取到的连接为null则退出循环，不添加进爬取目标
			if (str == null){
				break;
			}

			// 将爬取到的链接添加到待爬取页面中
			page.addTargetRequest(str);
		}

		// 将页面中图片的地址提取出来，以便于使用工具类保存
		String pageURL = page.getHtml().xpath("//img[@id=wallpaper]/@src").toString();

		if (pageURL != null) {
			try {
				// 获取图片的名字和后缀提取出来用于保存
				String name = pageURL.substring(pageURL.length() - 9, pageURL.length() - 4);
				String suffix = pageURL.substring(pageURL.length() - 4);
				log.info(name+suffix);
				// 将图片的地址、名字、保存路径传入文件工具类进行下载
				DownloadImage.downLoadFromUrl(pageURL, name + suffix, "C:\\Users\\Super Hero\\Downloads");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Site getSite() {
		return site;
	}
	public static void main(String[] args) {
		Spider.create(new GithubRepoPageProcessor())
				// 添加初始化的URL
				.addUrl("https://wallhaven.cc/toplist?page=1")
				// 使用单线程
				.thread(1)
				// 运行
				.run();
	}
}
