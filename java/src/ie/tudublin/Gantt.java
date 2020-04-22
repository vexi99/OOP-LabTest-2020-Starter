package ie.tudublin;

import processing.core.PApplet;

import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for (TableRow tr : t.rows())
		{
			Task task = new Task(tr);
			tasks.add(task);
		}
	}

	public void printTasks()
	{
		println("Printing Tasks:");

		for (Task task : tasks)
		{
			println(task.toString());
			//println(task.getPhase() + '\t' + task.getStart() + '\t' + task.getEnd() + '\n');
		}
	}

	public void displayTasks()
	{
		//setting of HSB colour mode for background
		colorMode(HSB, 100);


	}

	public void drawBackground()
	{
		for (Task task : tasks)
		{
			//for loop to iterate through arrayList
			task.getPhase();

		}


	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{	
		background(0);
		drawBackground();
		//start of writing names
		
	}
}
