package board;

import java.sql.Timestamp;

public class BoardDTO {
	private int id; //게시글번호
	private String name; //이름
 	private String title; //제목
	private String content; //내용
	private Timestamp savedate; //날짜
	private int hit; //조회수
	private int idgroup; //작성한 원글에 대한 번호 - 글과 답글을 같은위치에 정렬하기 위해 사용
	private int step; //답글들 끼리에 대한 위치 순번 지정
	private int indent; //댓글 들여쓰기

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Timestamp getSavedate() {
		return savedate;
	}
	public void setSavedate(Timestamp savedate) {
		this.savedate = savedate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}

}
