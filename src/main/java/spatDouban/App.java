package spatDouban;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
//    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
//
//    String href="https://www.douban.com/group/beijingzufang/discussion?start=0";
//    URL urls = new URL(href);  
//
//    HttpsURLConnection urlcon = (HttpsURLConnection)urls.openConnection(proxy);  
//
//    urlcon.connect();         //获取连接  
//
//    InputStream is = urlcon.getInputStream();  
//
//    BufferedReader buffer = new BufferedReader(new InputStreamReader(is));  
//
//    StringBuffer bs = new StringBuffer();  
//
//    String l = null;  
//
//    while((l=buffer.readLine())!=null){  
//
//    bs.append(l);  
//
//    }  
//
//    System.out.println(bs.toString());  
//
//    Document doc = Jsoup.parse(bs.toString());


    
    
    //    	System.setProperty("http.maxRedirects", "50");
//    	System.getProperties().setProperty("proxySet", "true");
    	// 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
//    	String ip = "49.65.228.173";
    	
    	String ip = "111.123.148.112";
    	int port =40978;
//    	System.getProperties().setProperty("http.proxyHost", ip);
//    	System.getProperties().setProperty("http.proxyPort", port+"");
    	System.setProperty("https.proxyHost", ip);  
    	System.setProperty("https.proxyPort", "" + port);  
    	
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
	    	}
	    	all+=25;
//	    	System.out.println(url);
    	}
    	System.out.println(System.currentTimeMillis()-starttime);
//    	System.out.println(all);
    }
}
