package Stack;

public class SortStack {
	
	public static Stack sort(Stack st) {
		Stack tmp = new Stack();
		
		
		return tmp;
	}
	
	public static void reverse(Stack st) {
		if (st.isEmpty()) return;
		int p = st.pop();
		reverse(st);
		insertAtBottom(st,p);
	}
	
	
	public static void insertAtBottom(Stack st, int n) {
		if(st.isEmpty()) {
			st.push(n);
		} else {
			int p = st.pop();
			insertAtBottom(st, n);
			st.push(p);
		}
	}
	
	
	public static void main(String[] args) {
		Stack st = new Stack();
		for (int i=0; i<5; i++) st.push(i);
		//insertAtBottom(st, 5);
		System.out.println(st.peek());
		
		//System.out.println(bottomEle(st));
		reverse(st);
		System.out.println("-----");
		while(!st.isEmpty()) System.out.print(st.pop()+" ");
	}

}
