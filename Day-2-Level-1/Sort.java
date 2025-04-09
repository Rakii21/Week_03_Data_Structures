import java.util.Arrays;

public class Sort{
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped=false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
                if(!swapped) break;
            }
        }
    }
    public static void insertionSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }
    }
    private static void merge(int[] arr,int left,int mid, int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] leftarr=new int[n1];
        int[] rightarr=new int[n2];
        System.arraycopy(arr, left, leftarr, 0, n1);
        System.arraycopy(arr, mid+1, rightarr, 0, n2);
        int i=0,j=0,k=left;
        while(i<n1 &&j<n2){
            if(leftarr[i]<=rightarr[j]){
                arr[k++]=leftarr[i++];
            }
            else arr[k++]=rightarr[j++];
        }
        while(i<n1) arr[k++] = leftarr[i++];
        while(j<n2) arr[k++]=rightarr[j++];
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int piv=partition(arr,low,high);
            quickSort(arr, low, piv-1);
            quickSort(arr,piv+1,high);
        }
    }
    private static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr={5,4,1,2,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}



