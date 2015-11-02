package set0192;

import java.time.Duration;
import java.time.Instant;

@SuppressWarnings("PMD.DoNotUseThreads")
/** executes runnables for a fixed amount of time */
public class TimedExecutor {

	/** @return true if runnable runs inside before the duration ends */
	public Boolean runOrTerminateIn(final Runnable runnable,
			final Duration duration) {
		final Thread thread = new Thread(runnable);
		final Instant start = start(thread);
		Boolean expired = false;
		while (true) {
			try {
				synchronized (this) {
					if (duration.compareTo(Duration.between(start,
							Instant.now())) < 0) {
						expired = true;
						break;
					}
					if (!isAlive(thread)) {
						break;
					}
					Thread.sleep(10);
				}
			} catch (InterruptedException ignored) {
			}
		}
		interrupt(thread);
		return !expired;
	}

	private Instant start(final Thread thread) {
		thread.start();
		return Instant.now();
	}

	private void interrupt(final Thread thread) {
		thread.interrupt();
	}

	private boolean isAlive(final Thread thread) {
		return thread.isAlive();
	}
}
