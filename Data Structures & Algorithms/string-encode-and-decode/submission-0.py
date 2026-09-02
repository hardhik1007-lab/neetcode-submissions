class Solution:
    def __init__(self):
        self.count = {}
    def encode(self, strs: List[str]) -> str:
        self.count={}
        s=""
        index=0
        for i in range(len(strs)):
            length = len(strs[i])
            self.count[i] = (index, index + length)  
            s += strs[i]
            index += length
        return s
    def decode(self, s: str) -> List[str]:
        res=[]
        for i in self.count:
            start,end = self.count[i]
            res.append(s[start:end])
            
        return res