class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = [[p,s] for p,s in zip(position,speed)]
        stack = []
        for p, s in sorted(pair)[::-1]:
            if not stack:
                stack.append((target-p)/s)
            if stack and (target-p)/s > stack[-1]:
                stack.append((target-p)/s)
        return len(stack)
                


                    


            


        