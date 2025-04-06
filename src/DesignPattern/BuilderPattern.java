package DesignPattern;

// Product Class
class CloudInstance {
    private String provider;
    private String instanceType;
    private int storageSize;
    private int memory;
    private boolean autoScalingEnabled;

    // Private Constructor
    private CloudInstance(Builder builder) {
        this.provider = builder.provider;
        this.instanceType = builder.instanceType;
        this.storageSize = builder.storageSize;
        this.memory = builder.memory;
        this.autoScalingEnabled = builder.autoScalingEnabled;
    }

    // Builder Class (Static Nested Class)
    public static class Builder {
        private String provider;
        private String instanceType;
        private int storageSize;
        private int memory;
        private boolean autoScalingEnabled;

        public Builder(String provider, String instanceType) {
            this.provider = provider;
            this.instanceType = instanceType;
        }

        public Builder storageSize(int storageSize) {
            this.storageSize = storageSize;
            return this;
        }

        public Builder memory(int memory) {
            this.memory = memory;
            return this;
        }

        public Builder autoScalingEnabled(boolean autoScalingEnabled) {
            this.autoScalingEnabled = autoScalingEnabled;
            return this;
        }

        public CloudInstance build() {
            return new CloudInstance(this);
        }
    }

    @Override
    public String toString() {
        return "CloudInstance [provider=" + provider + ", instanceType=" + instanceType +
                ", storageSize=" + storageSize + ", memory=" + memory +
                ", autoScalingEnabled=" + autoScalingEnabled + "]";
    }
}

// Usage
public class BuilderPattern {

    public static void main(String[] args) {
        CloudInstance instance = new CloudInstance.Builder("AWS", "t2.micro")
                .storageSize(100)
                .memory(4)
                .autoScalingEnabled(true)
                .build();

        System.out.println(instance);
    }
}

//The Builder Design Pattern is a creational design pattern that separates the construction of a complex
// object from its representation, allowing the same construction process to create different representations.
// It’s useful for creating objects with multiple optional parameters or when the object creation process is complex.


//Readable and Flexible: Fluent interface makes object creation easy to understand.
//
//Immutable Objects: Objects can be made immutable by avoiding setters.
//
//Handles Complex Objects: Ideal for creating objects with multiple fields.
//
//Method Chaining: Simplifies the creation process with chaining.