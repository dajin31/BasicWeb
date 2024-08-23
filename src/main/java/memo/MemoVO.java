package memo;

import java.sql.Date;
import java.time.LocalDate;

public class MemoVO {
	private int mNo;
	private String title;
	private String content;
	private String writer;
	private LocalDate registerDate;
	private LocalDate modifiedDate;
	public MemoVO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public MemoVO(int mNo, String title, String content, String writer) {
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public MemoVO(int mNo, String title, String content, String writer, LocalDate registerDate,
			LocalDate modifiedDate) {
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "MemoVO [mNo=" + mNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", registerDate=" + registerDate + ", modifiedDate=" + modifiedDate + "]";
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
