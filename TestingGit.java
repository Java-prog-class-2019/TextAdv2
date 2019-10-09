
public class TestingGit {

	public static void main(String[] args) {
		
		
		int x = getRandom(); // Jeremy writes this

		printout(x);  //Gene writes this

		
	}
	static void printout(int x) {
		System.out.print(x);
		
	}
	
	static int getRandom() {
		int a=(int)(Math.random()*100);
		return a;
	}

}
