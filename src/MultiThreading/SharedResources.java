package MultiThreading;

public class SharedResources {

    public  volatile Boolean flag = false;
    //Volatile Resources Where we use shared memory and it directly call the main memory
    //to check if the variable is free to use or not check --> Thread Diagram.


    public  Boolean getFlag() {
        return flag;
    }

    public  void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
