class Trie {
	Trie[] child;
	int w;

	public Trie() {
		child = new Trie[26];
		w = 0;
	}

	void addString(String s, int w) {
		Trie t = this;
		for (int i = 0; i < s.length(); i++) {
			if (t.child[s.charAt(i) - 'a'] == null) {
				t.child[s.charAt(i) - 'a'] = new Trie();
			}
			t = t.child[s.charAt(i) - 'a'];
		}
		t.w = w;
	}
}
