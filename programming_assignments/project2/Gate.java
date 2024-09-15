public class Gate{
    char state;
    Gate[] gates;
    int type;

    Gate(){
        this.state = 'L';
        this.type = 0;
    }

    Gate(int type){
        this.state = 'L';
        this.type = 1;
    }

    char getState(){
        return this.state;
    }

    void setState(char s){
        this.state = s;
    }

    void change(int x){
        if(this.type == 0){
            if(this.state=='L'){
                this.state='R';
            } else {
                this.state='L';
            }
        } else {
            //if gate X1
            if (x==1){
                if (this.state == 'L'){
                    this.state = 'R';
                } else if (this.state == 'R'){
                    this.state = 'C';
                } else {
                    this.state = 'L';
                }
            } else {
                if (this.state == 'L'){
                    this.state = 'C';
                } else if (this.state == 'C'){
                    this.state = 'R';
                } else {
                    this.state = 'L';
                }
            }
        }
    }
}