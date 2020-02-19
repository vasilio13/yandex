import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class pod {
    Integer w;
    Integer h;
}

public class Poddon {






    public Poddon() throws FileNotFoundException {
    }


    public static void main(String[] args) throws IOException {
        int counter = 0;
        ArrayList<pod> PA = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
       // Scanner sc = new Scanner(new File("input.txt"));
        //while (sc.hasNext()) {
        //  int x = sc.nextInt();
        //...
        int lines = Integer.parseInt(br.readLine());
        System.out.println("lines "+lines);
        pod p = new pod();
//набивает одинаковыми значениями
        for(int l=0;l<lines;l++ ) {
            System.out.println(l);
            String s="";
            s=br.readLine();
            System.out.println(s);
                String[] words = s.split(" ");
            System.out.println(words[0]+" "+words[1]);
                p.w = Integer.parseInt(words[0]);
                p.h = Integer.parseInt(words[1]);
            PA.add(l,p);
        }

pod tekP=PA.get(0);
        pod countP=tekP;
        for(int l=0;l<lines;l++ ) {
         countP = PA.get(l);
         if ((countP.w>tekP.w)&&(countP.h>tekP.h)) {
             counter++;
             tekP=countP;
         }
            System.out.println("counter "+counter);
            System.out.println("countP.w "+countP.w);
            System.out.println("countP.h "+countP.h);
            System.out.println("tekP.w "+tekP.w);
            System.out.println("tekP.h "+tekP.h);
            System.out.println(PA.get(l).w+" "+PA.get(l).h);
         }


        }

/*
        String s;
        while((s=br.readLine())!=null){
            String[] words = s.split(" ");
            int a = Integer.parseInt(words[0]);
            int b = Integer.parseInt(words[1]);
      //      PA.add(s);
        }
     //   long a = sc.nextInt();
      //  long b = sc.nextInt();
      //  long c = a+b;
       // String c1 = Long.toString(c);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
     //   bufferedWriter.write(c1);
        bufferedWriter.flush();
        bufferedWriter.close(); */

    }




