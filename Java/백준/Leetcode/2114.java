class Solution {
    public int mostWordsFound(String[] sentences) {
        int max_word_num = 0;
        for (int i = 0; i < sentences.length; i++) {
            int word_num = 0;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ')
                    word_num++;
            }
            if (word_num > max_word_num)
                max_word_num = word_num;
        }
        return max_word_num + 1;
    }
}