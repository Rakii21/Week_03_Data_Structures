class Task{
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    public Task(int taskId,String taskName,int priority,String dueDate){
        this.taskId=taskId;
        this.taskName=taskName;
        this.priority=priority;
        this.dueDate=dueDate;
        this.next=null;
    }
    public void displayTask(){
        System.out.println("Task Id: "+taskId+", Task Name: "+taskName+", Priority: "+priority+", Due Date: "+dueDate);
    }
}
public class TaskScheduler{
    private Task head=null;
    private Task tail=null;
    private Task currenTask=null;

    public void addAtBeginning(int taskId,String taskName,int priority,String dueDate){
        Task newtask=new Task(taskId, taskName, priority, dueDate);
        if(head==null){
            head=tail=newtask;
            tail.next=newtask;
        }
        else{
            newtask.next=head;
            head=newtask;
            tail.next=newtask;
        }
    }
    public void addAtEnd(int taskId,String taskName,int priority,String dueDate){
        Task newtask=new Task(taskId, taskName, priority, dueDate);
        if(head==null){
            head=tail=newtask;
            tail.next=newtask;
        }
        else{
            tail.next=newtask;
            tail=newtask;
            tail.next=head;
        }
    }
    public void addAtPosition(int position,int taskId,String taskName,int priority,String dueDate){
        if(position<=1){
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newtask=new Task(taskId, taskName, priority, dueDate);
        Task temp=head;
        for(int i=1;i<position-1 && temp.next!=head;i++){
            temp=temp.next;
        }
        newtask.next=temp.next;
        temp.next=newtask;
        if(temp==tail){
            tail=newtask;
        }
    }
    public void removeTask(int taskId){
        if(head==null) return;
        Task current=head,prev=tail;
        do{
            if(current.taskId==taskId){
                if(current==head){
                    head=head.next;
                    tail.next=head;
                }else{
                    prev.next=current.next;
                    if(current==tail){
                        tail=prev;
                    }
                }
                System.out.println("Task ID: "+taskId+" removed");
                return;
            }
            prev=current;
            current=current.next;
        }while(current!=head);
        System.out.println("Task "+taskId+" not found");
    }
    public void displayTasks(){
        if(head==null){
            System.out.println("No tasks to display");
            return;
        }
        Task temp=head;
        do{
            System.out.println("Task Id: "+temp.taskId+", Task Name: "+temp.taskName+", Priority: "+temp.priority+", Due Date: "+temp.dueDate);
            temp=temp.next;
        }while(temp!=head);
    }
    public void displayCurrentTask(){
        if(currenTask==null){
            currenTask=head;
        }
        if(currenTask!=null){
            System.out.println("Current Task:");
            currenTask.displayTask();
        }
        else{
            System.out.println("No Tasks available");
        }
    }
    public void moveToNextNode(){
        if(currenTask==null && head!=null){
            currenTask=head;
        }else if(currenTask!=null){
            currenTask=currenTask.next;
        }
        displayCurrentTask();
    }
    public void searchByPriority(int priority){
        if(head==null){
            System.out.println("No Tasks Available");
            return;
        }
        boolean found=false;
        Task temp=head;
        do{
            if(temp.priority==priority){
                found=true;
                temp.displayTask();
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found) System.out.println("Task with priority "+priority+" not found");
    }

    public static void main(String[] args) {
        TaskScheduler tasks=new TaskScheduler();
        tasks.addAtEnd(101, "Write Report", 2, "2025-04-15");
        tasks.addAtBeginning(102, "Prepare Slides", 1, "2025-04-10");
        tasks.addAtPosition(2, 103, "Email Client", 3, "2025-04-12");
        tasks.displayTasks();
        tasks.searchByPriority(2);
        tasks.displayCurrentTask();
        tasks.moveToNextNode();
        tasks.moveToNextNode();
        tasks.removeTask(102);
        tasks.displayTasks();
    }
}