package javaapplication1;

public class LogLine {
    int counter;
    public LogLine(int counter)
    {
        this.counter = counter;
    }

    public String GetIP()
    {
        return "ip-" + counter;
    }
}
