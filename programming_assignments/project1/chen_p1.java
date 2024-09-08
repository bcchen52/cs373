import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class chen_p1{
    public static void main(String[] args){
        //output as array of characters because its easier to manipulate and mimic the blank spaces cuz u can add elements
        ArrayList<Character> output = new ArrayList<Character>();
        for(int i=0; i<args[1].length();i++){
            output.add(args[1].charAt(i));
        }

        //array of accept and reject states
        ArrayList<Integer> accept = new ArrayList<Integer>();
        ArrayList<Integer> reject = new ArrayList<Integer>();

        //HashMap w array of strings, so each state can have multiple transitions associated
        HashMap<Integer, String[]> transitions = new HashMap<Integer, String[]>();
        
        int current_state = 0;
        int max_transitions = Integer.parseInt(args[2]); 
        int current_pos = 0;
        int transition_num = 0;

        //read the files and populate
        try {
            //generic Scanner and File readers
            File myobj = new File(args[0]);
            Scanner myReader = new Scanner(myobj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] data2 = data.split("\\s+", -1);

                //states
                if(data2[0].contains("state")){
                    if(data2.length==3){
                        if(data2[2].contains("accept")){
                            accept.add(Integer.parseInt(data2[1]));
                        } else if (data2[2].contains("reject")){
                            reject.add(Integer.parseInt(data2[1]));
                        } else {
                            current_state = Integer.parseInt(data2[1]);
                        }
                    }
                } else {
                    //transitions
                    String info = "";
                    for(int i=1;i<data2.length;i++){
                        info = info + data2[i];
                    }
                    //if there is already a transition for this state, add it to the HashMap array
                    if(transitions.get(Integer.parseInt(data2[1]))!=null){
                        String[] previous = transitions.get(Integer.parseInt(data2[1]));
                        String[] infos = new String[previous.length+1];
                        for (int i = 0;i<previous.length;i++){
                            infos[i] = previous[i];
                        }
                        infos[previous.length] = info;
                        transitions.put(Integer.parseInt(data2[1]), infos);
                    } else {
                        //create HashMap value for state
                        String[] infos = {info};
                        transitions.put(Integer.parseInt(data2[1]), infos);
                    }
                }
            }
        myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file not found :'(");
            return;
        }

        while (transition_num<max_transitions){
            //doing the transitions
            //accept
            for (int i: accept){
                if (i==current_state){
                    String formatted_output = "";
                    for(int k=current_pos; k<output.size();k++){
                        formatted_output = formatted_output + output.get(k);
                    }
                    System.out.println(formatted_output + " accept\n");
                    return;
                }
            }
            //reject
            for (int i: reject){
                if (i==current_state){
                    String formatted_output = "";
                    for(int k=current_pos; k<output.size();k++){
                        formatted_output = formatted_output + output.get(k);
                    }
                    System.out.println(formatted_output + " reject\n");
                    return;
                }
            }

            //get transition for the state
            String[] possible_transitions = transitions.get(current_state);
            
            //no transitions for state
            if (possible_transitions == null){
                String formatted_output = "";
                for(int k=current_pos; k<output.size();k++){
                    formatted_output = formatted_output + output.get(k);
                }
                System.out.println(formatted_output + " reject\n");
                return;
            }

            //get transition for the symbol at that state
            String transition = "";

            for (String i : possible_transitions){
                //if its not blank, check output string
                if (current_pos<output.size()){
                    if (i.charAt(1) == output.get(current_pos)){
                        transition = i;
                    }
                } else {
                    //if position is outside of current tape, it can only have blank state
                    if (i.charAt(1) == '_'){
                        transition = i;
                    }
                }
            }

            //no symbol
            if (transition.length() == 0){
                String formatted_output = "";
                for(int k=current_pos; k<output.size();k++){
                    formatted_output = formatted_output + output.get(k);
                }
                System.out.println(formatted_output + " reject\n");
                return;
            }

            //write to tape
            if (transition.charAt(1) != '_'){
                output.set(current_pos, transition.charAt(3)); 
            } else {
                output.add(transition.charAt(3));
            }

            //change state
            current_state = Character.getNumericValue(transition.charAt(2));
            
            //move head
            if(transition.charAt(4)=='L'){
                current_pos --;
            } else if (transition.charAt(4)=='R'){
                current_pos ++;
            }
            
            transition_num++;
        }

        String formatted_output = "";
        for(int k=current_pos; k<output.size();k++){
            formatted_output = formatted_output + output.get(k);
        }
        System.out.println(formatted_output + " quit\n");
        return;
    }
}