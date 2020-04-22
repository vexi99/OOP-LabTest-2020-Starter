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

	public void drawPhases()
	{
		//drawPhases works by getting the name of the Tasks from the CSV file, looping through the arraylist to print each to output.
		
		//x1 and y1 variables for text
		int x1 = 40;
		int y1 = 90;
		
		for (Task task : tasks)
		{
			//for loop to iterate through arrayList
			String s = task.getPhase();
	
			textSize(15);
			textAlign(LEFT);
			text(s , x1, y1);
			y1 += 50;
		}
	}

	public void drawDays()
	{
		int x1 = 150;
		int y1 = 30;
		int i = 1;
		String s;

		//Loop to print out each day number using a for loop.
		for (i=1; i<31;i++)
		{
			s = intToString(i);
			textAlign(CENTER, CENTER);
			text(s, x1, y1);
			x1 += 21;
		}
	}

	public void drawLine()
	{
		//drawLine method used to draw the day lines on the graph.
		int x1 = 150;
		int y1 = 60;
		int lineEnd = 550;
		int strokeVal = 255;

		for(int i = 0; i<30; i++)
		{
			stroke(strokeVal);
			line(x1,y1,x1,lineEnd);
			x1 += 21;

			//126 added to val as it is halfway point, modulo 255 to allow the grey and white colour on lines
			strokeVal = (strokeVal + 126) % 255;
		}
	}	
	
	public String intToString(int a)
	{
		//converts an integer to a string to pass back to drawDays.
		String s = Integer.toString(a);
		return s;
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
		drawPhases();
		drawDays();
		drawLine();
	}
}
