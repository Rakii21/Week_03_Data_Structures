class MovieNode{
    String movieTitle;
    String director;
    int year;
    double rating;
    MovieNode prev,next;
    public MovieNode(String movieTitle,String director,int year,double rating){
        this.movieTitle=movieTitle;
        this.director=director;
        this.year=year;
        this.rating=rating;
        this.next=null;
        this.prev=null;
    }
}
public class MovieList {
    private MovieNode head,tail;
    public void addAtBeginning(String movieTitle,String director,int year,double rating){
        MovieNode newnode=new MovieNode(movieTitle, director, year, rating);
        if(head==null){
            head=tail=newnode;
        }
        else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
    }
    public void addAtEnd(String movieTitle,String director,int year,double rating){
        MovieNode newnode=new MovieNode(movieTitle, director, year, rating);
        if(tail==null){
            head=tail=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
    }
    public void addAtPosition(int position,String movieTitle,String director,int year,double rating){
        if(position==0){
            addAtBeginning(movieTitle, director, year, rating);
            return;
        }
        MovieNode newnode=new MovieNode(movieTitle, director, year, rating);
        MovieNode temp=head;
        for(int i=0;i<position-1 && temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            addAtEnd(movieTitle, director, year, rating);
            return;
        }
        newnode.next=temp.next;
        newnode.prev=temp;
        temp.next.prev=newnode;
        temp.next=newnode;
    }
    public void removeByTitle(String title){
        if(head==null) return;
        MovieNode temp=head;
        while(temp!=null){
            if(temp.movieTitle.equalsIgnoreCase(title)){
                if(temp==head){
                    head=head.next;
                    if(head != null) head.prev=null;
                }else if(temp==tail){
                    tail=tail.prev;
                    if(tail!=null) tail.next=null;
                }else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Movie "+title+" has been removed");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Title not found");
        
    }
    public void searchByDirector(String director){
        MovieNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.director.equalsIgnoreCase(director)){
                System.out.println("Found: "+temp.movieTitle+", Year: "+temp.year+", Ratings: "+temp.rating);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("Director not found");
    }
    public void searchByRatings(double rating){
        MovieNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.rating==rating){
                System.out.println("Found: "+temp.movieTitle+", Director: "+temp.director+", Year: "+temp.year);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("Ratings is not found");
    }
    public void updateRating(String title,double newrating){
        MovieNode temp=head;
        while(temp!=null){
            if(temp.movieTitle.equalsIgnoreCase(title)){
                temp.rating=newrating;
                System.out.println("Ratings updated for movie "+temp.movieTitle);
            }
            temp=temp.next;
        }
    }
    public void displayForward(){
        MovieNode temp=head;
        while(temp!=null){
            System.out.println("Title: "+temp.movieTitle+", Director: "+temp.director+", Realese Year: "+temp.year+", Ratings: "+temp.rating);
            temp=temp.next;
        }
    }
    public void displayReverse(){
        MovieNode temp=tail;
        while(temp!=null){
            System.out.println("Title: "+temp.movieTitle+", Director: "+temp.director+", Realese Year: "+temp.year+", Ratings: "+temp.rating);
            temp=temp.prev;
        }
    }
    public static void main(String[] args) {
        MovieList movies=new MovieList();
        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movies.addAtPosition(1, "The Matrix", "Wachowski", 1999, 8.7);
        movies.displayForward();
        movies.searchByDirector("Christopher Nolan");
        movies.searchByRatings(8.7);
        movies.updateRating("Interstellar", 9);
        movies.removeByTitle("Inception");
        movies.displayForward();
        movies.displayReverse();
    }
}
