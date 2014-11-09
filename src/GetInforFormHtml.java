import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 *  读取一个html文件，抽取相应信息，放在HtmlInforDetail的对象中
 * 
 */
public class GetInforFormHtml {

	File file;
	//FileReader fileReader ;
	BufferedReader bufferedReader;
	
	Document document;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "D:\\git\\IR_project\\1.htm";
		GetInforFormHtml getInforFormHtml = new GetInforFormHtml();
		getInforFormHtml.getAllInfo(getInforFormHtml.getHtmlFileContent(fileName));
	
	}
	public HtmlInforDetail getAllInfo(String content){
		HtmlInforDetail htmlDetail = new HtmlInforDetail();
		document =Jsoup.parse(content);
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
