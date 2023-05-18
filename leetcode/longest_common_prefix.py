from functools import reduce

class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        sstr = ""
        if len(strs) == 0:
            return sstr
        elif len(strs) == 1:
            return strs[0]
        else:
            i = 0
            shortest = len(min(strs, key=len))
            while i < shortest:
                if not self.letter_check(strs[1:], strs[0][i], i):
                    break
                sstr += strs[0][i]
                i += 1

            return sstr
    
    def letter_check(self, strs: list[str], letter: str,  index: int) -> bool:
        return reduce(lambda x, y: x and y, map(lambda x: x[index] == letter, strs))