public class Stack<T> {

    T[] stack;
    int size;
    int max_size;

    public Stack(int max){
        @SuppressWarnings("unchecked")
        final T[] st = (T[]) new Object[max];

        for(T el : st)
            el = null;

        size = 0;
        max_size = max;
        stack = st;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == max_size;
    }

    public void push(T x) throws StackOverflowException{
        if(!this.isFull()){
            stack[size] = x;
            size++;
        }
        else
        {
            throw new StackOverflowException("BLAD DANYCH WEJSCIOWYCH! Stos się przepełnił.");
        }
    }

    public T pop() throws StackUnderflowException{
        if(!this.isEmpty()){
            T tmp = stack[size-1];
            stack[size-1] = null;
            size--;
            return tmp;
        }
        else{
            throw new StackUnderflowException("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za malo elementow, zeby wykonac operacje");
        }
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder stack_str = new StringBuilder();
        for(int i=0;i<size;i++)
        {
            stack_str.append((String) stack[i]);
            if(i!=size-1) stack_str.append(", ");
        }
        return stack_str.toString();

    }


}
