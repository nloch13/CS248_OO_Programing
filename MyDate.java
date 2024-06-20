//Dating Project 2/3 
//Zac Patterson and Nate Loch


public class MyDate implements DateInterface 
{
    private int day;
    private int dow;
    private int month;
    private int year;
    
    public int getDay() 
    {
        return day;
    }
    
    public int getDow() 
    {
        return dow;
    }
    
    public int getMonth() 
    {
        return month;
    }
    
    public int getYear() 
    {
        return year;
    }
    
    public void set(int m, int d, int y, int dow) 
    {
        this.month=m;
        this.day=d;
        this.year=y;
        this.dow=dow;
    }
    
    public void tomorrow() 
    {
        // increment day
        day++;
        
        // check if the next day is in the next month
        int daysInMonth=0;
        switch(month) 
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            daysInMonth=31;
            break;
            case 4: case 6: case 9: case 11:
            daysInMonth=30;
            break;
            case 2:
            if((year%4==0 && year%100 !=0) || year%400==0) 
            {
                daysInMonth=29;
            } else 
            {
                daysInMonth=28;
            }
            break;
        }
        
        if(day>daysInMonth) 
        {
            day=1;
            month++;
        }
        
        // check if the next day is in the next year
        if(month>12) 
        {
            month=1;
            year++;
        }
        
        // increment day of week
        dow=(dow+1)%7;
    }
    
    public String toString() 
    {
        String[] daysOfWeek={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] months={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return daysOfWeek[dow]+ " " +months[month - 1]+" "+day+", "+year;
    }
}
