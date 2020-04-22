package ie.tudublin;

import processing.data.TableRow;


public class Task extends Gantt
{
    private String phase;
    private int start;
    private int end;

    public Task(String phase, int start, int end)
    {
        this.phase = phase;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr)
    {
        this(
            tr.getString("Task"),
            tr.getInt("Start"),
            tr.getInt("End")
        );
    }

    //Getters and Setters
    public void setPhase(String phase)
    {
        this.phase = phase;
    }

    public String getPhase()
    {
        return phase;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getStart()
    {
        return start;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public int getEnd()
    {
        return end;
    }

    public String toString()
    {
        return phase + "  " + start + "  " + end + "  ";
    }
}