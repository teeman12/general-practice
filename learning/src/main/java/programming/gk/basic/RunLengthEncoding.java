package programming.gk.basic;

/**
 * Created by Nameet on 1/2/2017.
 */
public class RunLengthEncoding {

    class GfG
    {
        String encode(String str)
        {
            //aaaabbbccc
            //Your code here
            int j=0;
            StringBuilder sb = new StringBuilder();
            for(int i =0; i< str.length() ; i++){
                char c= str.charAt(i);
                if(i == str.length() - 1 || c != str.charAt(i+1)){
                    sb.append(c).append(j+1);
                    j=0;
                }
                else{
                    j++;
                }
            }

            return sb.toString();
        }

    }
}
