
public class MainClass {


    public static int method (String [][] array) throws MyArraySizeException, MyArrayDataException
    {
       if ((array.length!=4))
       {
           throw new MyArraySizeException("Не верный размер массива");
       }
       int sum=0;
       for (int i=0;i<=3;i++)
       {
           for (int j=0;j<=3;j++)
           {
               try {
                   sum += Integer.parseInt(array[i][j]);
               }
               catch (NumberFormatException e)
               {
                   throw new MyArrayDataException("Не верное значение элемента массива [" + i + "]["+ j +"] = "+ array[i][j]);
               }
           }
       }

       return sum;
    }

    public static void main(String[] arg)
    {
        boolean res=false;
        int i=0;
        String[][] arr =  {{"1","1","1","1"},
                        {"1","1","1","1"},
                        {"1","2","1","1"},
                        {"1","1","1","1"}};
        try {
            i = method(arr);
            res=true;
        }
        catch (MyArraySizeException | MyArrayDataException e )
        {
            e.printStackTrace();
        }
        finally {
            System.out.println("Результат:" + (res ? i : "запуск метода закончился ошибкой"));
        }

    }

    static class MyArraySizeException extends Exception
    {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception
    {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}


