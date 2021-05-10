package solutions;

import java.util.*;

/**
 * Given an array of strings products and a string searchWord.
 * We want to design a system that suggests at most three product names from products
 * after each character of searchWord is typed.
 * Suggested products should have common prefix with the searchWord.
 * If there are more than three products with a common prefix return the three
 * lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 */
public class _1268_SearchSuggestions {

    private static class TrieNode<Character> {
        Character ch;
        Map<Character, TrieNode<Character>> children;
        PriorityQueue<String> possibleWords;
        boolean isEnd;
        TrieNode(Character ch) {
            this.ch = ch;
            this.children = new HashMap<>();
            this.possibleWords = new PriorityQueue<>(Collections.reverseOrder());
            this.isEnd = false;
        }
    }

    private TrieNode<Character> root;

    public _1268_SearchSuggestions() {
        this.root = new TrieNode<>('\0');
    }

    public void addWord(String word) {
        TrieNode<Character> curr = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            }
            else {
                TrieNode<Character> temp = new TrieNode<>(ch);
                curr.children.put(ch, temp);
                curr = temp;
            }
            curr.possibleWords.offer(word);
            if(curr.possibleWords.size() > 3) {
                curr.possibleWords.poll();
            }
        }
        curr.isEnd = true;
    }

    public List<String> searchByPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode<Character> curr = root;
        for(char ch : prefix.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return words;
            curr = curr.children.get(ch);
        }

        PriorityQueue<String> pq = curr.possibleWords;
        while(!pq.isEmpty()) {
            words.add(0, pq.poll());
        }
        return words;
    }

    List<Character> getAllMatchingWords(String prefix) {
        List<Character> words = new ArrayList<>();
        TrieNode<Character> curr = root;
        for(char p : prefix.toCharArray()) {
            if(!curr.children.containsKey(p))
                return words;
            curr = curr.children.get(p);
        }
        dfs(curr, words);
        return words;
    }

    private void dfs(TrieNode<Character> node, List<Character> matchingWords) {
        if(null == node)
            return;
        for(TrieNode<Character> tn : node.children.values()) {
            dfs(tn, matchingWords);
            if(tn.isEnd)
                matchingWords.add(0, tn.ch);
        }
    }

    public static void main(String[] args) {
        _1268_SearchSuggestions obj = new _1268_SearchSuggestions();
        obj.addWord("mobile");
        obj.addWord("mouse");
        obj.addWord("moneypot");
        obj.addWord("monitor");
        obj.addWord("mousepad");

        List<Character> mWords = obj.getAllMatchingWords("mo");
        System.out.println(mWords);

        String searchWord = "mouse";
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < searchWord.length(); i++) {
            sb.append(searchWord.charAt(i));
            res.add(obj.searchByPrefix(sb.toString()));
        }
        System.out.println(res);
    }

}
