import java.util.ArrayList;
import java.util.LinkedList;

/*
 *  我们已经获得了(词项 文档ID对) 列表
 *  假设存在文件中，本程序是读取文件中的列表，然后构建索引
 *  最后将构建的索引写入到文件中去。
 *  
 *  同时 还有readIndexIntoMemo() 函数将磁盘中的倒排索引读入文件中
 *   以及     writeIndexToDisk()   函数将内存中的倒排索写入磁盘中
 */
 class Node{
	int docId;  
	int tf;
}
 class Term{
	 String term;
	 int df;
	 LinkedList<Node> termIndex;
	 Term(){
		 term = "";
		 df = 0;
		 termIndex = new LinkedList<Node>();
	 }
 }
public class BuildIndex {

	// 存放整个倒排索引
	ArrayList<Term> invertedIndex = new ArrayList<Term>();
	
	String  term_docId_list_fileName = "D:\\git\\IR_project\\term_docId_list.txt";
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void getTerm_docId(){
		
	}
	
	/*
	 * 传入的参数就是 存放 词项文档id对的文件
	 *  一边读取文件一边构建索引
	 *  效率： 从文件中读取一行，是遍历一遍已有的倒排表
	 */
    public void buildIndex(String fileName){
    	
    }
    public void readIndexIntoMemo(){
    	
    }
    public  void writeIndexToDisk(){
    	
    }
}
