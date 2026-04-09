package pekan3_2511533026;

public class stackArray_2511533026 {
	static final int MAX_3026 = 1000;
	int top_3026;
	int a_3026[] = new int [MAX_3026];
	boolean isEmpty()
	{
		return (top_3026 < 0);
	}
	stackArray_2511533026()
	{
		top_3026 = -1;
	}
	boolean push (int x_3026)
	{
			if (top_3026 >= (MAX_3026 - 1)) {
				System.out.println("Stack Overflow");
				return false;
			}
			else {
				a_3026[++top_3026] = x_3026;
				System.out.println(x_3026 + " dimasukkan dalam stack");
				return true;
			}
	}
	int pop()
	{
		if (top_3026 < 0)	{
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x_3026 = a_3026 [top_3026--];
			return x_3026;
		}
	}
	int peek()
	{
		if (top_3026 < 0) {
			return 0;
		}
		else {
			int x_3026 = a_3026 [top_3026];
			return x_3026;
		}
	}
	void print() {
		for (int i_3026 = top_3026;i_3026>-1;i_3026--) {
			System.out.print(" "+ a_3026[i_3026]);
	}
	}
}