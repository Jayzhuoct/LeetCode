package medium;

public class T208实现Trie前缀树 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // 返回 true
        System.out.println(trie.search("app")); // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 true
    }

    static class Trie {
        private Trie[] children;  // Trie树的子节点数组，用于存储子节点的引用
        private boolean isEnd;    // 表示当前节点是否为单词的结尾节点

        public Trie() {
            children = new Trie[26];  // 初始化子节点数组，假设只包含小写字母
            isEnd = false;           // 初始化isEnd为false
        }

        // 插入一个单词到Trie树中
        public void insert(String word) {
            Trie node = this;  // 从根节点开始插入
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);               // 获取当前字符
                int index = ch - 'a';                    // 计算当前字符的索引，假设只包含小写字母
                if (node.children[index] == null) {     // 如果当前字符的子节点为空，创建一个新的子节点
                    node.children[index] = new Trie();
                }
                node = node.children[index];            // 移动到下一个节点
            }
            node.isEnd = true;                           // 将最后一个节点标记为单词的结尾节点
        }

        // 搜索一个单词是否存在于Trie树中
        public boolean search(String word) {
            Trie node = searchPrefix(word);  // 先搜索前缀，然后判断最后一个节点是否为单词的结尾节点
            return node != null && node.isEnd;
        }

        // 判断是否存在以给定前缀开头的单词
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        // 搜索以给定前缀开头的节点
        private Trie searchPrefix(String prefix) {
            Trie node = this;  // 从根节点开始搜索
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);               // 获取当前字符
                int index = ch - 'a';                      // 计算当前字符的索引，假设只包含小写字母
                if (node.children[index] == null) {       // 如果当前字符的子节点为空，返回null
                    return null;
                }
                node = node.children[index];              // 移动到下一个节点
            }
            return node;                                  // 返回搜索到的节点
        }
    }

}
