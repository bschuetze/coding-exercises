class Solution:
    def fizzBuzz(self, n: int) -> list[str]:
        result = []
        if n > 0:
            for i in range(1, n + 1):

                fizz = i % 3 == 0
                buzz = i % 5 == 0
                if not fizz and not buzz:
                    result.append(str(i))
                else:
                    val = ""
                    if fizz:
                        val = "Fizz"
                    if buzz:
                        val += "Buzz"
                    result.append(val)
                
            return result