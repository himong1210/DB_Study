package ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbSelectTest {

	public static void main(String[] args) {
		
		String sql =
				"select id, name, grade, level_no, exp , element FROM monsters;";
		// 워크벤치의 Test_Connection과 같은 기능 만들기
		try(
				Connection connection = DbConfig.getConnection();
				PreparedStatement statement =
						connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
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
			while (resultSet.next()) {
				//각 mysql테이블의 컬럼과 Monster 클래스의 멤버필드와 1:1 매핑
				int id = resultSet.getInt("id"); //get ooo("컬럼명")
				String name = resultSet.getString("name");
				String grade = resultSet.getString("grade");
				int level = resultSet.getInt("level_no");
				int exp = resultSet.getInt("exp");
				String element = resultSet.getString("element");
				
				Monster monster =
					new Monster(id, name, grade, level, exp, element);
				
				System.out.println(monster.getName());
			}
				
				
				
				
		} catch (Exception e) {
			// 사용자 id, password 오류 또는 mysql서버가 바쁨쁠때(?)
			System.out.println("MySQL 서버에 연결  실패했습니다.");
			System.out.println("오류 내용: " + e.getMessage());
		}
		 
		 }
		}
	


