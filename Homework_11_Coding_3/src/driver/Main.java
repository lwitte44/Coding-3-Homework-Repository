package driver;

public class Main<T> {

    // Non-static method for the main logic
    public void mainMethod() {
        DoublyLinkedList<T> list = new DoublyLinkedList<>();
        Node<T> nodeOne = new Node<>();
        Node<T> nodeTwo = new Node<>();
        Node<T> nodeThree = new Node<>();
        Node<T> nodeFour = new Node<>();
        Node<T> nodeFive = new Node<>();
        Node<T> nodeSix = new Node<>();
        Node<T> nodeSeven = new Node<>();
        Node<T> nodeEight = new Node<>();
        Node<T> nodeNine = new Node<>();
        Node<T> nodeTen = new Node<>();
        
        System.out.println("Hello List");
        list.Append(nodeOne);
        list.Prepend(nodeTwo);
        
        System.out.println("The List's Current Length is: " + list.GetLength());
        
        list.Append(nodeThree);
        System.out.println("The List's Current Length is: " + list.GetLength());
        
        Node<T> node = list.Search(nodeOne.payload);
        if (node != null) {
            list.InsertAfter(nodeTwo, nodeFour);
            list.InsertAfter(nodeOne, nodeFive);
        }
        
        System.out.println("The List's Current Length is: " + list.GetLength());
        
        Node<T> toBeRemoved = list.Search(nodeTwo.payload);
        list.Remove(toBeRemoved);
        list.Remove(list.header); // Assuming this removes the head node
        
        //list.print();
        //list.printReverse();
        
        list.Append(nodeSix);
        list.Append(nodeSeven);
        list.Append(nodeEight);
        list.Append(nodeNine);
        list.Prepend(nodeTen);
        
        System.out.println("The List's Current Length is: " + list.GetLength());
        
        list.Print();
        list.Sort(false); // Sort in descending order
        list.Print();
        
    }

    // Static main method to run the program
    public static void main(String[] args) {
        Main<Integer> mainInstance = new Main<>();
        mainInstance.mainMethod();
    }
}
