package com.lumingfeng.spat.douban;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	int all=0;
    	System.out.println("start...");
    	long starttime =System.currentTimeMillis();
    	while(all<10000){
    		String url="https://www.douban.com/group/beijingzufang/discussion?start=";
    		url+=all;
    		Document doc = Jsoup.connect(url)
    				.header("Accept", "*/*")
    				.header("Accept-Encoding", "gzip, deflate")
    				.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
    				.header("Referer", "https://www.baidu.com/")
    				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
    				.timeout(5000)
    				.get();
	//    	System.out.println(doc.toString());
//	    	Elements divs = doc.select("td.title");
	    	Elements divs = doc.select("tr");
	    	for (Element element : divs) {
	    		if(element.childNodes().size()>0 && element.child(0).hasAttr("class") &&element.child(1).hasAttr("nowrap")){
//	    			element.child(0).getElementsByClass("title")
	    			Element firstElement =element.child(0);
	    			Element secondElement =element.child(1);
	    			Element thirdElement =element.child(2);
	    			Element forthElement =element.child(3);
	    			
	    			String title=firstElement.child(0).attr("title");
	    			String people=secondElement.child(0).html();
	    			String idString =secondElement.child(0).attr("href");
	    			String[] sps=idString.split("/");
	    			String answer=thirdElement.html();
	    			String time =forthElement.html();
	    			System.out.println(title+","+people+","+answer+","+time+","+sps[sps.length-1]);
//	    			System.out.println(element.toString());
	    		}
//	    		element.
	    	}
	    	all+=25;
	    	System.out.println(url);
    	}
    	System.out.println(System.currentTimeMillis()-starttime);
    	System.out.println(all);
    }
}
