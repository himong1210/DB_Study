/** Monster.java: 모든 몬스터 객체가 함께 사용하는 설계도입니다. */
package ex01;

public class Monster {
    // 필드: 몬스터가 가지고 있는 정보입니다.
	
	private int id;
	private String name;
    private String grade;
    private int level;
    private int exp;
    private String element;
    private int age;  //getter /setter  만들기



	// 생성자: 새 몬스터를 만들 때 필요한 정보를 받습니다.
    public Monster(
    		int id, String name, String grade, int level, int exp, String element, int age) {
       this.id = id;
    	this.name = name;
        this.grade = grade;
        this.level = level;
        this.exp = exp;
        this.element = element;
        this.age = age;
    }
    
    //새로운 생성자 만들기
    public Monster(
    		int id, String name, String grade, int level, int exp, String element) {
    	//완전한 생성자를 부르고 모자라는 멤버는 초기값을 영점처리
    	this(id, name, grade, level, exp, element, 0);
    }

	// Getter: private 필드의 값을 읽을 수 있도록 도와줍니다.
    public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public String getElement() {
		return element;
	}

	public int getAge() {
		return age;
	}

	// 도감에 표시할 정보를 한 줄의 문자열로 만들어 줍니다.
	public String getInfo() {
		return name + " / " + 
			   grade + " / 레벨 " +
			   level + " / 경험치 " + 
			   exp + " / 속성 " +
			   element + " / 나이 " +
			   age;
	}
}
