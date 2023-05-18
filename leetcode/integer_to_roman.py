class Solution:

    numerals = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000,
        # Half steps
        "IV": 4,
        "IX": 9,
        "XL": 40,
        "XC": 90,
        "CD": 400,
        "CM": 900
    }

    def romanToInt(self, s: str) -> int:
        result = 0
        while len(s) > 0:
            if s[:2] in self.numerals:
                result += self.numerals[s[:2]]
                s = s[2:]
            else:
                result += self.numerals[s[:1]]
                s = s[1:]
        return result