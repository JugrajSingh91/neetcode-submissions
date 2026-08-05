class Solution {
    class Car {
        int position;
        double timeNeeded;
        public Car(int position, int target, int speed) {
            this.timeNeeded = (double) (target - position) / speed;
            this.position = position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], target, speed[i]);
        }
        // Sort the cars in desc order of position.
        Arrays.sort(cars, (a,b) -> {
            return Integer.compare(b.position, a.position);
        });

        // iterate the car array and find time for every car to reach the target
        // timeNeeded = (target - position)/speed
        // two cars will form a fleet if timeNeeded for car[i] is >= timeNeeded for car[i+1]
        int fleet = 0;
        double maxTime = 0.0;

        for (Car car: cars) {
            if (car.timeNeeded > maxTime) {
                fleet++;
                maxTime = car.timeNeeded;
            }
        }

        return fleet;
    }
}
