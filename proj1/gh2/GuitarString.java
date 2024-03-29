package gh2;

// import deque.Deque;

import deque.ArrayDeque;
import deque.Deque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    private int size;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your should initially fill your buffer array with zeros.
        this.size = Long.valueOf(Math.round(SR / frequency)).intValue();
        buffer = new ArrayDeque<>();

        for (int i = 0; i < this.size; i++) {
            buffer.addFirst(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.


        for (int i = 0; i < this.size; i++) {

            double r = Math.random() - 0.5;
            this.buffer.removeLast();
            this.buffer.addFirst(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       **Do not call StdAudio.play().**
        //将前面的样本出队，并将一个新样本排入队列，该样本是两者的平均值乘以 DECAY 因子
        Double first = this.buffer.removeFirst();
        Double second = this.buffer.get(0);
        Double newValue = (first + second) * this.DECAY / 2;
        this.buffer.addLast(newValue);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // : Return the correct thing.
        return this.buffer.get(0);
    }
}
