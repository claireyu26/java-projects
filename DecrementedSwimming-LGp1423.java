public class Main {
    public static void main(String[] args) {
        // 11/2/24
        // Xiaoyu was swimming happily, but she soon found out sadly that she was not
        // strong enough and swimming was very tiring. It is known that Xiaoyu can swim
        // in the first step
        // 2 meters, but as she became more and more tired and her strength became less
        // and less, she could only swim the distance of the previous step with each
        // subsequent step.
        // 98%. Now Xiaoyu wants to know, if you want to swim the distance s,
        // How many steps does she need to swim to reach s meters? Please program to
        // solve this problem.

        System.out.println(numOfSteps(4.3)); // should be 3
    }

    static Integer numOfSteps(double distance) {
        int steps = 0;
        double yuDistance = 0;
        while (yuDistance < distance) {
            yuDistance += (2 * Math.pow(0.98, steps));
            steps += 1;
        }
        return steps;
    }
}

