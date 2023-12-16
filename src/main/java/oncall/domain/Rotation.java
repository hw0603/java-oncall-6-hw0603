package oncall.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Rotation {
    Queue<Developer> queue = new LinkedList<>();
    Queue<Developer> buffer = new LinkedList<>();
    Developer lastWorker = null;

    public void add(Developer developer) {
        queue.add(developer);
    }

    public Developer pop() {
        if (queue.isEmpty()) {
            queue.addAll(buffer);
            buffer.clear();
        }
        return queue.poll();
    }
}
