package LinkedList;

import java.util.HashSet;

public class CRUDLinkedList 
{
	static	int sz=0;
	static class Node
	{
		String data;
		Node next;	
	
		Node(String givendata)
		{
			this.data=givendata;
			this.next=null;	
			sz++;
		}	
	}
	static Node head;
	//=============================================================================================
	private static void displayList() 
	{
		if(head==null)
		{
			 System.out.println("List is empty");
			return;
		}
		{
		Node currNode = head;
		while(currNode!=null) 
		{
			System.out.print(currNode.data+" -> ");
			currNode=currNode.next;
		}
		System.out.print( " End\n");		
	}
	}
	//=============================================================================================
	public static void insertFirst(String inputData) 
	{	
		Node newNode= new Node(inputData);
		if(head==null)
		{
			head= newNode;
			return;
		}
		else 
		{
			 newNode.next=head;
			 head=newNode;
		}
	}
	//=============================================================================================
	private static void insertLast(String data) 
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			return;
		}
		Node currNode = head;
		while(currNode.next!=null)
		{
			currNode= currNode.next;
		}
		currNode.next=newNode;
	 }	
	//=============================================================================================
	private static void deleteFirst()
	{
		System.out.println("Deleting First Element");
		
		if(head==null) 
		{
			System.out.println("Empty List");
			return;
		}
		else 
		{head=head.next;
		sz--;	 }
	 }
	//=============================================================================================
	private static void deleteLast() 
	{
		if(head==null) 
		{
			System.out.println("List is empty");
			return;
		}		
		if(head.next==null) 
		{
			head=null;
			sz--;
			return;
		}
		 Node secondLast=head;
		 
		 while(secondLast.next.next!=null) 
		 {			  
			 secondLast = secondLast.next;	  
		 }
		 secondLast.next=null;
		 sz--;
		 
	}
	//=============================================================================================
	private static void insertAt(String data, int pos) 
	{
		if(pos<=0) 
		{
			System.out.println("can not insert in 0 or low place ");
			return;
		}
		else if(pos==1) 
		{
			CRUDLinkedList.insertFirst(data);
			return;
		}	
		Node newNode =new Node(data);
		Node currNode = head;	 
		for (int i = 1; currNode!=null && i<pos-1;i++) 
		{		
			 currNode = currNode.next;	 
			 if(currNode==null) 
			 {
				 System.err.println("Out of range");
				 return;
			 }			
		}
		 newNode.next=currNode.next;
		 currNode.next=newNode;
	 }
	//=============================================================================================
	private static void deleteAt(int pos) 
	{
		if(pos<=0) 
		{
			System.err.println("Invalid location");
		}
		else if(pos==1)
		{
			CRUDLinkedList.deleteFirst();
			sz--;
			return;
		}
			Node currNode=head;
		for(int i=1; currNode!=null && i<pos-1;i++ ) 
		{
			currNode=currNode.next;		
		}
		currNode.next=currNode.next.next;	
		sz--;
	}	
	//=============================================================================================
	private static void searchfor(String data) 
	{
		Node currNode =head;
		int i =0;
		int loc = -1;
		while(currNode.next!=null ) 
		{
			i++;
			if(currNode.data== data)				
			{	
			loc= i;
			break;
			}		 
			currNode = currNode.next;
		}	
		if(loc==-1) {
			System.out.println("Data Not Found");				
		}else {
			System.out.println("Your data is "+data+ " And Location is "+loc);	
		}
	}
	//=============================================================================================
	private static void displayReverseList()
	{
		if(head==null) 
		{
			System.out.println("List is empty");
			return;
		}		
		Node currNode = head;
		String data ="End ";
		while(currNode!=null) 
		{
			  data= data + currNode.data +" ";
			  
			currNode=currNode.next;
		}
		String[] old =data.split(" ");
		String[] arr2 = new String [old.length];
		int j=0;	
		for (int i = old.length-1;i>=0;i--)
		{
			arr2 [j] =old[i];
			j++;
		}	
		String revData =String.join(" -> ", arr2);
		System.out.println("Reversed Data "+revData);		 
	}	
	//=============================================================================================
	
	private static void findMiddle() 
	{
		Node currNode=head;
		int i=0;
		int sum=0;
		if(head==null) 
		{
			System.out.println("Empty List");
		}
		else if(head.next==null)
		{
			CRUDLinkedList.searchfor(1);
		}
		else
		{
			while(currNode!=null)
			{
				i++;
				sum=sum+i;	
				currNode=currNode.next;
			}		
		int mid =((int)i/2)+1;
		CRUDLinkedList.searchfor(mid);
		}
	}	
	//=============================================================================================
	private static void searchfor(int loc)
	{
		Node currNode=head;
		int i=0;
		if(head==null) 
		{
			System.out.println("Empty List");
		}else if(head.next==null)
		{
			System.out.println("Data is "+head.next.data);
		}
		while(currNode!=null)
		{
			i++;
			if(i==loc) 
			{
				System.out.println("Data is "+currNode.data+" in loacation "+loc);
			}
			currNode=currNode.next;
		}
	 }	
	//=============================================================================================
	private static void removeDuplicates()
	{
		Node currNode = head;
		if(head==null)
		{
			System.out.println("List is empty");
		}
		else if(head.next==null)
		{
			System.out.println("Only one data present that is  "+currNode.next.data);
		}
		 HashSet<String> seen = new HashSet<>();
	        Node curr = head;
	        Node prev = null;

	        while (curr != null) {
	            if (seen.contains(curr.data)) {
	                // Remove duplicate
	                prev.next = curr.next;
	                sz--;  // Decrement size since we removed a node
	            } else {
	                seen.add(curr.data);
	                prev = curr;
	            }
	            curr = curr.next;
	        }
	 }
	//=============================================================================================
	private static void listSize() 
	{
		System.out.println("Total Number of elements in List "+sz);
 }	
	//=============================================================================================
	private static void mergeList() {
 	}
	//=============================================================================================
	
	public static void main(String[] args) 
	{
		CRUDLinkedList.insertFirst("1");
		CRUDLinkedList.insertFirst("2");
		CRUDLinkedList.insertFirst("3");
		CRUDLinkedList.displayList();//3 -> 2 -> 1 ->  End
		
		CRUDLinkedList.insertLast("4");	
		CRUDLinkedList.insertLast("5");
		CRUDLinkedList.insertLast("6");
		CRUDLinkedList.insertLast("7");
		CRUDLinkedList.insertLast("8");
		CRUDLinkedList.displayList();//3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 7 -> 8 ->  End
		
		CRUDLinkedList.deleteFirst();
		CRUDLinkedList.displayList();//2 -> 1 -> 4 -> 5 -> 6 -> 7 -> 8 ->  End
		CRUDLinkedList.deleteLast( );
		CRUDLinkedList.displayList();//2 -> 1 -> 4 -> 5 -> 6 -> 7 ->  End
		
		CRUDLinkedList.insertAt("4",1);
		CRUDLinkedList.displayList();	//4 -> 2 -> 1 -> 4 -> 5 -> 6 -> 7 ->  End
		
		CRUDLinkedList.insertAt("9",4);
		CRUDLinkedList.displayList();//4 -> 2 -> 1 -> 9 -> 4 -> 5 -> 6 -> 7 ->  End
		
		CRUDLinkedList.deleteAt(5);
		CRUDLinkedList.displayList();//4 -> 2 -> 1 -> 9 -> 5 -> 6 -> 7 ->  End
		
		CRUDLinkedList.searchfor("15");//Your data is 1 And Location is 3
		
		CRUDLinkedList.displayReverseList();//Reversed Data 7 6 5 9 1 2 4 End
		
		CRUDLinkedList.searchfor(1);//Data is 4 in loacation 1
		
		
		CRUDLinkedList.findMiddle();//Data is 9 in loacation 4
		
		CRUDLinkedList.listSize();//Total Number of elements in List 7
		
		CRUDLinkedList.insertFirst("2");
		CRUDLinkedList.displayList();//2 -> 4 -> 2 -> 1 -> 9 -> 5 -> 6 -> 7 ->  End
		CRUDLinkedList.removeDuplicates();
		CRUDLinkedList.displayList();//2 -> 4 -> 1 -> 9 -> 5 -> 6 -> 7 ->  End
		CRUDLinkedList.mergeList();	
		//CRUDLinkedList.displayList();
	}
}
