class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        for letter in ransomNote:
            magazine_temp = magazine.replace(letter, "", 1)
            if len(magazine_temp) == len(magazine):
                return False
            magazine = magazine_temp
        return True