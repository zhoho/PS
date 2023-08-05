class Solution {
    public int dayOfYear(String date) {
        String[] ymd = date.split("-");
        int[] day_of_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);

        for (int i = 0; i < month - 1; i++) {
            day += day_of_month[i];
        }

        if ((month > 2) && (year % 400 == 0 || year % 100 == 0 || year % 4 == 0))
            day++;
        if ((year % 400 != 0) && (year % 100 == 0))
            day--;
        return day;
    }
}
