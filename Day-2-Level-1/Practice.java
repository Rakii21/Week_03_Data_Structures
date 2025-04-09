import java.util.Arrays;

public class Practice {
    public static String[][] anagramMatch(String[] words){
        int n=words.length;
        String[][] result=new String[n][n];
        int groupcount=0;
       
        for(int i=0;i<n;i++){
            String currentWord=words[i];
            char[] chars=currentWord.toCharArray();
            Arrays.sort(chars);
            String sortedWord= new String(chars);
            boolean groupmatch=false;
            for(int j=0;j<groupcount;j++){
                if(result[j][0]!=null && result[j][0].equals(sortedWord)){
                    int k=0;
                    while(result[j][k]!=null){
                        k++;
                    }
                    result[j][k]=currentWord;
                    groupmatch=true;
                    break;
                }
            }
            if(!groupmatch){
                result[groupcount][0]=sortedWord;
                result[groupcount][1]=currentWord;
                groupcount++;
            }
        }
        String[][] output=new String[groupcount][n];
        for(int i=0;i<groupcount;i++){
            int count=0;
            while(result[i][count]!=null){
                count++;
            }
            output[i]=new String[count-1];
            for(int j=0;j<count-1;j++){
                output[i][j]=result[i][j+1];
            }
        }
        return output;
    }
    public static void main(String args[]){
        String[] words={"eat","tea","tan","ate","nat","bat"};
        String[][] result=anagramMatch(words);
        for(String[] group:result){
            System.out.println(Arrays.toString(group));
        }
    }
}