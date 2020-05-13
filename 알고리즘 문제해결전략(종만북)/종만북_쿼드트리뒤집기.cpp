#include <iostream>
#include <vector>
using namespace std;

string s;
string Reverse(string::iterator& itr)
{
    char head = *(itr);

    ++itr;
    if (head == 'b' || head == 'w') return string(1, head);

    string upperleft = Reverse(itr);
    string upperright = Reverse(itr);
    string lowerleft = Reverse(itr);
    string lowerright = Reverse(itr);

    return string("x") + lowerleft + lowerright + upperleft + upperright;
}

int main() {
	int T = 0;
	cin >> T;
	for (int i = 0; i < T; i++) {
        cin >> s;
        string::iterator itr = s.begin();
        cout << Reverse(itr) << "\n";
	}

	return 0;
}