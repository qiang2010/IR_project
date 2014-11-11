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
 *  ��ȡһ��html�ļ�����ȡ��Ӧ��Ϣ������HtmlInforDetail�Ķ�����
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
	// ��ȡһ��html�е���Ϣ
	public HtmlInforDetail getAllInfo(String content) {
		HtmlInforDetail htmlDetail = new HtmlInforDetail(0); 
		document =Jsoup.parse(content);
		htmlDetail.title = document.title();		// title 
		Elements links = document.getElementsByTag("link");
//		System.out.println(links.size());
//		for(Element link: links){
//			System.out.println(link.attr("href"));
//		}
		htmlDetail.url   = links.get(0).attr("href");	//url html���������ӵĵ�һ��Ӧ���Ǳ���ҳ�Լ�������
		Elements metas = document.getElementsByTag("meta");  // Ԫ����
		htmlDetail.description = metas.get(2).attr("content");  // Ԫ�����е�����
		htmlDetail.keywords =    metas.get(1).attr("content");   // Ԫ�����е�keywords
			
		//  ����������idΪcontextText��div�У������Ȼ�ȡ��div�ڻ�ȡdiv�е�p
		Element contentText = document.getElementById("contentText");	
	    Elements ps = contentText.getElementsByTag("p");
	    htmlDetail.body = "";  //  body
		for(Element p:ps){
			htmlDetail.body+= p.text().trim(); // ȥ�������հ��ַ�
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
	// ��ȡһ��html�ļ�
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
