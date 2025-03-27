
import java.util.LinkedList;
import java.util.Queue;

class BinaryTree 
{
      static class Node
    {
        int data;
        Node left;
        Node right;
        
        Node(int i)
        {
            data = i;
            left = null;
            right = null;
        }
    }
    static int idx =-1;
    
    public static Node buildTree( int []nodes)
    {
        idx++;
        if(nodes[idx]== -1)
        {
            return null;
        }
        
    Node newNode = new Node(nodes[idx]);
    newNode.left = buildTree(nodes);
    newNode.right = buildTree(nodes);
        return newNode;
    }
    
    public static void preorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+ " ");
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static void levelorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty())
        {
            Node currNode = q.remove();
            if(currNode == null)
            {
                System.out.println();
                if(q.isEmpty())
                {
                    break;
                }else
                {
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null)
                {
                    q.add(currNode.left);
                }
                
                if(currNode.right!=null)
                {
                    q.add(currNode.right);
                }
            }
        }
    } 
    public static int countofNode(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int left = countofNode(root.left);
        int right = countofNode(root.right);
      
        return left + right +1;
    }
    
     public static int sumofNode(Node root)
     {
         if(root == null)
         {
             return 0;
         }
         int leftsum = sumofNode(root.left);
         int rightsum = sumofNode(root.right);
         int sum = leftsum + rightsum+ root.data;
         return sum;
     }
     public static int heightofNode(Node root)
     {
        if(root == null)
        {
            return 0;
        }
        int left = heightofNode(root.left);
        int right = heightofNode(root.right);
        int hei = Math.max(left, right) +1;
        return hei;
     }
      public static int diaofNode(Node root)
      {
          if(root == null)
          {
              return 0;
          }
          
          int left = diaofNode(root.left);
          int right = diaofNode(root.right);
          int addDia = Math.max(heightofNode(root.left), heightofNode(root.right))+1;
          
          return Math.max(addDia, Math.max(left, right));
      }
    public static void main(String[] args) 
    {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}; 
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("PreOrder   ");
        preorder(root);
        System.out.print("\nPostOrder  ");
        postorder(root);
        System.out.print("\nInorder     ");
        inorder(root);
        System.out.println("\nLevelorder BFS    ");
        levelorder(root);
        System.out.println("Nomber of Nodes "+ countofNode(root));
        System.out.println("Sum of Nodes "+ sumofNode(root));
        System.out.println("Height of Tree "+ heightofNode(root));
        System.out.println("Diameter of Tree "+ diaofNode(root));
    }
}
