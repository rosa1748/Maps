public class NBody {
	public static void main(String[] args){
		StdAudio.play("audio/2001.mid");
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		double time = 0.0;
		while(time < T){
			double[] xforces = new double[planets.length];
			double[] yforces = new double[planets.length];

			for(int i = 0; i < planets.length; i++){
				double xforce = planets[i].calcNetForceExertedByX(planets);
				double yforce = planets[i].calcNetForceExertedByY(planets);
				xforces[i] = xforce;
				yforces[i] = yforce;
				planets[i].update(dt, xforce, yforce);
				StdDraw.picture(0, 0, "images/starfield.jpg");

				for(Planet p : planets){
					p.draw();
				}

				StdDraw.show(10);
				time = time + dt;

			}
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
		}

	}

	public static double readRadius(String fileName){
		In in = new In(fileName);
		int numPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int numPlanets = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numPlanets];

		for(int i = 0; i < numPlanets; i++){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();
			planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, name);

		}

		return planets;
	}
}