package ¹¹Ôì;

public class ×ÖµäÊ÷ {
	class Trie {
	    public boolean isWord;
	    public char word;
	    Trie[] tries=new Trie[26];
	    
	    /** Initialize your data structure here. */
	    public Trie() {
	        this.isWord=false;
	        this.word=' ';
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word){
	        char[] tmp=word.toCharArray();
	        Trie root =this;
	        for(int i=0;i<tmp.length;i++){
	            if(root.tries[tmp[i]-'a']==null){
	                root.tries[tmp[i]-'a']=new Trie();
	            }
	            root=root.tries[tmp[i]-'a'];
	            root.word=tmp[i];
	            if(i==tmp.length-1)
	                root.isWord=true;
	            
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        char[] tmp=word.toCharArray();
	        Trie root= this;
	        for(int i=0;i<tmp.length;i++){
	            if(root.tries[tmp[i]-'a']!=null){
	                root=root.tries[tmp[i]-'a'];
	                if(root.word==tmp[i]){
	                    continue;
	                }else{
	                    return false;
	                }
	            }else{
	                return false;
	                }
	    }
	        return root.isWord==true?true:false;
	}
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        char[] tmp=prefix.toCharArray();
	        Trie root= this;
	        for(int i=0;i<tmp.length;i++){
	            if(root.tries[tmp[i]-'a']!=null){
	                root=root.tries[tmp[i]-'a'];
	                if(root.word==tmp[i]){
	                    continue;
	                }else{
	                    return false;
	                }
	            }else{
	                return false;
	                }
	    }
	        return true;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
