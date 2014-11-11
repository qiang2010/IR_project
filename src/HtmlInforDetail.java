
public class HtmlInforDetail {
	int id; 
	String title;  		// 标题
	long   timeStamp; 	// 发布时间
	int    comments;    // 评论数目
	int    jointPeople; //参与人数
	String body;      	// 新闻内容主题
	String body_40Words;
	String description; // 元数据中的
	String keywords;    // 元数据中的
	String url;      	// 当前网页的URL
	
	public HtmlInforDetail(int id){
		this.id = id;  //  初始化必须至少指定id
	}
	
	// write all attribute into database
	// arguments : information to connect database
	public void writeToDataBase(){
		
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getJointPeople() {
		return jointPeople;
	}
	public void setJointPeople(int jointPeople) {
		this.jointPeople = jointPeople;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getBody_40Words() {
		return body_40Words;
	}
	public void setBody_40Words(String body_40Words) {
		this.body_40Words = body_40Words;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HtmlInforDetail(int id, String title, long timeStamp, int comments,
			int jointPeople, String body, String body_40Words, String url) {
		super();
		this.id = id;
		this.title = title;
		this.timeStamp = timeStamp;
		this.comments = comments;
		this.jointPeople = jointPeople;
		this.body = body;
		this.body_40Words = body_40Words;
		this.url = url;
	}
	@Override
	public String toString() {
		return "HtmlInforDetail [id=" + id + ", title=" + title
				+ ", timeStamp=" + timeStamp + ", comments=" + comments
				+ ", jointPeople=" + jointPeople + ", body=" + body
				+ ", body_40Words=" + body_40Words + ", description="
				+ description + ", keywords=" + keywords + ", url=" + url + "]";
	}

	
}
