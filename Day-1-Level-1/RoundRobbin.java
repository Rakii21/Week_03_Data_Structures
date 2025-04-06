class Process{
    String processId;
    int burstTime;
    int remainingTime;
    int priority;
    int turnAroundTime=0;
    int waitingTime=0;
    Process next;
    public Process(String processId,int burstTime,int priority){
        this.processId=processId;
        this.burstTime=burstTime;
        this.remainingTime=burstTime;
        this.priority=priority;
        this.next=null;
    }
}
public class RoundRobbin {
    private Process head=null;
    private Process tail=null;

    public void addProcess(Process newProcess){
        if(head==null){
            head=tail=newProcess;
            tail.next=head;
        }
        else{
            tail.next=newProcess;
            newProcess.next=head;
            tail=newProcess;
        }
    }
    private boolean hasRemainingProcess(){
        Process temp=head;
        do{
            if(temp.remainingTime>0){
                return true;
            }
            temp=temp.next;
        }while(temp!=head);
        return false;
    }
    public void simulateRoundRobin(int timeQuantum){
        Process current = head;
        int time=0;
        while(hasRemainingProcess()){
            if(current.remainingTime>0){
                int executeTime= Math.min(current.remainingTime,timeQuantum);
                time+=executeTime;
                current.remainingTime-=executeTime;
                if(current.remainingTime==0){
                    current.turnAroundTime=time;
                    current.waitingTime=current.turnAroundTime-current.burstTime;
                    System.out.println("Process "+current.processId+" completed");
                }
                else System.out.println("Process "+current.processId+" executed for "+executeTime+" units. Remaining: "+current.remainingTime);
            }
            current=current.next;
        }
        printMetrics();

    }
    private void printMetrics() {
        Process temp = head;
        int totalWT = 0, totalTAT = 0, count = 0;
        System.out.println("\n--- Final Metrics ---");
        do {
            System.out.println("Process " + temp.processId + ": Waiting Time = " + temp.waitingTime + ", Turnaround Time = " + temp.turnAroundTime);
            totalWT += temp.waitingTime;
            totalTAT += temp.turnAroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (float) totalWT / count);
        System.out.println("Average Turnaround Time: " + (float) totalTAT / count);
    }

    public void displayProcesses() {
        Process temp = head;
        if (temp == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("\n--- Current Process Queue ---");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Remaining: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
    public static void main(String[] args) {
        RoundRobbin scheduler = new RoundRobbin();

        scheduler.addProcess(new Process("P1", 10, 2));
        scheduler.addProcess(new Process("P2", 5, 1));
        scheduler.addProcess(new Process("P3", 8, 3));

        scheduler.displayProcesses();
        scheduler.simulateRoundRobin(4);
    }
}


