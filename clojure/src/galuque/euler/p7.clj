(ns galuque.euler.p7
  (:gen-class)
  (:require [galuque.euler.utils :as utils]))

(comment
  (time
   (nth (utils/sieve) 10000))
  ;; "Elapsed time: 123.332973 msecs"
  ;; => 104743
  )

(defn -main [n]
  (let [primes (utils/sieve) 
        n'     (Long/parseLong n)]
    (println (nth primes n'))))