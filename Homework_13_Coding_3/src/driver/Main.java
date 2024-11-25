package driver;

public class Main {

	public static void main(String[] args) {
		String exp = "4^2+18/(9-3)";
		TokenList list = ShuntingYard.ParseFromExp(exp);
		System.out.println(list);
		TokenList queue = ShuntingYard.BuildFromTokens(list);
		System.out.println(queue);
		int result = ShuntingYard.Process(queue);
		System.out.println(result);
	}

}