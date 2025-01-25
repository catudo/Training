public class TimeConversion {

    public static String timeConversion(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        String secondString = split[2];
        String time = secondString.substring(2, secondString.length());
        String second = secondString.substring(0,secondString.length() - 2);

        StringBuilder sb = new StringBuilder();

        if(time.equals("PM")) {
            hour  = (hour != 12 )? hour +12:hour  ;
            sb.append(hour).append(":").append(split[1]).append(":").append(second);
        } else  {
            String stringHour ="";

            if(hour  < 10 ) {
                stringHour = "0"+hour;
            } else if (hour == 12) {
                stringHour ="00";
            }else {
                stringHour = String.valueOf(hour);
            }

            sb.append(stringHour).append(":").append(split[1]).append(":").append(second);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:45:54PM"));
    }

}
