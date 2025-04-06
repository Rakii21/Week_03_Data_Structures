class Book{
    String title;
    String author;
    String genre;
    String id;
    boolean isAvailable;
    Book next;
    Book prev;
    public Book(String title,String author,String genre,String id,boolean isAvailable){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.id=id;
        this.isAvailable=isAvailable;
        this.next=null;
        this.prev=null;
    }
}
public class Library {
    private Book head=null,tail=null;
    public void addAtBeginning(Book newbook){
        if(head==null){
            head=tail=newbook;
        }
        else{
            head.prev=newbook;
            newbook.next=head;
            head=newbook;
        }
    }
    public void addAtEnd(Book newbook){
        if(head==null){
            head=tail=newbook;
        }
        else{
            tail.next=newbook;
            newbook.prev=tail;
            tail=newbook;
        }
    }
    public void addAtPosition(int position,Book newbook){
        if(position<=1){
            addAtBeginning(newbook);
            return;
        }
        Book temp=head;
        for(int i=1;i<position-1 && temp.next!=null;i++){
            temp=temp.next;
        }
        if(temp.next==null){
            addAtEnd(newbook);
        }
        else{
            newbook.next=temp.next;
            newbook.prev=temp;
            temp.next.prev=newbook;
            temp.next=newbook;
        }
    }
    public void removeByID(String id){
        Book temp=head;
        while(temp!=null && !temp.id.equals(id)){
            temp=temp.next;
        }
        if(temp==null) System.out.println("Book ID: "+id+" not found");
        if(temp==head){
            head=head.next;
            if(head!=null) head.prev=null;
        }
        else if(temp==tail){
            tail=tail.prev;
            tail.next=null;
        }
        else{
        temp.next.prev=temp.prev;
        temp.prev.next=temp.next;
        }
        System.out.println("Book ID: "+id+" has been removed");
    }
    public void searchBook(String keyword){
        Book temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)){
                System.out.println("Found: "+temp.title+" by "+temp.author+", STATUS: "+(temp.isAvailable?"Available":"Not Available"));
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("No matching Book found");
    }
    public void updateAvailability(String id,boolean newStatus){
        Book temp=head;
        while(temp!=null){
            if(temp.id.equals(id)){
                temp.isAvailable=newStatus;
                System.out.println("Status updated for Book ID: "+id);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Book not found");
    }
    public void displayForward(){
        Book temp=head;
        while(temp!=null){
            System.out.println("Book Title: "+temp.title+" | Author: "+temp.author+" | Genre: "+temp.genre+" | Availability: "+temp.isAvailable);
            temp=temp.next;
        }
    }
    public void displayReverse(){
        Book temp=tail;
        while(temp!=null){
            System.out.println("Book Title: "+temp.title+" | Author: "+temp.author+" | Genre: "+temp.genre+" | Availability: "+temp.isAvailable);
            temp=temp.prev;
        }
    }
    public void countBooks(){
        Book temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("Total Count: "+count);
    }
    public static void main(String[] args) {
        Library lib =new Library();
        lib.addAtEnd(new Book("The Alchemist", "Paulo Coelho", "Fiction", "B001", true));
        lib.addAtBeginning(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "Finance", "B002", true));
        lib.addAtPosition(2, new Book("1984", "George Orwell", "Dystopian", "B003", false));
        lib.displayForward();
        lib.countBooks();
        lib.searchBook("Rich Dad Poor Dad");
        lib.updateAvailability("B003", true);
        lib.removeByID("B001");
        lib.displayReverse();
    }
}
