package other;

public class Wms {
    /*
    Задача на wms:
        Задано рекуррентное соотношение
        f(n) =  f(n+3) - f(n+2)
        f(1) = 1
        f(2) = 2
        f(3) = 3
        Написать программу вычисляющую сумму первых 100 элементов последовательности.
        Ответом должен быть архив с кодом и значение вычисленной суммы поделенное по модулю на 10000.

        ответ мне нужно будет направить в виде документа и назвать число которое получилось.
     */
    /*
            f(n+3) = f(n+2) + f(n)
     */
    public static void main(String[] args) {
        Wms wms = new Wms();
        wms.doWms();
    }

    public void doWms(){
        long[] longs = new long[100];
        longs[0] = 1;
        longs[1] = 2;
        longs[2] = 3;
        for (int i = 3; i < longs.length - 3; i++) {
            long x = longs[i-3] + longs[i-1];
            longs[i] = x;
        }
        long x = 0;
        for (int i = 0; i < longs.length; i++){
            System.out.println(longs[i] + ", ");
            x = x + longs[i];
        }

        long result = x / 10000;
        System.out.println("result: " + result);
    }
}
