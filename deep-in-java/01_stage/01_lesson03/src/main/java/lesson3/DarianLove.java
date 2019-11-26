package lesson3;


import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static lesson3.DarianLove.MAN_NAME_STATIC;
import static lesson3.DarianLove.WEMEN_NAME_STATIC;

/***
 * This is the love history of Mr. Zhu and Miss Chen.
 *
 * @since 2019.05.20
 * @author ZhuRenJie
 */
public class DarianLove {


    public static void main(String[] args) {
        EventConstructor();
        customerSoutLoveEvent();
    }

    public static void EventConstructor() {
        addLoveEvent(new LoveEvent().setDateTime("2019-05-03")
                .setEvent("第一次见面")
                .setMrZhuEvent("Hello")
                .setMissChenvent("Hello"));
        addLoveEvent(new LoveEvent().setDateTime("2019-05-20")
                .setEvent("Say never to be separated"));
    }



    public static List<LoveEvent> loveEventList = new LinkedList<>();

    public static String MAN_NAME_STATIC = "Mr.Zhu";
    public static String WEMEN_NAME_STATIC = "Miss Chen";

    public static void addLoveEvent(LoveEvent loveEvent) {
        loveEventList.add(loveEvent);
    }


    public static void customerSoutLoveEvent() {
        Collections.sort(loveEventList);
        System.out.println();
        System.err.println("Mr.Zhu And Miss Chen Love forever");
        System.out.println();
        loveEventList.forEach(System.out::println);
    }
}


@Getter
class LoveEvent implements Comparable<LoveEvent> {
    private Date dateTime;
    private String manName;
    private String WemenName;
    private List<String> events;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = sdf.format(dateTime);

        String toString = dateString + "     " +
                "    " + manName + "\'" +
                " && '" + WemenName + "\'\n";
        for (String event : events) {
            toString += ("          " + event + "\n");
        }
        return toString;
    }

    /***
     * dateTimeStringType "yyyy-mm-dd"
     * @param dateTime
     * @return
     */
    public LoveEvent setDateTime(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(dateTime);
            this.dateTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoveEvent() {
        this.manName = MAN_NAME_STATIC;
        this.WemenName = WEMEN_NAME_STATIC;
        this.events = new ArrayList<>();
    }

    public LoveEvent setEvent(String event) {
        events.add(event);
        return this;
    }

    public LoveEvent setMrZhuEvent(String event) {
        events.add(MAN_NAME_STATIC + ": " + event);
        return this;
    }

    public LoveEvent setMissChenvent(String event) {
        events.add(WEMEN_NAME_STATIC + ": " + event);
        return this;
    }


    @Override
    public int compareTo(LoveEvent o) {
        if (this.dateTime.getTime() > o.getDateTime().getTime()) {
            return 1;
        } else if (this.dateTime.getTime() < o.getDateTime().getTime()) {
            return -1;
        } else {
            return 0;
        }
    }
}
