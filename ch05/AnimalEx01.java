package ch05;

class Animal{
	
}
class Dog extends Animal{
	final String NAME="강아지"; 
}
class Cat extends Animal{
	final String NAME="고양이";
}

class Bird extends Animal{
	final String NAME="새";
}
public class AnimalEx01 {

	static void attack(Dog u1, Cat u2) {
		System.out.println(u2.NAME+"가 "+u1.NAME+"에게 공격당했습니다.");
	}
	static void attack(Dog u1, Bird u2) {
		System.out.println(u2.NAME+"가 "+u1.NAME+"에게 공격당했습니다.");
	}
	static void attack(Cat u1, Bird u2) {
		System.out.println(u2.NAME+"가 "+u1.NAME+"에게 공격당했습니다.");
	}


	
	
	public static void main(String[] args) {
		Dog d1=new Dog();
		Cat c1=new Cat();
		Bird b1=new Bird();
		
		System.out.println(d1.NAME+ "의 탄생");
		System.out.println(c1.NAME+ "의 탄생");
		System.out.println(b1.NAME+ "의 탄생");
		
		//강아지vs고양이
		attack(d1,c1);
		
		//강아지vs새
		attack(d1,b1);
		
		//고양이vs새
		attack(c1,b1);
	}

}
