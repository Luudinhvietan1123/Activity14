import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main2 implements Runnable{

    public static Map<String, String> map = new HashMap<>();
    public static ArrayList<String> day = new ArrayList<>();
    public static String english = null;

    public Main2(){
        map.put("Monday", "Thứ hai");
        map.put("Tuesday", "Thứ ba");
        map.put("Wednesday", "Thứ tư");
        map.put("Thursday", "Thứ năm");
        map.put("Friday", "Thứ sáu");
        map.put("Saturday", "Thứ bảy");
        map.put("Sunday", "Chủ nhật");
        day.add("Monday");
        day.add("Tuesday");
        day.add("Wednesday");
        day.add("Thursday");
        day.add("Friday");
        day.add("Saturday");
        day.add("Sunday");
    }

    public synchronized void getDay() throws InterruptedException{
        Random random = new Random();
        if(english == null){
            english = day.get(random.nextInt(day.size()));
            System.out.print(english + " ");
        }else{
            String vietnamese = map.get(english);
            System.out.print(vietnamese);
            english = null;
            System.out.println();
        }
        Thread.sleep(1000);
    }

    public void run(){
        try{
            getDay();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Main2 thread1 = new Main2();
        Main2 thread2 = new Main2();
        while(true){
            thread1.run();
            thread2.run();
        }
    }
}
