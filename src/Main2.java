import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main2 extends Thread{


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
        if(this.getName() == "english") {
            if (english == null) {
                english = day.get(random.nextInt(day.size()));
                System.out.println(english + " ");
                Thread.sleep(1000);
            }
        }
        if(this.getName() == "vietnamese"){
            if(english != null) {
                String vietnamese = map.get(english);
                System.out.println(vietnamese);
                english = null;
            }
        }
    }

    public void run(){
        while(true){
            try{
                getDay();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Main2();
        thread1.setName("english");
        Thread thread2 = new Main2();
        thread2.setName("vietnamese");
        thread1.start();
        thread2.start();
    }
}
