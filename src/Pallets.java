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

    public class Pallet {
        Long smaller;// меньшая сторона поддона
        Long larger;// большая сторона поддона
    }

    private ArrayList<Pallet> readWarehouse() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int lines = Integer.parseInt(br.readLine());//по условию задачи перая строка содержит число поддонов(строк)
        ArrayList<Pallet> warehouse = new ArrayList<>(lines);//

        for (int l = 0; l < lines; l++) {
            Pallet p = new Pallet();//создание нового поддона
            /*чтение строки и вычленение из нее двух long чисел*/
            String s;
            s = br.readLine();
            String[] words = s.split(" ");
            Long width = Long.parseLong(words[0]);
            Long length = Long.parseLong(words[1]);
            /*изначально поддон обладает характеристиками ширина и длина.
             * при наполнении ArrayList  каждому поддону с проверкой присваиваются
             * большая и меньшая стороны, хотя очевидно, что длина должна
             * быть больше ширины.*/
            if (width > length) {
                p.larger = width;
                p.smaller = length;
            } else {
                p.smaller = width;
                p.larger = length;
            }
            warehouse.add(l, p);
        }
        return warehouse;
    }

    public static void main(String[] args) throws IOException {

        Pallets pallets = new Pallets();
        int counter = pallets.calculate(pallets.readWarehouse());
        String result = Integer.toString(counter);
        pallets.saveResult(result);
    }

    Integer calculate (ArrayList<Pallet> warehouse ) {

        /*первая часть алгоритма находит максимальные значения меньшей и
        большей сторон поддонов в коллекции ArrayList
         */
        Long maxMIN = warehouse.get(0).smaller;
        Long maxMAX = warehouse.get(0).larger;
        int lines = warehouse.size();
        Pallet countP;
        for (int l = 0; l < lines; l++) {
            countP = warehouse.get(l);
            if (countP.larger > maxMAX) {
                maxMAX = countP.larger;
            }
            if (countP.smaller > maxMIN) {
                maxMIN = countP.smaller;
            }
        }
        /* вторая часть алгоритма, сравнивающая меньшие и большие стороны поддонов
           с максимальными значениями, и в случае равенства, увеличивает счетчик
         */
        int counter = 0;
        for (int l = 0; l < lines; l++) {
            countP = warehouse.get(l);
            if ((countP.larger.equals(maxMAX)) || (countP.smaller.equals(maxMIN))) {
                counter++;
                //      System.out.println("l="+l+"counter="+counter);
            }

        }
        return counter;
    }

    void saveResult (String result) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write(result);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}








