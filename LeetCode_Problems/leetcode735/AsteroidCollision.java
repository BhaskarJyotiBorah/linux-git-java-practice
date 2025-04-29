
import java.util.Stack;

public class AsteroidCollision{
    public static void main(String [] args){
        int [] arr = {-5, 10, 2};
    }
    public static int [] asteroidCollision(int [] asteroid){
        //Generate a Stack to store the asteroids
        Stack<Integer> stack = new Stack<>();

        for(int num: asteroid){
            boolean alive = true; //Entry condition of an asteroid to the stack
            while(!stack.isEmpty() && num<0 && stack.peek()>0){
                
                int top = stack.peek();

                if(Math.abs(num)>Math.abs(top)){ //If absolute val current asteroid is larger, we pop out the top.
                    stack.pop();
                }else if(Math.abs(num)==Math.abs(top)){ //if both becomes equal we are going to pop the top and not include the num(current asteroid)
                    stack.pop();
                    alive = false;
                    break;
                }else{
                    alive = false; // abs(top)>abs(num) we going to mark alive as false(this helps not to put the 'num' asteroid on top of 'top')
                    break;
                }
            }
            if(alive){ // only if alive is true, we shall push our asteroid. that means the directions should be either ++ or --
                stack.push(num);
            }

        }
    }

}
