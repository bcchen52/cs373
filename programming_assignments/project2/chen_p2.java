//4 chutes, string of 1 and 0, 010101...., st. each number is a marble.
//as the marble goes down

public class chen_p2{
    public static void main(String[] args){
        Gate one = new Gate(1);
        Gate two = new Gate();
        Gate three = new Gate();
        Gate four = new Gate();
        Simulate sim = new Simulate(one, two, three, four);
        System.out.println(sim.run(args[0], args[1]));
    }
}