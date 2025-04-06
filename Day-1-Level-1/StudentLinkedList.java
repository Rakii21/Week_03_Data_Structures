class StudentNode{
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;
    public StudentNode(int rollNumber,String name,int age,char grade){
        this.rollNumber=rollNumber;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}
public class StudentLinkedList{
    private StudentNode head;
    public void addAtBeginning(int rollNumber,String name,int age,char grade){
        StudentNode newnode=new StudentNode(rollNumber, name, age, grade);
        newnode.next=head;
        head=newnode;
    }
    public void addAtEnd(int rollNumber,String name,int age,char grade){
        StudentNode newnode =new StudentNode(rollNumber, name, age, grade);
        if(head==null){
            head=newnode;
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null) temp=temp.next;
        temp.next=newnode;
    }
    public void addAtPosition(int position,int rollNumber,String name,int age,char grade){
        if(position==0){
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        StudentNode newnode=new StudentNode(rollNumber, name, age, grade);
        StudentNode temp=head;
        for(int i=0;temp!=null && i<position-1;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Position out of bounds");
            return;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public void removeByRoll(int roll){
        if(head==null) return;
        if(head.rollNumber==roll){
            head=head.next;
        }
        StudentNode temp=head;
        while(temp.next !=null && temp.next.rollNumber!=roll){
            temp=temp.next;
        }
        if(temp.next==null) {
            System.out.println("Roll Number not found");
            return;
        }
        temp.next=temp.next.next;
    }
    public void searchBYRoll(int roll){
        if(head==null) return;
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollNumber==roll){
                System.out.println("Found: "+temp.name+" Age: "+temp.age+" Grade: "+temp.grade);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Roll Number not found");
    }
    public void updateGrade(int roll,char newgrade){
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollNumber==roll){
                temp.grade=newgrade;
                System.out.println("Grade updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Roll number not found");
    }
    public void displayAll(){
        if(head==null) {
            System.out.println("No Student record found");
            return;
        }
        StudentNode temp=head;
        while(temp!=null){
            System.out.println("Roll number: "+temp.rollNumber+", Name: "+temp.name+", Age: "+temp.age+", Grade: "+temp.grade);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        StudentLinkedList list=new StudentLinkedList();
        list.addAtBeginning(401, "Mohan", 21, 'C');
        list.addAtEnd(403, "Jayavarman", 21, 'B');
        list.addAtPosition(1, 402, "Rakesh", 21, 'A');
        list.displayAll();
        list.searchBYRoll(402);
        list.updateGrade(401, 'A');
        list.displayAll();
        list.removeByRoll(403);
        list.displayAll();
    }
}