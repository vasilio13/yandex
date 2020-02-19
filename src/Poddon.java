/*
 На складе Яндекс.Маркета есть n разных поддонов. У каждого поддона есть длина и ширина. Поддоны можно поворачивать на 90 градусов.

Поддон p можно поставить на поддон q, только если p целиком помещается на q. Это означает, что длина и ширина поддона p должны быть строго меньше длины и ширины поддона q.

Найдите количество поддонов, которые нельзя поставить ни на один другой поддон.

Формат ввода
Первая строка содержит одно целое число n (2≤n≤300000) — количество поддонов на складе.

Следующие n строк содержат по два целых числа wi и hi (1≤wi,hi≤109) — ширина и длина i-го поддона соответственно.
Формат вывода
Выведите одно целое число — количество поддонов, которые нельзя поставить ни на один другой.
Пример
Ввод 	Вывод

4
1 4
3 2
5 5
2 6



2

Примечания
Разберём пример из условия:

    Первый поддон можно поставить на третий и четвёртый поддон, не переворачивая.
    Второй поддон можно поставить на третий поддон.
    Третий поддон нельзя поставить ни на один другой поддон, так как у всех других поддонов минимальная координата меньше 5.
    Четвёртый поддон нельзя поставить ни на один другой поддон, так как у всех других поддонов максимальная координата меньше 6.



*/
import java.io.*;
import java.util.ArrayList;


class Pod {
   Long min;
   Long max;
}

public class Poddon {


    public Poddon() throws FileNotFoundException {
    }


    public static void main(String[] args) throws IOException {
        Long w;
        Long h;
        int counter = 0;
        ArrayList<Pod> PA = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // Scanner sc = new Scanner(new File("input.txt"));
        //while (sc.hasNext()) {
        //  int x = sc.nextInt();
        //...
        int lines = Integer.parseInt(br.readLine());
        //  System.out.println("lines " + lines);


        for (int l = 0; l < lines; l++) {
           Pod p = new Pod();
            // System.out.println(l);
            String s = "";
            s = br.readLine();
            //System.out.println(s);
            String[] words = s.split(" ");
            //System.out.println(words[0] + " " + words[1]);
            w = Long.parseLong(words[0]);
            h = Long.parseLong(words[1]);
            if (w > h) {
                p.max = w;
                p.min = h;
            } else if (w < h) {
                p.min = w;
                p.max = h;
            } else  {
                p.min = w;
                p.max = h;
            }


            PA.add(l, p);
        }
        Long maxMIN = PA.get(0).min;
        Long maxMAX = PA.get(0).max;
        Pod countP = PA.get(0);
        for (int l = 0; l < lines; l++) {
            countP = PA.get(l);
            if (countP.max > maxMAX) {
                maxMAX = countP.max;
            }
            if (countP.min > maxMIN) {
                maxMIN = countP.min;
            }
        }
        // System.out.println("maxMIN=" + maxMIN);
        //System.out.println("maxMAX=" + maxMAX);
        counter = 0;
        for (int l = 0; l < lines; l++) {
            countP = PA.get(l);
            if ((countP.max.equals(maxMAX)) || (countP.min.equals(maxMIN))) {
                counter++;
                //      System.out.println("l="+l+"counter="+counter);
            }

        }
        //       System.out.println(PA.get(3).min+" "+PA.get(3).max);
      //  System.out.println(counter);
        String c1 = Integer.toString(counter);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write(c1);
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}

/*Pod tekP=PA.get(0);
        Pod countP=tekP;
        for(int l=0;l<lines;l++ ) {
         countP = PA.get(l);
         if (
                 ((countP.w>tekP.w)&&(countP.h>tekP.h)) ||
                         ((countP.w>tekP.h)&&(countP.h>countP.w))

         ) {
             counter++;
             tekP=countP;
         }
            System.out.println("counter "+counter);
            System.out.println("countP.w "+countP.w);
            System.out.println("countP.h "+countP.h);
            System.out.println("tekP.w "+tekP.w);
            System.out.println("tekP.h "+tekP.h);
            System.out.println(l+" "+PA.get(l).w+" "+PA.get(l).h);
         }

*/


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






