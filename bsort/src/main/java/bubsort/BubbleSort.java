package bubsort;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/**
 * Hello world!
 *
 */
public class BubbleSort
{

    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) 
    {
        FileHandler fh = null;
        Logger logger = Logger.getAnonymousLogger();
        logger.setUseParentHandlers(false);
        try{
        fh = new FileHandler("C:\\Обучение\\Java\\bsort\\src\\main\\java\\bubsort\\log.txt");
        }
        catch (IOException e)
        {
            System.out.println("ha ha");
        }
        logger.addHandler(fh);
        //SimpleFormatter sf = new SimpleFormatter();
        MyFormatter mf = new MyFormatter();
        fh.setFormatter(mf);
        int temp1 = 0;
        int[] tempmas1 = new int[mas.length];
        int[] tempmas2 = new int[mas.length];
        int temp2 = 0;
        int temp3 = 0;
        boolean isSorted = false;
        int buf;
        while(!isSorted) 
        {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) 
            {
                if(mas[i] > mas[i+1])
                {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
            logger.info(Arrays.toString(mas));
        }
                                
        fh.close();  // меняем местами наименьший с array[i]
    }
        
        

   // 4, 8, 3, 1, 9

    static int max(int[] mas)
    {
        int max = 0;
        for(int i=0;i<mas.length;i++)
        {
            if (mas[i]>max)
            {
                max = mas[i];
            }
        }
        return max;


    }
    

   static Boolean isSorted(int[] mas)
   {
    Boolean isSort = false;
    for (int k=0;k<mas.length-1;k++)
    {
        if (mas[k]>mas[k+1])
        {
            return false;
        }
    }
    return true;
   }
}

class MyFormatter extends Formatter {
    // Create a DateFormat to format the logger timestamp.
    Date dt = new Date();
    Calendar ca;
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    LocalDateTime now = LocalDateTime.now();  
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        //builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        //builder.append("[").append(record.getSourceClassName()).append(".");
        //builder.append(record.getSourceMethodName()).append("] - ");
        //builder.append("[").append(record.getLevel()).append("] - ");
        //builder.append(ca.getTimeInMillis());
        builder.append(dtf.format(now));
        builder.append(" ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }
}

/*for (int i =0;i<mas.length-1;i++)
{
     if (isSorted(mas))
    {
        break;
    }
    for (int j=mas.length-1;j>i;j++)
    {
        if (mas[j] < mas[j-1])
        {
            temp = mas[j-1];
            mas[j-1] = mas[j];
            mas[j] = temp;
            
        }
        
    }
   
    logger.info(Arrays.toString(mas));

}*/