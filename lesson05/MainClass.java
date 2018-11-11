public class MainClass {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    private static void method1()
    {
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private  static  void method2()
    {

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        MyThread th1 = new MyThread(a1);
        th1.start();

        MyThread th2 = new MyThread(a2);
        th2.start();

        while (th1.isAlive()||th2.isAlive())
        {
        }

        System.arraycopy(th1.getArr(), 0, arr, 0, h);
        System.arraycopy(th2.getArr(), 0, arr, h, h);

    }

    public static void main(String[] arg)
    {
        long a = System.currentTimeMillis();
        method1();
        System.out.println(System.currentTimeMillis() - a);

        a = System.currentTimeMillis();
        method2();
        System.out.println(System.currentTimeMillis() - a);

    }
}

class MyThread extends Thread {
    private float[] arr;

    public float[] getArr()
    {
        return arr;
    }

    public MyThread(float[] arr) {
        super();
        this.arr=arr;
    }

    @Override
    public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
    }
}
