-- Solution to Project Euler problem 9
-- By Nayuki Minase


cond a b = a <= b && b <= c
        && a * a + b * b == c * c
        where c = 1000 - a - b
ans = [a * b * (1000 - a - b) | a <- [1..1000], b <- [1..1000], cond a b]
main = putStrLn (show ans)
