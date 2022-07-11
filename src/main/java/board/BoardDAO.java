package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBConnect;

public class BoardDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public BoardDAO() {
		try {
			con = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> list() {
		//String sql = "select * from test_board";
		String sql = "select * from test_board order by idgroup desc, step asc";
		ArrayList<BoardDTO> li = new ArrayList<BoardDTO>(); //모든내용 저장
		try {
			ps = con.prepareStatement(sql); //전송객체 생성
			rs = ps.executeQuery(); //전송
			while(rs.next()) { //값이 있으면
				li.add( getBoard() ); //rs가 갖고있는 내용을 DTO에 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	
	private BoardDTO getBoard() { //rs가 갖고있는 내용을 DTO에 저장
		BoardDTO dto = new BoardDTO();
		try {
			dto.setId( rs.getInt("id") );
			dto.setName( rs.getString("name"));
			dto.setTitle( rs.getString("title"));
			dto.setContent( rs.getString("content"));
			dto.setSavedate( rs.getTimestamp("savedate"));
			dto.setHit( rs.getInt("hit"));
			dto.setIdgroup( rs.getInt("idgroup"));
			dto.setStep( rs.getInt("step"));
			dto.setIndent( rs.getInt("indent"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void insert(String name, String title, String content) {
		String sql = "insert into test_board(id, name, title, content, idgroup, step, indent) values(test_board_seq.nextval,?,?,?,test_board_seq.currval,0,0)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, content);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void upHit(String id) {
		String sql = "update test_board set hit=hit+1 where id=" + id;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BoardDTO getContent(String id) {
		upHit(id);
		
		String sql = "select * from test_board where id=" + id;
		BoardDTO dto = new BoardDTO();
		try {
			ps = con.prepareStatement(sql); //실행 객체
			rs = ps.executeQuery(); //명령어 실행
			if(rs.next()) {
				return getBoard(); //메소드 호출 //모든값이 셋팅된 dto값을 돌려줌
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //해당 값이 없으면 null값을 돌려줌
	}
	
	public void update(BoardDTO dto) {
		String sql = "update test_board set name=?, title=?, content=? where id=?";
		try {
			ps = con.prepareStatement(sql);   
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setInt(4, dto.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		String sql = "delete from test_board where id = " + id;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void replyShap(BoardDTO dto) {
		String sql = "update test_board set step = step + 1 where idgroup = ? and step > ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getIdgroup());
			ps.setInt(2, dto.getStep());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reply(BoardDTO dto) {
		replyShap(dto);
		
		String sql = "insert into test_board(id, name, title, content, idgroup, step, indent) values(test_board_seq.nextval,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			
			ps.setInt(4, dto.getIdgroup());
			ps.setInt(5, dto.getStep() + 1);
			ps.setInt(6, dto.getIndent() + 1);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
