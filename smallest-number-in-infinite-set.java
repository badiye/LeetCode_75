import java.util.TreeSet;

class SmallestInfiniteSet {

    private TreeSet<Integer> set;
    private int next;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        next = 1;
    }
    
    public int popSmallest() {
        if (set.isEmpty()) {
            int result = next;
            next++;
            return result;
        } else if (set.first() < next) {
            int result = set.first();
            set.remove(result);
            return result;
        } else {
            int result = next;
            next++;
            return result;
        }
    }
    
    public void addBack(int num) {
        if (num < next) {
            set.add(num);
        }
    }
}
