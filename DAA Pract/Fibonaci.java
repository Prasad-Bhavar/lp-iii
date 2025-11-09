class Fibonaci {

    public  static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        int n = 10; 
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }

        //non-recursive approach
        System.out.println("\nNon-recursive approach:");    
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        
    }

    
}