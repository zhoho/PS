class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String check : skill_trees) {
            check = check.replaceAll("[^"+skill+"]", "");
            answer += skill.indexOf(check)==0 ? 1 : 0;
        }
        
        return answer;
    }
}