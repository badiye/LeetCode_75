class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        for (int asteroid : stack) {
            result[i++] = asteroid;
        }
        
        return result;
    }
}