//time complexity: O(n)
//space complexity: O(n)
//executed on leetcode: yes
//if we encounter a number, update num value
// if we encounter a charatcer, we manipulate based on last sign
//on last index also, we manipulate based on last sign
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack= new Stack<Integer>();
        int num = 0;
        char last_sign = '+';
        int n = s.length();
        int result = 0;
        for(int i=0;i<n;++i)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num * 10 + c - '0';
            if((!Character.isDigit(c) && c!=' ')|| i==n-1)
            {
                if(last_sign=='+') stack.push(num);
                else if(last_sign=='-') stack.push(-num);
                else if(last_sign=='*') stack.push(stack.pop()*num);
                else stack.push(stack.pop()/num);
                last_sign = c;
                num = 0;
            }
        }
        while(!stack.isEmpty()) result+=stack.pop();
        return result;
    }
}