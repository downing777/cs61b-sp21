public class Dog {
    private int size;

    public Dog(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static Dog[] largerThanFourNeighbors(Dog[] dogs) {
        // List to hold dogs larger than their neighbors
        java.util.List<Dog> resultList = new java.util.ArrayList<>();

        for (int i = 0; i < dogs.length; i++) {
            // Get the size of the current dog
            int currentSize = dogs[i].getSize();
            boolean isLarger = true;

            // Check the left neighbors (up to 2)
            for (int j = Math.max(0, i - 2); j < i; j++) {
                if (dogs[j].getSize() >= currentSize) {
                    isLarger = false;
                    break;
                }
            }

            // Check the right neighbors (up to 2)
            for (int j = i + 1; j <= Math.min(i + 2, dogs.length - 1); j++) {
                if (dogs[j].getSize() >= currentSize) {
                    isLarger = false;
                    break;
                }
            }

            // If current dog is larger than all neighbors
            if (isLarger) {
                resultList.add(dogs[i]);
            }
        }

        // Convert the list to an array and return
        return resultList.toArray(new Dog[0]);
    }

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(10),
                new Dog(20),
                new Dog(30),
                new Dog(25),
                new Dog(20),
                new Dog(40),
                new Dog(10)
        };

        Dog[] result = largerThanFourNeighbors(dogs);
        for (Dog dog : result) {
            System.out.println(dog.getSize()); // Output: 30, 40
        }
    }
}
