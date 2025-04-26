package MultiThreading.ThreadMethods;

class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
//            String a = "";
//            for (int j = 0; j < 100000000; j++) {
//                a+="a";
//
//            }
            System.out.println(Thread.currentThread().getName() + " - Priority: "+Thread.currentThread().getPriority() + "- count: "+i);
            try{
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Low Priority Thread");
        MyThread t2 = new MyThread("Medium Priority Thread");
        MyThread t3 = new MyThread("High Priority Thread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.join();
        t1.start();
        t2.start();
        t3.start();
    }
}
