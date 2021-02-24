public class Main {
    public static void main(String[] args){

        String[] input = args[0].split("");

        StringBuilder tmp;
        Stack<String> stack = new Stack<>(input.length);


        for (String s : input) {
            if (Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {
                try{
                    stack.push(s);
                }
                catch (StackOverflowException e){
                    System.out.print(e);
                    System.exit(0);
                }

            }
            else{
                tmp = new StringBuilder("(");
                try{
                    String n1, n2;
                    n2 = stack.pop();
                    n1 = stack.pop();
                    n1 = n1+s+n2+")";
                    tmp.append(n1);
                }
                catch (StackUnderflowException e) {
                    System.err.println(e);
                    System.exit(0);
                }
                try{
                    stack.push(tmp.toString());
                }
                catch (StackOverflowException e){
                    System.err.println(e);
                    System.exit(0);
                }
            }
        }

        if(stack.getSize() == 1)
            System.out.println("Wynik: "+stack);
        else
            System.out.println("BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty: "+stack);

    }
}