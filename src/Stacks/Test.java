package Stacks;

public class Test {
	public static void main(String[] args) {
		ArrayBoundedStack<Object> stack = new ArrayBoundedStack<Object>();
		stack.push(1);
		stack.push("one");
		stack.push('I');
		stack.push(2);
		stack.push("two");
		stack.push("II");
		System.out.println("The toString(); method reads from left to right, starting with the bottom of the stack.");
		System.out.println("The contents of the Stack are:");
		System.out.println(stack.toString());
		System.out.println(stack.size());
		stack.popSome(3);
		System.out.println(stack.swapTop());
		System.out.println(stack.popTop());
	}
}
