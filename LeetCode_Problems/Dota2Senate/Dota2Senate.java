public class Dota2Senate {
    public static void main(String[] args) {
        String s = "RDD";
    }
    public static String predictPartyVictory(String senate){
        int n = senate.length(); //Noting the length of senate
        Queue<Integer> radiant = new LinkedList<>(); //This will store all the radiants
        Queue<Integer> dire = new LinkedList<>(); //This will store all the dires


        // First we are going to put all the indices of Radient and Dire from senate string to their respective queues
        for(int i = 0; i<n; i++){
            if(Senate.charAt(i)=='R'){
                radiant.offer(i); // if the char at i is R then store it in radient
            }else {
                dire.offer(i); // else store in dire
            }
        }

        // Then we simulate the rounds
        while(!radiant.isEmpty() && !dire.emtpy()){
            int rIndex = radiant.poll(); // first element of radiant (first index in this example)
            int dIndex = dire.poll(); //first element of dire (second index in this example)

            if(rIndex<dIndex){
                //Radient survives and bans dire, and gets spawned at index rIndex + n
                radiant.offer(rIndex+n);

            }else{
                //dire survives and bans Radiant, and gets spawned at the index dIndex + n
                dire.offer(dIndex+n);
            }
        }
        return  radiant.isEmpty()? "Dire":"Radient"; //which ever is empty lost
    }
}