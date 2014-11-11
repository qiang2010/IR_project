import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *  读取一个html文件，抽取相应信息，放在HtmlInforDetail的对象中
 *  sohu sports
 */
public class GetInforFormHtml {

	File file;
	//FileReader fileReader ;
	BufferedReader bufferedReader;	
	Document document;
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String fileName = "D:\\git\\IR_project\\1.htm";
		fileName = "D:\\git\\IR_Data\\sports.sohu.com\\20141110\\n405912634.shtml";
		GetInforFormHtml getInforFormHtml = new GetInforFormHtml();
		HtmlInforDetail  detail = getInforFormHtml.getAllInfo(getInforFormHtml.getHtmlFileContent(fileName));
		System.out.println(detail.toString());
	}
	Date data;
	// 获取一个html中的信息
	public HtmlInforDetail getAllInfo(String content) {
		HtmlInforDetail htmlDetail = new HtmlInforDetail(0); 
		document =Jsoup.parse(content);
		htmlDetail.title = document.title();		// title 
		Elements links = document.getElementsByTag("link");
//		System.out.println(links.size());
//		for(Element link: links){
//			System.out.println(link.attr("href"));
//		}
		htmlDetail.url   = links.get(0).attr("href");	//url html中所有连接的第一个应该是本网页自己的链接
		Elements metas = document.getElementsByTag("meta");  // 元数据
		htmlDetail.description = metas.get(2).attr("content");  // 元数据中的描述
		htmlDetail.keywords =    metas.get(1).attr("content");   // 元数据中的keywords
			
		//  新闻正文在id为contextText的div中，所以先获取该div在获取div中的p
		Element contentText = document.getElementById("contentText");	
	    Elements ps = contentText.getElementsByTag("p");
	    htmlDetail.body = "";  //  body
		for(Element p:ps){
			htmlDetail.body+= p.text().trim(); // 去除其他空白字符
	    }
		
		// time 
		Element time = document.getElementById("pubtime_baidu");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(time.text());
		try {
			data = simpleTimeFormat.parse(time.text());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    htmlDetail.timeStamp = data.getTime();  // unix timestamp
		//Data d = new DataTime(time.attr("content"));
		System.out.println(document.title());
		return htmlDetail;
	}
	// 读取一个html文件
	public String getHtmlFileContent(String name){
		StringBuilder content= new StringBuilder();
		String line;
		try {
			file = new File(name);
			bufferedReader = new BufferedReader(new FileReader(file));
			while(true){
				line =bufferedReader.readLine();
				if(line == null ) break;
				content.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// TODO: handle exception
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}	
		return content.toString();
	}

}
