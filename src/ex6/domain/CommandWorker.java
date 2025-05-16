package ex6.domain;

import ex5.domain.Command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Клас Worker Thread для асинхронного виконання команд.
 */
public class CommandWorker extends Thread {

    private final BlockingQueue<Command> commandQueue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    /**
     * Додає команду в чергу на виконання.
     * @param command команда для виконання
     */
    public void submitCommand(Command command) {
        commandQueue.offer(command);
    }

    /**
     * Зупинка потоку.
     */
    public void shutdown() {
        running = false;
        this.interrupt();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Command cmd = commandQueue.take(); // чекаємо команду
                cmd.execute();
            } catch (InterruptedException e) {
                // Якщо вимкнули - вийти з циклу
                if (!running) break;
            }
        }
    }
}
