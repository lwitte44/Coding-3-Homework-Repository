package driver;

public class Main {

	public static void main(String[] args) {
		System.out.println("Abstraction.");
		Stack stack = new IntListStack();
//		stack.Peek();
//		stack.Pop();
//		stack.Push(new Node());
//		
//		iStack stack1 = new StackInterfaceList();
//		stack1.Peek();
//		stack1.Pop();
//		stack1.Push(null);
		
		//stack.IsExpValid("(1 + 2 * (3 -1) ) / (1 + 1)") ; //true
		System.out.println(stack.IsExpValid("(1 + 2 * (3 -1) ) / (1 + 1)"));
		//stack.IsExpValid("(1 + 2 * (3 -1) / (1 + 1)"); //false
		System.out.println(stack.IsExpValid("(1 + 2 * (3 -1) / (1 + 1)"));
		
	}

}