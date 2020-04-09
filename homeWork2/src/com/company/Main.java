package com.company;

public class Main {

    public static void main(String[] args) {


        //Получим матрицу 4х4: 10 3 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 0"
        try {
            String[][] matrix = getMatrix_4x4("10 3 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 0");
            readMatrix(matrix);

            //Исключения для теста 1:
            //String[][] test1 = getMatrix_4x4("10 3 1 2\\n2 3 2 2\\n5 6 7 1");

            //Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2
            int result = getSummMatrixDividedTwo(matrix);
            System.out.println("Сумма числе массива деленная на 2: "+ result);

            //Исключения для теста 2:
            //String[][] test2_M = getMatrix_4x4("10 sf 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 0");
            //int test2 = getSummMatrixDividedTwo(test2_M);

        }catch (MyArraySizeException e) {
            e.printStackTrace();
        }catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    static String[][] getMatrix_4x4(String inbox) throws MyArraySizeException  {
        String[][] matrix = new String[4][4];

        inbox = inbox.replace("\\", "");

        String[] inboxArray = inbox.split("n");
        if(inboxArray.length != 4) {throw new MyArraySizeException ("Matrix must be 4x4");}


        for (int i=0; i <inboxArray.length; i++) {

            String[] raw = inboxArray[i].split(" ");
            if (raw.length !=4) {throw new MyArraySizeException ("Matrix must be 4x4");}
            matrix[i] = raw;
        }

        return matrix;
    }

    static <ex> int getSummMatrixDividedTwo(String[][] matrix) throws MyArrayDataException{
        int summ =0;
        for (int i = 0; i < matrix.length; i++) {  //идём по строкам
            for (int j = 0; j < matrix[i].length; j++) {//идём по столбцам
                try {
                    summ += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("В матрице найдено нечисловое значение в строке " + i + " колонке " + j);
                }
            }

        }
        summ = summ/2;
        return summ;
    }

    public static class MyArraySizeException extends RuntimeException {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException  extends NumberFormatException  {
        public MyArrayDataException (String message) {
            super(message);
        }
    }

    static void readMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {  //идём по строкам
            for (int j = 0; j < matrix[i].length; j++) {//идём по столбцам
                System.out.print(" " + matrix[i][j] + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
    }

}
