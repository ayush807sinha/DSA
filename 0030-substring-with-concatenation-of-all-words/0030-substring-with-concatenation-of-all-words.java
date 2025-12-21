class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if(s.length() == 0 || words.length == 0)
            return ans;

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if(s.length() < totalLength)
            return ans;

        HashMap<String,Integer> orgMap = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            orgMap.put(words[i], orgMap.getOrDefault(words[i], 0) + 1);
        }

        for(int offset = 0; offset < wordLength; offset++){

            HashMap<String,Integer> window = new HashMap<>();
            int left = offset;
            int matched = 0;

            for(int right = offset; right + wordLength <= s.length(); right += wordLength){

                String word = s.substring(right, right + wordLength);

                if(orgMap.containsKey(word)){

                    window.put(word, window.getOrDefault(word, 0) + 1);

                    if(window.get(word) <= orgMap.get(word)){
                        matched++;
                    }
                    else{
                        while(window.get(word) > orgMap.get(word)){
                            String leftWord = s.substring(left, left + wordLength);
                            window.put(leftWord, window.get(leftWord) - 1);

                            if(window.get(leftWord) < orgMap.get(leftWord))
                                matched--;

                            left += wordLength;
                        }
                    }

                    if(matched == wordCount){
                        ans.add(left);

                        String leftWord = s.substring(left, left + wordLength);
                        window.put(leftWord, window.get(leftWord) - 1);
                        matched--;
                        left += wordLength;
                    }
                }
                else{
                    window.clear();
                    matched = 0;
                    left = right + wordLength;
                }
            }
        }

        return ans;
    }
}
