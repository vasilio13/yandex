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

public class Pallets {

    public class Pod {
        Long min;// поддоны сортируются по
        Long max;//
    }

    public static class Data {
        int lines;
        ArrayList<Pod> warehouse;
    }



    private Data readWarehouse() throws IOException {
        Long w;
        Long h;

        ArrayList<Pod> warehouse = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int lines = Integer.parseInt(br.readLine());


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


            warehouse.add(l, p);
        }
        Data data = new Data();
        data.lines = lines;
        data.warehouse = warehouse;
        return (data);

    }


    public static void main(String[] args) throws IOException {
        /*
        readWarehouse;
        calculate;
        saveResult;
        */
        Pallets pallets = new Pallets();
        Data temp = new Data();
        temp=pallets.readWarehouse();

        int counter = pallets.calculate(temp.lines, temp.warehouse);

        String result = Integer.toString(counter);

        pallets.saveResult(result);



    }

    Integer calculate (int lines, ArrayList<Pod> warehouse ) {

        Long maxMIN = warehouse.get(0).min;
        Long maxMAX = warehouse.get(0).max;
        Pod countP = warehouse.get(0);
        for (int l = 0; l < lines; l++) {
            countP = warehouse.get(l);
            if (countP.max > maxMAX) {
                maxMAX = countP.max;
            }
            if (countP.min > maxMIN) {
                maxMIN = countP.min;
            }
        }
        // System.out.println("maxMIN=" + maxMIN);
        //System.out.println("maxMAX=" + maxMAX);
        int counter = 0;
        for (int l = 0; l < lines; l++) {
            countP = warehouse.get(l);
            if ((countP.max.equals(maxMAX)) || (countP.min.equals(maxMIN))) {
                counter++;
                //      System.out.println("l="+l+"counter="+counter);
            }

        }
        //       System.out.println(warehouse.get(3).min+" "+warehouse.get(3).max);
        //  System.out.println(counter);

        return counter;
    }

    void saveResult (String result) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write(result);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}








