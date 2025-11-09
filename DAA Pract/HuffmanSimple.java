import java.util.PriorityQueue;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class HuffmanComparator implements java.util.Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq; // Greedy: pick smallest frequency first
    }
}

public class HuffmanSimple {
    
    // Print Huffman Codes (Recursive Tree Traversal)
    public static void printCodes(Node root, String code) {
        if (root == null) return;

        // Print only leaf nodes (actual characters)
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        // Characters and their frequencies
        char[] chars = { 'a', 'b', 'c', 'd', 'e' };
        int[] freq = { 5, 9, 12, 13, 16 };

        PriorityQueue<Node> pq = new PriorityQueue<>(new HuffmanComparator());

        // Step 1: Create leaf nodes and insert in min-heap
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Step 2: Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();   // smallest
            Node right = pq.poll();  // second smallest

            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode); // push back
        }

        // Final root of Huffman Tree
        Node root = pq.poll();

        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}

