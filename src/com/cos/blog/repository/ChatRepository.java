package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.dto.ChatResponseDto;
import com.cos.blog.dto.ReplyResponseDto;
import com.cos.blog.model.Chat;
import com.cos.blog.model.Reply;

public class ChatRepository {
	private static final String TAG = "ChatRepository : ";
	private static ChatRepository instance = new ChatRepository();
	private ChatRepository() {}
	public static ChatRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int save(Chat chat) {
		final String SQL = "INSERT INTO chat(id, pid, userid, content,createdate) VALUES(chat_seq.nextval, ?, ?, ?,sysdate)";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, chat.getPid());
			pstmt.setInt(2, chat.getUserid());
			pstmt.setString(3, chat.getContent());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public List<ChatResponseDto> findAll(int pid) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT c.id, c.userid, c.pid, c.content,c.createdate, ");
		sb.append("u.username, u.userProfile ");
		sb.append("FROM chat c INNER JOIN users u ");
		sb.append("ON c.userid = u.id ");
		sb.append("WHERE pid = ? ");
		final String SQL = sb.toString();
		List<ChatResponseDto> chatDtos = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Chat chat = Chat.builder()
						.id(rs.getInt(1))
						.userid(rs.getInt(2))
						.pid(rs.getInt(3))
						.content(rs.getString(4))	
						.createDate(rs.getTimestamp(5))
						.build();
				ChatResponseDto chatDto = ChatResponseDto.builder()
						.chat(chat)
						.username(rs.getString(6))
						.userProfile(rs.getString(7))
						.build();
				chatDtos.add(chatDto);
			}
			
			return chatDtos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll(chatid) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
}
