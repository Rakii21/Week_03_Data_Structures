class Item{
    String name;
    String id;
    int quantity;
    double price;
    Item next;
    public Item(String name,String id,int quantity,double price){
        this.name=name;
        this.id=id;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}
public class Inventory {
    Item head=null;
    public void addAtBeginning(String name,String id,int quantity,double price){
        Item newitem=new Item(name, id, quantity, price);
        if(head==null){
            head=newitem;
            return;
        }
        newitem.next=head;
        head=newitem;
    }
    public void addAtEnd(String name,String id,int quantity,double price){
        Item newitem=new Item(name, id, quantity, price);
        if(head==null){
            head=newitem;
            return;
        }
        Item temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newitem;
    }
    public void addAtPosition(int position,String name,String id,int quantity,double price){
        if(position<=1){
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newitem=new Item(name, id, quantity, price);
        Item temp=head;
        for(int i=1;i<position-1 && temp.next!=null;i++){
            temp=temp.next;
        }
        newitem.next=temp.next;
        temp.next=newitem;
    }
    public void removeItem(String id){
        if(head==null) return;
        if(head.id.equals(id)){
            head=head.next;
            return;
        }
        Item temp=head;
        while(temp.next!=null && temp.next.id!=id){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
            System.out.println("Item with ID:"+id+" removed");
        }else System.out.println("Item with ID: "+id+" not found");
    }
    public void updateQuantity(String id,int newquantity){
        Item temp=head;
        while(temp!=null){
            if(temp.id.equals(id)){
                temp.quantity=newquantity;
                System.out.println("Quantity updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Item with ID:"+id+" not found");
    }
    public void searchItem(String keyword){
        Item temp=head;
        while(temp!=null){
            if(temp.id.equalsIgnoreCase(keyword) || temp.name.equalsIgnoreCase(keyword)){
                System.out.println("Item ID: "+temp.id+", Name: "+temp.name+", Quantity: "+temp.quantity+", Price: "+temp.price);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Item not found");
    }
    public void calculateTotal(){
        double total=0;
        Item temp=head;
        while(temp!=null){
            total+=temp.quantity*temp.price;
            temp=temp.next;
        }
        System.out.println("Total Inventory Value: "+total);
    }
    public void displayInventory(){
        if(head==null){
            System.out.println("No Items");
            return;
        }
        Item temp=head;
        while (temp!=null) {
            System.out.println("Item ID: "+temp.id+", Name: "+temp.name+", Quantity: "+temp.quantity+", Price: "+temp.price);
            temp=temp.next;
        }
    }
    public void sortInventory(String criteria,boolean ascending){
        head=mergesort(head,criteria,ascending);
        System.out.println("Inventory sorted by "+criteria+" in "+(ascending?"Ascending":"Descending") );
    }
    private Item mergesort(Item node,String criteria,boolean ascending){
        if(node==null || node.next==null) return node;
        Item mid=getMiddle(node);
        Item nextOfMid=mid.next;
        mid.next=null;

        Item left=mergesort(node, criteria, ascending);
        Item right=mergesort(nextOfMid, criteria, ascending);
        return sortedMerge(left,right,criteria,ascending);
    }
    private Item sortedMerge(Item a,Item b,String criteria,boolean ascending){
        if(a==null) return b;
        if(b==null) return a;
        int compare;
        if(criteria.equalsIgnoreCase("price")){
            compare=Double.compare(a.price, b.price);
        }
        else{
            compare=a.name.compareToIgnoreCase(b.name);
        }
        if(!ascending) compare=-compare;
        if(compare<=0){
            a.next=sortedMerge(a.next, b, criteria, ascending);
            return a;
        }
        else{
            b.next=sortedMerge(a, b.next, criteria, ascending);
            return b;
        }
    }
    private Item getMiddle(Item head){
        if(head==null) return head;
        Item slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Inventory inv=new Inventory();
        inv.addAtBeginning("Mouse", "M01", 50, 300.0);
        inv.addAtEnd("Keyboard", "K01", 30, 700.0);
        inv.addAtPosition(2,"Monitor", "D01", 10, 9000.0);
        inv.displayInventory();
        inv.searchItem("K01");
        inv.updateQuantity("M01", 30);
        inv.calculateTotal();
        System.out.println("Sorting by descending");
        inv.sortInventory("price", false);
        inv.displayInventory();
        inv.removeItem("D01");
        inv.displayInventory();
    }
}

