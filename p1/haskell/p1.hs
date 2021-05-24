import System.Environment

p1 limit = sum [ n | n <- [1..(limit - 1)],
                     or [mod n 3 == 0,
                         mod n 5 == 0]]

main = do
    args <- getArgs
    print $ p1 $ read $ head args
