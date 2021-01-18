#include <iostream>
#include <math.h>
using namespace std;

int N = 0, r = 0, c = 0, cnt = 0;
int solve(int x, int y, int len) {
	if (len < 1) return 0;
	else if (c < x && r < y) //upper left
	{
		x -= len/2;
		y -= len/2;
		solve(x,y,len/2);
	}
	else if (c >= x && r < y) //upper right
	{
		cnt += len * len;
		x += len/2;
		y -= len/2;
		solve(x,y,len/2);
	}
	else if (c < x && r >= y) //lower left
	{
		cnt += len * len * 2;
		x -= len / 2;
		y += len / 2;
		solve(x,y,len/2);
	}
	else// lower right
	{
		cnt += len * len * 3;
		x += len / 2;
		y += len / 2;
		solve(x,y,len/2);
	}
	return 0;
}
int main() {
	cin >> N >> r >> c;
	int len = pow(2, N);
	solve(len / 2, len / 2, len / 2);
	cout << cnt;
	return 0;
}