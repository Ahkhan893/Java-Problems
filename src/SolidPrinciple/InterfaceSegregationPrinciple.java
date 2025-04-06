package SolidPrinciple;


// Violating ISP
interface Worker {
    void work();
    void eat();
}
// -------> Voilate the Interface principle <-------
//class HumanWorker implements Worker {
//    public void work() {}
//    public void eat() {}
//}
//
//class RobotWorker implements Worker {
//    public void work() {}
//    public void eat() {
//        throw new UnsupportedOperationException("Robots don't eat");
//    }
//}

//Clients should not be forced to implement interfaces they don't use.

// Applying ISP
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    public void work() {}
    public void eat() {}
}

class RobotWorker implements Workable {
    public void work() {}
}

public class InterfaceSegregationPrinciple {
}
