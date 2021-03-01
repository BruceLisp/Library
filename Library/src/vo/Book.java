package vo;

public class Book{
	String Bid;
	String Bname;
	String Bindate;
	String BBorrowedDate;
	String BDeadLineDate;
	String BProducter;
	int IsBorrowed;
	float Price;
	String BusersId;
	String BAuthor;
	
	public String getBAuthor() {
		return BAuthor;
	}

	public void setBAuthor(String bAuthor) {
		BAuthor = bAuthor;
	}

	public Book(String Bid,String Bname,String BProducter,
			int IsBorrowed,String BAuthor){
		this.Bid = Bid;
		this.Bname = Bname;
		this.BProducter = BProducter;
		this.IsBorrowed = IsBorrowed;
		this.BAuthor = BAuthor;
	}
	
	public Book(String Bid,String Bname,String BProducter,
			int IsBorrowed,String BAuthor,String BBorrowedDate,String BDeadLineDate){
		this.Bid = Bid;
		this.Bname = Bname;
		this.BProducter = BProducter;
		this.IsBorrowed = IsBorrowed;
		this.BAuthor = BAuthor;
		this.BBorrowedDate = BBorrowedDate;
		this.BDeadLineDate = BDeadLineDate;
	}
	
	public String getBBorrowedDate() {
		return BBorrowedDate;
	}

	public void setBBorrowedDate(String bBorrowedDate) {
		BBorrowedDate = bBorrowedDate;
	}

	public String getBDeadLineDate() {
		return BDeadLineDate;
	}

	public void setBDeadLineDate(String bDeadLineDate) {
		BDeadLineDate = bDeadLineDate;
	}

	public String getBid() {
		return Bid;
	}
	public void setBid(String bid) {
		Bid = bid;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBindate() {
		return Bindate;
	}
	public void setBindate(String bindate) {
		Bindate = bindate;
	}
	public String getBProducter() {
		return BProducter;
	}
	public void setBProducter(String bProducter) {
		BProducter = bProducter;
	}
	public int getIsBorrowed() {
		return IsBorrowed;
	}
	public void setIsBorrowed(int isBorrowed) {
		IsBorrowed = isBorrowed;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float Price) {
		this.Price = Price;
	}
	public String getBusersId() {
		return BusersId;
	}
	public void setBusersId(String busersId) {
		BusersId = busersId;
	}
	
	
	
}
