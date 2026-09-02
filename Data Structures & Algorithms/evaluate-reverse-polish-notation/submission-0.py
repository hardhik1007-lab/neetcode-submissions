class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack =[]
        
        for t in tokens:
            if t in '+-*/':
                v2 , v1 = stack.pop(),stack.pop()
                if t=='+':
                    res=v1+v2
                if t=='-':
                    res=v1-v2
                if t=='*':
                    res=v1*v2
                if t=='/':
                    res=int(v1/v2)
                stack.append(res)
            else:
                stack.append(int(t))
        return stack[0]