import java.util.ArrayList;
import java.util.LinkedList;

/*
 *  �����Ѿ������(���� �ĵ�ID��) �б�
 *  ��������ļ��У��������Ƕ�ȡ�ļ��е��б�Ȼ�󹹽�����
 *  ��󽫹���������д�뵽�ļ���ȥ��
 *  
 *  ͬʱ ����readIndexIntoMemo() �����������еĵ������������ļ���
 *   �Լ�     writeIndexToDisk()   �������ڴ��еĵ�����д�������
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

	// ���������������
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
	 * ����Ĳ������� ��� �����ĵ�id�Ե��ļ�
	 *  һ�߶�ȡ�ļ�һ�߹�������
	 *  Ч�ʣ� ���ļ��ж�ȡһ�У��Ǳ���һ�����еĵ��ű�
	 */
    public void buildIndex(String fileName){
    	
    }
    public void readIndexIntoMemo(){
    	
    }
    public  void writeIndexToDisk(){
    	
    }
}
