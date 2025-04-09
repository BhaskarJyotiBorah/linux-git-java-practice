public class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i<1000; i++){  //Normal run method
            counter.increment();  //We increment the count by accessing the increment() method from Counter class
        }
    }
        private Counter counter; //Created an instance variable of Counter type whose name is counter

        public MyThread(Counter counter){ //Created a constructor for MyThread which takes Counter as an argument
            this.counter = counter; 
        }                                     
}
