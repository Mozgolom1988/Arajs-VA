public class Main {

    static final int size = 10000000;
    static final int h    = size / 2;

    public static void main(String[] args) {

        //Метод 1: расчеты в одном потоке
        first_metod();

        //Метод 2: расчеты в двух потоках
        second_metod();

    }

    private static void first_metod() {

        float[] arr = new float[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for(int i=0;i<arr.length;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Метод 1: " + (System.currentTimeMillis() - a) + "мс");

    }

    private static void second_metod() {

        float[] arr = new float[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        //Разбивка на 2 массива:
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        //Выполнение расчетов в двух потоках
        MyThread t1 = new MyThread(a1);
        MyThread t2 = new MyThread(a2);

        try {
            //ожидание завершения двух потоков и склеивание результатов
            t1.join();
            t2.join();
            System.arraycopy(t1.getArr(), 0, arr, 0, h);
            System.arraycopy(t2.getArr(), 0, arr, h, h);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Метод 2: " + (System.currentTimeMillis() - a) + "мс");



    }


}
