package composite;

public class 라면 {

	String item1;
	String item2;
	String item3;

	public 라면() {
		this("물", "건더기스프", "분말스프");
	}
	
	public 라면(String item1) {
		this(item1, "건더기스프", "분말스프");
	}
	
	public 라면(String item1, String item2) {
		this(item1,null,item2);
	}
	
	public 라면(String item1, String item2, String item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	public static void main(String[] args) {
		라면 r1=new 라면("물", "건더기스프", "분말스프");
		라면 r2=new 라면();
		라면 r3=new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 r4=new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 r5=new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 r6=new 라면();
		라면 r7=new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 r8=new 라면("쌀뜬물");
		


	}
}
