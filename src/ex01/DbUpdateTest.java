package ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DbUpdateTest {

	public static void main(String[] args) {
		
		String sql = "update monsters set level_no = ? where id = ?";
		
		
		// 워크벤치의 Test_Connection과 같은 기능 만들기
		try(
				Connection connection = DbConfig.getConnection();
				PreparedStatement statement =
						connection.prepareStatement(sql);

				){ //mysql 시도 후 성공할때
			//DbConfig.getConnection() : mysql 서버에 연결시도
			//성공하면 Connection 객체를 돌려줌
			//Connection connection = DbConfig.getConnection();
			//mysql 서버에 접속항 sql 질의 결과 얻기
			//1. PreparedStatement 객체 필요 : mysql서버에다가 sql문자열 배달합니다.
			//그 결과로 레코드들을 얻습니다.
			//PreparedStatement statement =
					connection.prepareStatement(sql);
			//명령을 보냈으므로 mysql에서 결과를 자바에 보내라는 응답 규칙생김
			//executeQuery() : 서버에서 SQL 실행하세요라고 요청
			//ResultSet resultSet = statement.executeQuery(); //워크벤체에서 ctrl + enterface
			// mysql서버가 보내준 레코들을 하나씩 가져와야함 : ResultSet.next
			//마지막 레코드를 가져오면 eof == 0이라는 결과 반환
			//mysql 서버로 넘겨줄 조건값을 설정
		    // 그러면 원래 select * from monster where name = '조건값';
			// ?자리에 값을 설정하는 것을 set자료형()를 호출
			//statement.setString() 하기전
			// sql = "select * from monster where grade = "희귀";
			
			statement.setInt(1,16);
			statement.setInt(2, 7);
			
			
			int result = statement.executeUpdate(); //sql 실행하면 업데이트 갯수
													
			System.out.println( "update 카운트: " + result);
				
				
				
				
				
		} catch (Exception e) {
			// 사용자 id, password 오류 또는 mysql서버가 바쁨쁠때(?)
			System.out.println("MySQL 서버에 연결  실패했습니다.");
			System.out.println("오류 내용: " + e.getMessage());
		}
		 
		 }
		}
	


