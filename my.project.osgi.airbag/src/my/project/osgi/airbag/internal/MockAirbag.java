package my.project.osgi.airbag.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import my.project.osgi.airbag.IAirbag;
import my.project.osgi.airbag.IAirbagListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class MockAirbag implements IAirbag {

	private List listeners = new ArrayList();

	private Job job;

	private boolean isRunning;

	public MockAirbag() {
		super();
		listeners = new ArrayList();
	}

	public synchronized void addListener(IAirbagListener listener) {
		listeners.add(listener);
	}

	private synchronized void deploy() {
		for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
			((IAirbagListener) iterator.next()).deployed();
		}
	}

	public synchronized void removeListener(IAirbagListener listener) {
		listeners.remove(listener);
	}

	public void startUp() {
		isRunning = true;
		job = new Job("Moke air bad") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				deploy();
				if (isRunning) {
					schedule(5000);
				}
				return Status.OK_STATUS;
			}

		};
		job.schedule(5000);
	}
	
	public void shutDown(){
		isRunning = false;
		job.cancel();
		try {
			job.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
