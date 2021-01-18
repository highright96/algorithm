#include<iostream>
#include <utility>
#include <vector>
using namespace std;
#define MAX 300

pair<int, int> getdot(vector<int> &arr, int a) {
	int xpos = 1, ypos = 0, val = 0;
	pair<int, int> p;
	for(int i = 1; i<MAX; i++){ 
		if (arr[i] > a) {
			ypos = i - 1; 
			val = arr[i-1];
			break;
		}//대각선의 가장 작은값 찾기
		else if (arr[i] == a) {
			p.first = 1; p.second = i;
			return p;
		}//찾는값이 대각선의 가장 작은값일 경우
	}
	while (1) {
		if (val == a) break;
		xpos++; ypos--; val++;
	}
	p.first = xpos; p.second = ypos;
	return p;
}
int main()
{
	vector<int> arr(MAX, 1); int a = 0, cnt = 0;
	for (int i = 2; i < MAX; i++) {
		cnt++; arr[i] = arr[i - 1] + cnt;
	}
	int t = 0;
	cin >> t;
	for (int ch = 0; ch < t; ch++) {
		int val1, val2, rypos=0, result = 0; //rypos 결과 y좌표값
		cin >> val1 >> val2;
		pair<int, int> p1, p2, p3;
		p1 = getdot(arr,val1); //점숫자를 보고 좌표값찾기
		p2 = getdot(arr,val2);
		p3.first = p1.first + p2.first;
		p3.second = p1.second + p2.second;
		rypos = p3.first + p3.second - 1;
		result = arr[rypos] + p3.first - 1;
		cout << result << endl;
	}
	return 0;
}