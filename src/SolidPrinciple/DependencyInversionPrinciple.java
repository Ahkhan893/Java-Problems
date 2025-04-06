package SolidPrinciple;


// Violating DIP
//class LightBulb {
//    void turnOn() {}
//    void turnOff() {}
//}
//
//class Switch {
//    private LightBulb bulb = new LightBulb();
//
//    void operate() {
//        bulb.turnOn();
//    }
//}

// Applying DIP
//High-level modules should not depend on low-level modules. Both should depend on abstractions.
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {}
    public void turnOff() {}
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}

public class DependencyInversionPrinciple {
}
