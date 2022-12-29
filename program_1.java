package Java.Java_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class program_1 {
    public static void main(String[] args) {
        Equation();
    }
    public static int GetNumber(){
        Scanner numberS = new Scanner(System.in);
        int number;
        while(true){
            try{
                System.out.println("Введите число");
                number = numberS.nextInt();
                break;
            }
            catch(Exception e){
                System.out.println("Ошибка ввода");
            }

        }
        numberS.close();
        return number;
    }
    public static String GetString(){
        Scanner str = new Scanner(System.in);
        String equation;
        System.out.println("Введите формулу");
        equation = str.nextLine();
        return equation;

    }
    public static void Equation(){
        Map<String,Integer> states = new HashMap<String, Integer>();
        states.put("0", 0);
        Scanner str = new Scanner(System.in);
        String equation = GetString();
        equation = String.format(equation.replace(" ",""));
        String[] st = equation.split("\\+");
        int count = 0;
        for (int i = 0; i < st.length; i++){
            String tmp = st[i];
            for(int j = 1; j < st.length; j++){
                if (st[j] == tmp){
                    st[j] = tmp + count;
                }
                count++;
            }
        }
        int sum = 0;
        for (int i = 0; i < st.length; i++){
            for (Map.Entry<String, Integer> item : states.entrySet()){
                if (item.getKey() != st[i]){
                    states.put(st[i], str.nextInt());
                    break;
                }
            }
        }
        for(Map.Entry<String, Integer> item : states.entrySet()){
            sum += item.getValue();
        }
        str.close();
        System.out.println(sum);
    }

    
}
