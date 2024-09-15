class Simulate{
    Gate x1;
    Gate x2;
    Gate x3;
    Gate x4;
    char result;
    char[][] possible_results = {{'B','C'},{'C','D'},{'D','E'}};
    int results_num;
    String output = "";

    Simulate(Gate x1, Gate x2, Gate x3, Gate x4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }

    String run(String default_states, String input){
        //assuming "XXXX" format string for default states
        x1.setState(default_states.charAt(0));
        x2.setState(default_states.charAt(1));
        x3.setState(default_states.charAt(2));
        x4.setState(default_states.charAt(3));

        String output = this.get_states();

        //run simulation
        for(int i=0;i<input.length();i++){
            output = output + "->";

            Gate current_gate;
            int current = Integer.parseInt(String.valueOf(input.charAt(i)));
            char next_transition = this.x1.getState();

            //first, go through gate X1
            if(next_transition == 'L'){
                current_gate = x2;
                this.results_num = 0;
            } else if (next_transition == 'C') {
                current_gate = x3;
                this.results_num = 1;
            } else {
                current_gate = x4;
                this.results_num = 2;
            }

            //change gate X1 after we pass it
            x1.change(current);

            //determine which result
            if(current_gate.getState() == 'L'){
                this.result = this.possible_results[this.results_num][0];
            } else if(current_gate.getState() == 'R'){
                this.result = this.possible_results[this.results_num][1];
            }

            //change gate X2-X4
            current_gate.change(current);
            
            output = output + this.get_states();
        }
        output = output + " " +  Character.toString(this.result);
        return output;
    }

    //string of states of every gate
    String get_states(){
        String output = "";
        output = output + Character.toString(this.x1.getState());
        output = output + Character.toString(this.x2.getState());
        output = output + Character.toString(this.x3.getState());
        output = output + Character.toString(this.x4.getState());
        return output;
    }
}