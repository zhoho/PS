//릿코드 솔루션 참고
class Solution {
    public String convertToTitle(int columnNumber) {

        String str = "";

        while (columnNumber > 0) {
            columnNumber -= 1;
            str = (char) ('A' + (columnNumber % 26)) + str;
            columnNumber /= 26;
        }
        return str;
    }
}
