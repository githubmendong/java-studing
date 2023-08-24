package prob5;

public class MyStack {
    private int top;
    private String[] buffer;

    public MyStack(int capacity) {
        top = -1;
        buffer = new String[capacity];
    }

    public void push(String s) throws MyStackException {
        if (top == buffer.length - 1) {
            throw new MyStackException("stack is full");
        }
        buffer[++top] = s;
    }

    public String pop() throws MyStackException {
        if (isEmpty()) {
            throw new MyStackException("stack is empty");
        }
        return buffer[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}