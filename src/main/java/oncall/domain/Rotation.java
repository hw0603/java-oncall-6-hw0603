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

    public Developer popOrig() {
        return queue.poll();
    }

    public Developer pop() {
        if (buffer.isEmpty()) {
            return queue.poll();
        }
        return buffer.poll();
    }

    public void bufferadd(Developer developer) {
        buffer.add(developer);
    }
}
