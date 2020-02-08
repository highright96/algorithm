#include <iostream>
#include <string>
using namespace std;
bool check(string s) {
	//cout << s;
	int length = s.length();
	int mid = length / 2;
	if (mid%2 == 0) {
		for (int l = 0, r = length - 1; l <= mid - 1 && r >= mid; l++, r--)
			if (s[l] != s[r]) return false;
	}//Â¦¼ö
	else {
		for (int l = 0, r = length - 1; l <= mid && r >= mid; l++, r--)
			if (s[l] != s[r]) return false;
	}//È¦¼ö
	return true;
}
int main(){
	int tc; cin >> tc;
	for (int t = 0; t < tc; t++) {
		string s[100];
		bool ck1 = false, ck2 = false;
		int n;
		cin >> n;
		for (int i = 0; i < n; i++) cin >> s[i];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ck1 = check(s[i] + s[j]); ck2 = check(s[j] + s[i]);
				if (ck1) {
					cout << s[i] + s[j] << endl;
					break;
				}
				else if (ck2) {
					cout << s[j] + s[i] << endl;
					break;
				}
			}
			if (ck1||ck2) break;
		}
		if (!ck1&&!ck2) cout << "0" << endl;
	}
	return 0;
}