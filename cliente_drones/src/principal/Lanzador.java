package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import graficos.JControl;
import threads.HiloDron;

public class Lanzador {

	public static void main(String[] args) {
		String url="ws://localhost:8080/servidor_drones/dron";
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new HiloDron("dron1",url));
		executor.submit(new HiloDron("dron2",url));
		executor.submit(new HiloDron("dron3",url));
		new JControl("dron1",100);
		new JControl("dron2",500);
		new JControl("dron3",900);
	}

}
