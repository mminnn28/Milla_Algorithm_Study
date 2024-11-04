#include <iostream>
#include <string>
#include <cmath> 
using namespace std;

int main() {

    int n;
    cin >> n;

    //길이 구하기
    int len = to_string(abs(n)).length();

    //각 자릿수의 합의 최대
    int v = static_cast<int>(pow(10, len - 1));
    int a = (n / v) * v - 1;
    int sum = 0;
    while (a > 0) {
        sum += a % 10;
        a /= 10;
    }

    int m = n - sum;
    bool flag = true;
    while (m != n) {
        int temp = m;
        sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if ((m + sum) == n) {
            flag = false;
            break;
        }
        m++;

    }

    // 결과 출력
    if (!flag)
        cout << m;
    else
        cout << 0;

}