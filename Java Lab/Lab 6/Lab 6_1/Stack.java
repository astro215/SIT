    import pkg_Stack.Interface_STK;

    import java.util.ArrayList;
    import java.util.Scanner ;
    public class Stack {
        public static void main(String[] arg){


            while (true) {
                System.out.println("*************** Stack Menu *****************");
                System.out.println("1. Fixed Stack Operations");
                System.out.println("2. Growable Stack Operations");
                System.out.println("3. Exit");
                System.out.print("Enter your choice:");

                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        boolean condition = true;
                        System.out.println("*************** Fixed Stack *****************");
                        // read stack size from user
                        System.out.print("Enter the size of the stack: ");
                        int size = input.nextInt();
                        // create a new Fixed Stack object
                        FixedStk fixedStack = new FixedStk(size);
                        System.out.println("*********Fixed Stack initialized with size "+size +"*********");
                        while (condition) {
                            System.out.println("*************** Fixed Stack Menu *****************");
                            System.out.println("1. Push item to Fixed Stack");
                            System.out.println("2. Pop item from Fixed Stack");
                            System.out.println("3. Peek at top item in Fixed Stack");
                            System.out.println("4. Display contents of Fixed Stack");
                            System.out.println("5. Back to Main Menu");
                            System.out.print("Enter your choice:");

                            int fixedChoice = input.nextInt();

                            switch (fixedChoice) {
                                case 1:
                                    // pushing item to Fixed Stack
                                    System.out.print("Enter the item to be pushed to the stack: ");
                                    int item = input.nextInt();
                                    fixedStack.push(item);
                                    // display the top item
                                    fixedStack.displayTop();
                                    // display the stack
                                    fixedStack.displayStack();
                                    break;

                                case 2:
                                    // popping item from Fixed Stack
                                    fixedStack.pop();
                                    // display the top item
                                    fixedStack.displayTop();
                                    // display the stack
                                    fixedStack.displayStack();
                                    break;

                                case 3:
                                    // peeking at top item in Fixed Stack
                                    fixedStack.peek();
                                    break;

                                case 4:
                                    // displaying contents of Fixed Stack
                                    fixedStack.displayStack();
                                    break;

                                case 5:
                                    // Exit from Fixed Stack menu
                                    System.out.println("Exiting from Fixed Stack menu...");
                                    condition = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }

                        }

                    case 2:
                        condition = true;
                        System.out.println("*************** Growable Stack *****************");

                        // create a new Growable Stack object
                        GrowableStk growableStack = new GrowableStk();
                        while (condition) {

                            System.out.println("*************** Growable Stack Menu *****************");
                            System.out.println("1. Push item to Growable Stack");
                            System.out.println("2. Pop item from Growable Stack");
                            System.out.println("3. Peek at top item in Growable Stack");
                            System.out.println("4. Display contents of Growable Stack");
                            System.out.println("5. Back to Main Menu");
                            System.out.print("Enter your choice:");

                            int growableChoice = input.nextInt();

                            switch (growableChoice) {
                                case 1:
                                    //  pushing item to Growable Stack
                                    System.out.print("Enter the item to be pushed to the stack: ");
                                    int item = input.nextInt();
                                    growableStack.push(item);
                                    // display the top item
                                    growableStack.displayTop();
                                    // display the stack
                                    growableStack.displayStack();
                                    break;

                                case 2:
                                    // popping item from Growable Stack
                                    growableStack.pop();
                                    // display the top item
                                    growableStack.displayTop();
                                    // display the stack
                                    growableStack.displayStack();
                                    break;

                                case 3:
                                    //  peeking at top item in Growable Stack
                                    growableStack.peek();
                                    break;

                                case 4:
                                    //  displaying contents of Growable Stack
                                    growableStack.displayStack();
                                    break;

                                case 5:
                                    // Exit from Growable Stack menu
                                    System.out.println("Exiting from Growable Stack menu...");
                                    condition = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }

                        }
                        break;

                    case 3:
                        // Add code to exit the program here
                        System.out.println("Exiting from the program...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

        }
    }



     class FixedStk implements Interface_STK {
        private final int[] stack;
        private int top;

        public FixedStk(int size) {
            stack = new int[size];
            top = -1;
        }

        @Override
        public void push(int item) {
            if (isFull()) {
                System.out.println("Stack is full.");
            } else {
                stack[++top] = item;
                System.out.println("Item inserted: " + item);
            }
        }

        @Override
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            } else {
                int popped = stack[top--];
                System.out.println("Item removed: " + popped);
                return popped;
            }
        }

        @Override
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            } else {
                return stack[top];
            }
        }

        @Override
        public boolean isEmpty() {
            return top == -1;
        }

        @Override
        public boolean isFull() {
            return top == stack.length - 1;
        }

        @Override
        public void size(){
            System.out.println("Size of the stack: " + (top + 1));
        }

        @Override
        public void displayStack() {
            System.out.println("Contents of the stack:");
            if (isEmpty()) {
                System.out.println("Empty stack");
            } else {
                System.out.print("Stack : ");
                for (int i = top; i >= 0; i--) {
                    System.out.print(stack[i] + " ");
                }
                System.out.println();
            }
        }


         @Override
        public void displayTop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
            } else {
                System.out.println("Top item in the stack: " + stack[top]);
            }
        }
    }

     class GrowableStk implements Interface_STK {
        private final ArrayList<Integer> stack;
        private int top;


        public GrowableStk() {
            stack = new ArrayList<Integer>();
            top = -1;
        }

        @Override
        public void push(int item) {
            stack.add(++top, item);
        }

        @Override
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            } else {
                int popped = stack.remove(top--);
                System.out.println("Item removed: " + popped);
                return popped;
            }
        }

        @Override
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            } else {
                return stack.get(top);
            }
        }

        @Override

        public boolean isEmpty() {
            return top == -1;
        }

        @Override
        public boolean isFull() {
            System.out.println("Not valid for growable stack.");
            return false;
        }

        @Override
        public void size(){
            System.out.println("Size of the stack: " + (top + 1));
        }

         @Override
         public void displayStack() {
             System.out.println("Contents of the stack:");
             if (isEmpty()) {
                 System.out.println("Empty stack");
             } else
             {
                 System.out.println("Stack :" + stack.toString());
             }
         }


         @Override
        public void displayTop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
            } else {
                System.out.println("Top item in the stack: " + stack.get(top));
            }
        }
    }
